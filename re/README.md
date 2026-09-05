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
- `case-src/` — charging-case BLE transport (`com.nothing.caseble.*`).
- `dig-matched.tar.gz` — filtered matchup archive produced by the GitHub Actions dig workflow
  (`Nothing-x-open/.github/workflows/dig-directed.yml`).
- `nothing-x-dex.zip` — the eight DEX files of a recent Nothing X release; the raw input used by
  the dig workflow (26 MB, kept for reproducibility).

The files here are derived from a user-installed copy of the Nothing X app for personal
interoperability research.