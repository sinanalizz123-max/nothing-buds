# Reverse engineering sources (Nothing X)

Locally extracted/decompiled sources from the official Nothing X Android app,
used purely to reverse engineer the earbuds protocol for this project.

They are **not** part of the production app — the `re/` directory is kept
separately from `app/` and is never packaged or compiled into any APK.

## Layout

- `dirac-src/` — Dirac Opteo EQ sources (`com.nothing.{espeon,girafarig,donphan,...}/equalizer`,
  `com.nothing.core.ext.TWSDeviceExtKt`, `com.nothing.device.IOTProductDevice`, …). This is what
  tells us the EQ runs as one *preset row* (Dirac Opteo = level 0 of the 0xC050/0xF01D packet),
  with the other rows (Pop/Rock/Classical/Electronic/Enhance Vocals/Custom) unaffected by LDAC.
- `ldac-src/` — LDAC/HDAC related sources, including the `getHDACStatus` gate that the official
  app applies only to the Dirac Opteo row.
- `case-src/` — charging-case BLE transport (`com.nothing.caseble.*`). Findings:
  - Case connects as its own BLE peripheral: service `0000fd90-0000-1000-8000-00805f9b34fb`,
    write `68745353-1810-4b13-83a2-c1b21b652c9b`, notify `ca235943-1810-45e6-8326-fc8ca3bc45ce`.
    Raw passthrough goes over this link in `NtCaseBleApi` (Flutter/Pigeon host API keyed by ear MAC).
  - Box LED (case light) commands on the main protocol:
    - `GET_BOX_LED_COLOR = 0xC017`, `SET_BOX_LED_COLOR = 0xF00D`.
    - `DeviceBoxLed` payload layout: `[count, (type, R, G, B) x count]` (parsed via
      `DataExtKt.toMultiValues(bytes, 1,1,1,1,1)` → count then per-slot type/r/g/b).
    - Slot types: 1 low battery, 2 medium, 3 high, 4 charging, 5 charging full, 6 pairing.
    - `obtainDataPacket()` sends this same layout; our `parseCaseLed` now matches it
      (commit `a6cc370`).
  - Case battery/docked states can also arrive over the Boxing transport (`NtBoxingApi`) in current
    releases; the `caseble` link advertised manufacturer `0x0056`.
- `control-src/` — touch-control / smart-dial sources (`com.nothing.*.control.*`,
  `com.nothing.*.core.device.IOTEar*GestureAction`, `ControlGestureViewModel`,
  `ControlItemViewModel`, `SmartDialUtil`, `ControlConfigurationEntity`). Key facts:
  - Everything (earbud slots + case button + smart dial) is one key-config packet
    `[count, (device, button, gesture, operation) x count]` via 0xC018/0xF003; device 1=case,
    2=left, 3=right.
  - `supportSmartDial()` true only on Espeon (B172) + Heracross.
  - Per-model trigger sets and dial assignment lists (espeon case: single {2,9,8,11,17},
    hold {22,11,17}, double {3,25,1}, triple {26,1}, rotate {23=volume control,1}) — full write-up
    in `control-and-smart-dial.md` on the Nothing-x-open re/ docs.
- `dig-matched.tar.gz` — filtered matchup archive produced by the GitHub Actions dig workflow
  (`Nothing-x-open/.github/workflows/dig-directed.yml`); now includes the control-src tree.
- `nothing-x-dex.zip` — the eight DEX files of a recent Nothing X release; the raw input used by
  the dig workflow (26 MB, kept for reproducibility).

The files here are derived from a user-installed copy of the Nothing X app for personal
interoperability research.