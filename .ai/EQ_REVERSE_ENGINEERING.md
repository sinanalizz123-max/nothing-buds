> HISTORICAL REPORT — preserved as investigation history. Current structured findings live under `re/` (start at `re/INDEX.md`); see the "Status / Changes Since Previous Report" section at the end of this file.

# Nothing X Equaliser — Reverse-Engineering Report

Task source: `/storage/emulated/0/opencode/prompt/1.txt`.
Status: **investigation only — no application code was modified.**
Extracts used: `re/dirac-src`, `re/proto-src`, `re/ldac-src`, `re/control-src`, `re/case-src`
(all decompiled from the official Nothing X APK; `re/README.md`).

Reference log: `log/nothingbuds_20260906_155244.log` (real CMF Buds Pro 2, B172).

## 0. Product-code → ViewModel mapping (CONFIRMED FROM NOTHING X SOURCE)

| Codename | `PRODUCT_ID` | Device / BT name | EQ ViewModel |
|---|---|---|---|
| espeon | B172 | Buds Pro 2 / CMF Buds Pro 2 | `com.nothing.espeon.equalizer.EqualizerViewModel` |
| donphan | B168 | Buds / CMF Buds | `com.nothing.donphan.equalizer.EqualizerViewModel` |
| girafarig | B179 | 24232 | `com.nothing.girafarig.equalizer.EqualizerViewModel` |
| gligar | B184 | 24241 | `com.nothing.gligar.equalizer.EqualizerViewModel` |
| forretress | B175 | Headphone Pro / 24211 | `com.nothing.forretress.core.equalizer.EqualizerViewModel` |
| corsola | B163 | Buds Pro | (no EQ VM in extracts — UNKNOWN) |
| heracross | B187 | 24253 | (no EQ VM in extracts — UNKNOWN) |
| ear/two | Ear (2) | ear (2) | `EarTwoSimpleEQFragment` + `supportAdvanceEq()=true` |
| unknown | any other | — | `com.nothing.earbase.unknown.UnknownEqualizerViewModel` |

Evidence: `re/dirac-src/.../espeon/core/device/IOTProductDeviceEspeon.java:37-41,69-70,88`
(`PRODUCT_ID="B172"`, fast-pair `F29566/CA36A6/A7B220/2B353E`, BT `CMF Buds Pro 2`);
`re/control-src/.../donphan/core/device/IOTProductDeviceDonphan.java:37,50-51,67`
(`B168`, `CMF Buds`); `.../girafarig/.../IOTProductDeviceGirafarig.java:41,59-60,74`
(`B179`); `.../gligar/.../IOTProductDeviceGligar.java:40,63-64,77` (`B184`);
`.../forretress/.../IOTProductDeviceForretress.java:51,119-120,136` (`B175`);
`.../corsola/.../IOTProductDeviceCorsola.java:31,39-40,65` (`B163`);
`.../heracross/.../IOTProductDeviceHeracross.java:44` (`B187`);
`re/control-src/.../ear/two/core/device/IOTProductDeviceEarTwo.java:67-69,71-73`
(`supportAdvanceEq()=true`, `ear (2)`).

## 1. Equaliser UI

- One screen per product: `com.nothing.<codename>.equalizer.EqualizerActivity`
  (espeon/donphan/girafarig variants; espeon file is 334 lines).
  `UnknownEqualizerActivity` covers unrecognised models.
- Click path (espeon, `EqualizerActivity.java:318-332`):
  preset tap → `onClickType(typeViewModel)` → `viewModel.setEQMode(typeViewModel)`;
  radar drag → `onChange(index, value)` → `viewModel.setCustomEQ(index)`.
  The activity implements `OnEQChangeListener`; radar data flows VM→UI via
  `vRadar.setRadarList(list)` (`onInitObserver$lambda$4`).
- Selected-state logic lives in the VM, not the activity:
  base `updateEQMode()` sets exactly one row `selected=true` by `type` match
  (`BaseEqualizerViewModel.java:922-931`); after a successful write the row list is
  re-marked (`espeon …AnonymousClass1.C01611.invokeSuspend`, `…/EqualizerViewModel.java:431-438`;
  base `…C06742.AnonymousClass1`, `BaseEqualizerViewModel.java:687-700`).
  Re-tapping the already-selected row sends nothing (early-return in every
  `setEQMode`, e.g. espeon lines 239-243).
- Bass/Mid/Treble visualisation: 3-item radar list built in the base constructor —
  Mid(type 1), Treble(type 2), Bass(type 0) (`BaseEqualizerViewModel.java:169`);
  rendered by `vRadar` / `EQDragView` / `EQWaveformView`
  (`re/dirac-src/com/nothing/base/wiget/...`).
- Custom UI: the same radar with per-band gain is the custom editor; the 8-band
  advanced editor (profiles, undo/redo, wave chart) is `AdvanceEQViewModel`
  (`re/proto-src/.../earbase/equalizer/viewmodel/AdvanceEQViewModel.java`, 2434 lines).
- Model-specific branches: donphan `EqualizerActivity` checks
  `iOTDevice.isSupportDirac()` to decide whether the Dirac screen may open
  (`donphan/.../EqualizerActivity.java:60,111`); donphan VM keeps a
  `hasDiracEq` observable for the same purpose.
- First-entry guide: each Dirac product shows its `DiracEQGuideDialog` on init
  (espeon `EqualizerActivity.java:106-130`; donphan/girafarig equivalents exist).
- HDAC warning: `needHDACWarning` LiveData → `ConfirmMsgDialog`
  (espeon `onInitObserver$lambda$7`; per-product `WarnEqualizerTypeViewModel`).

## 2. `initSoundTypes` — exact rows per product (CONFIRMED)

`EqualizerTypeViewModel(reportType, label, type, icon, …)`; only `type` reaches the wire.

**espeon (B172)** — `…/espeon/equalizer/EqualizerViewModel.java:224-233`, 7 rows:

| # | Label | type |
|---|---|---|
| 1 | Dirac Opteo (`dirac_eq_opteo_new`, reportType `10`) | 0 |
| 2 | Pop | 3 |
| 3 | Rock | 1 |
| 4 | Classical | 5 |
| 5 | Electronic | 2 |
| 6 | Enhance Vocals | 4 |
| 7 | Custom | 6 |

**girafarig (B179)** — same 7 rows/types, Opteo reportType `11`
(`…/girafarig/equalizer/EqualizerViewModel.java`, same lines).

**donphan (B168)** — branches on `iOTDevice.isSupportDirac()`
(`…/donphan/equalizer/EqualizerViewModel.java:226-…`):
- Dirac supported: Opteo 0 (reportType `10`, string `dirac_eq_opteo`), Rock 1,
  Electronic 2, Pop 3, Classical 5, Enhance Vocals 4, Custom 6.
- Not supported: `hasDiracEq=false`, then **Dirac EQ type 7**
  (reportType `11`, string `dirac_eq`), Pop 3, Rock 1, Electronic 2,
  Enhance Vocals 4, Classical 5, Custom 6.

**gligar (B184) / forretress (B175)** — 6 rows, **no Opteo row**:
Pop 3, Rock 1, Electronic 2, Enhance Vocals 4, Classical 5, Custom 6
(gligar `…/EqualizerViewModel.java:202-…`; forretress `…/core/equalizer/EqualizerViewModel.java:201-…`).

**Base (simple-EQ models)** — `BaseEqualizerViewModel.java:824-833`:
Balanced 0, More Bass 3, More Treble 2, More Voice 1, Custom 5 (only if
`getIsSupportCustomEQ()`). `SimpleEqualizerViewModel` delegates to
`IOTProductDevice.initSimpleEQItem(isSystemPage, isSupportCustomEQ)`
(`…/IOTProductDevice.java:617-…`), which builds exactly this list.

**Unknown devices** — `UnknownEqualizerViewModel.initSoundTypes` (`:498-…`):
non-Dirac configs map ordinals → Balanced 0, More Bass 3, More Treble 2,
More Voice 1, NEW_VOICE 6, NEW_INSTRUMENT 7, Custom 5; Dirac configs map
`DiracOpteoEQ` ordinals to (reportType, type) pairs incl. `(10,0)`, `(11,7)`,
`(12,8)`, `(4,3)`, `(6,1)`, `(7,2)`, `(9,4)`, `(8,5)`, `(5,6)`.
(The `WhenMappings` ordinal→case table was not in the extracts, so the
enum-name↔pair attribution is UNKNOWN; the pairs themselves are confirmed.)

## 3. Click → wire, per preset (CONFIRMED)

All Dirac-family VMs (`espeon`, `girafarig`, `gligar`, `forretress`, `donphan`):
`setEQMode()` → `sendEqModelData()` →
`TWSDeviceExtKt.diracOpteoEQ(twsDevice, type)` →
`syncSetResponse(setCommand, setPayload)` + manual cache refresh of the GET command.

| UI preset | Official state ID (`type`) | B172/B168/B179/B184/B175 write | Exact payload | Extra ops |
|---|---|---|---|---|
| Dirac Opteo | 0 | SET 0xF01D | `[0x00, 0x00]` | HDAC gate (see §4); buried-point `CHANGE_EQ_EVENT` |
| Rock | 1 | SET 0xF01D | `[0x01, 0x00]` | none |
| Electronic | 2 | SET 0xF01D | `[0x02, 0x00]` | none |
| Pop | 3 | SET 0xF01D | `[0x03, 0x00]` | none |
| Enhance Vocals | 4 | SET 0xF01D | `[0x04, 0x00]` | none |
| Classical | 5 | SET 0xF01D | `[0x05, 0x00]` | none |
| Custom (recall) | 6 | SET 0xF01D | `[0x06, 0x00]` | selects stored curve; curve itself is written via §6 |
| Dirac EQ (donphan non-Dirac row) | 7 | SET 0xF01D | `[0x07, 0x00]` | none (no HDAC gate in donphan) |

Evidence: espeon `sendEqModelData` coroutine
(`…/espeon/equalizer/EqualizerViewModel.java:306-323`: `diracOpteoEQ(tws, type)` then
`syncSetResponse(setCommand, getSetPayload(), …)`); builder
(`…/core/ext/TWSDeviceExtKt.java:321-328`):
`setSetCommand(SET_DIRAC_OPTEO_EQ)` +
`setSetPayload(toByteArray(type,0,1))` + `getCommand(GET_DIRAC_OPTEO_EQ)`;
constants `GET_DIRAC_OPTEO_EQ=49232` (`:25`), `SET_DIRAC_OPTEO_EQ=61469` (`:32`);
donphan write core (`…/donphan/equalizer/EqualizerViewModel.java:317-323`, identical);
gligar/forretress/girafarig `sendEqModelData` identical
(gligar `:284`, forretress `:283`, girafarig `:307`).

Simple-EQ models (base path): `BaseSppProtocol.setEQMode()`
(`re/control-src/.../earbase/spp/BaseSppProtocol.java:243-280`) writes
`eQMode` = SET 0xF010 payload `[mode, 0x00]`:

| UI preset | `type` | Write | Payload |
|---|---|---|---|
| Balanced | 0 | SET 0xF010 | `[0x00, 0x00]` |
| More Voice | 1 | SET 0xF010 | `[0x01, 0x00]` |
| More Treble | 2 | SET 0xF010 | `[0x02, 0x00]` |
| More Bass | 3 | SET 0xF010 | `[0x03, 0x00]` |
| Custom (simple) | 5 | SET 0xF010 | `[0x05, 0x00]` |

`EQModeEntity.Mode` adds `DIRAC_EQ=4, NEW_VOICE=6, NEW_INSTRUMENT=7`
(`re/dirac-src/.../core/entity/EQModeEntity.java:24-32`; parse `:50-58`;
`obtainDataPacket` `:81-87`).

Payload shape: `DataExtKt.toByteArray$default(v, 0, 1, null)` forces width 2,
so every mode/level write is 2-byte LE `[v, 0x00]`
(`re/proto-src/.../base/util/ext/DataExtKt.java`: `$default` sets `i2=2`;
`toByteArray(int,i2)` LE loop; `toByteArray(float)` = 4-byte LE).

## 4. Codec gate (CONFIRMED)

`getHDACStatus(typeVM)` sends `GET_LHDC_COMMANDS` (0xC029) via `sendMessageSync`;
if the reply is null or `value != 0` it posts
`needHDACWarning(WarnEqualizerTypeViewModel(true, typeVM))` (→ `ConfirmMsgDialog`,
nothing is sent); if `value == 0` it calls `sendEqModelData(typeVM)`
(`re/ldac-src/.../espeon/equalizer/EqualizerViewModel$getHDACStatus$1$1.java`).
Gate conditions differ:
- espeon: `type == 0 && productDevice.hldcOrDiracOne()` (`:244`);
  espeon `hldcOrDiracOne()=true` (`IOTProductDeviceEspeon.java:59-61`).
- girafarig/gligar/forretress: `type == 0` only (no product check);
  gligar/forretress have no type-0 row, so the gate is dead code there.
- donphan: **no gate at all** (writes `diracOpteoEQ` unconditionally).
- `GET_LHDC_COMMANDS = 49193` = 0xC029
  (`re/proto-src/.../base/protocol/constant/ProtocolConstant.java:130`).

## 5. READ path (CONFIRMED)

- Dirac VMs: `getEQData()` reads `diracOpteoEQ` GET 0xC050, parses `BasicInt`,
  calls `updateEQMode(value)` → selects the row whose `type` matches
  (espeon `:122-213`; same pattern gligar `:100-…`, forretress `:99-…`,
  girafarig `:122-…`, donphan `:124-…`, unknown `:300-312`).
- Base/simple: `getEQData()` reads `eQMode` GET 0xC01F
  (`BaseEqualizerViewModel.java:416-501`); `BaseSppProtocol.getEQMode()` (`:233-240`).
- Custom curve: base reads `customEQValue` GET 0xC044 → `CustomEQ`
  (`BaseEqualizerViewModel.getCustomEQData`, `:323-408`).
- Advance mode flag: unknown/generic reads `advanceCustomEQMode` GET 0xC04C
  (`UnknownEqualizerViewModel.java:180,254-256`).
- Unknown VM additionally runs `getConfig()` (spatial-audio read, `:778-…`).

Authoritative response per model: 0xC050 on espeon/donphan/girafarig/gligar/forretress;
0xC01F on simple-EQ models. 0xC06C/0xC06D are the **third-driver (mid-unit)**
advance-custom reads, not the first-driver ones (§6).

## 6. CUSTOM EQ (CONFIRMED — three separate systems)

**A. Product EQ-screen custom editor (B172/B168/B179/B184/B175 + simple models).**
`setCustomEQ(index)` builds `CustomEQ.obtainDataPacket(-maxGain, [EQ(type,gain,freq,Q) ×3])`
from the radar items and writes `customEQValue` = **SET 0xF041**
(`BaseEqualizerViewModel.java:712-737,771-821`; builder
`TWSDeviceExtKt.java:554-561`: `setCommand(61505)` / `getCommand(49220)`).
`CustomEQ` wire format (`re/proto-src/.../earbase/equalizer/entity/CustomEQ.java`):
`[count(1)][totalGain f32][per band: filterType(1), gain f32, freq f32, Q f32]`
= 5 + count·16 bytes; filter types LOW_SHELF 0, PEAK 1, HIGH_SHELF 2
(+LOW_PASS 3, HIGH_PASS 4). Per-model freq/Q come from `getFreq`/`getQ`:
- espeon/girafarig/gligar/forretress/donphan: 140 Hz/Q 0.8, 980 Hz/Q 0.66, 3500 Hz/Q 1.0
  (espeon `:71-76`, `:457-480`; identical constants in the other four VMs).
- base/simple: 140/0.8, 980/0.7, 6900/1.0 (`BaseEqualizerViewModel.java:545-567`),
  same numbers in `IOTProductDeviceEspeon.getSimpleCustomEQParameter`
  (`:105-118`) and `IOTProductDeviceEarTwo`.
`SET_CUSTOM_EQ = 61505` = 0xF041, `GET_CUSTOM_EQ_VALUE = 49220` = 0xC044
(`ProtocolConstant.java:31,110`). `SimpleEQEntity` (count, totalGain f32,
per-band type/gain/freq/Q = 5 + count·13) rides the same 0xF041/0xC044 pair
(`simpleCustomEQ`, `TWSDeviceExtKt.java:266-273`).

**B. 8-band advanced editor (only `supportAdvanceEq()==true` products, e.g. Ear (2)).**
`AdvanceEQViewModel.sendProfileDataToDevice` writes
`advanceCustomEQValue(tws, profileIndex, EQEntity)` = **SET 0xF050**
(`…/AdvanceEQViewModel.java:1732-…`, builder call at `:1785`).
`EQEntity` (`re/proto-src/.../core/entity/EQEntity.java`): `SIZE=8` (`:40`);
default freqs 55/110/220/440/1320/3300/6600/13200 (`:29`); packet
`[profileIndex(1)][count(1)][totalGain f32][per band: type(1), gain f32, freq f32, Q f32]`
= 6 + count·13 (`:184-223`; parse `:66-99`).
Mode flag: `advanceCustomEQMode(ON)` = **SET 0xF04F** `[0x01, 0x00]`
(advanceTab, `BaseEqualiserActivity$onInit$advanceTab$1$1.java:74-87`).
`AdvanceCustomEQEntity.Mode = OFF(0)/ON(1)` (`AdvanceCustomEQEntity.java`).
Constants: GET 0xC04C / SET 0xF04F (mode); GET 0xC04D / SET 0xF050 (value)
(`TWSDeviceExtKt.java:23-24,30-31`).

**C. Third-driver (mid-unit) advance custom pair.**
`midUnitAdvanceCustomEQMode/Value` = GET 0xC06C / SET **0xF06C** (mode),
GET 0xC06D / SET **0xF06D** (value) (`TWSDeviceExtKt.java:227-256`;
`ProtocolConstant.java:57-58,158-159`). No caller for these builders was found
in the extracts — which product uses them is UNKNOWN.

So on B172/B168, Custom is a Dirac curve in the UI sense only insofar as the
recall selector is F01D type 6; the curve bytes are the 3-band **0xF041** format.

## 7. DIRAC (CONFIRMED)

- `DiracEqPreset` in our code maps 1:1 to the official `type` values on the
  Dirac VMs (0 Opteo … 6 Custom), verified against all five `initSoundTypes`.
- The `DiracOpteoEQ` enum (`re/dirac-src/.../earbase/unknown/entity/DiracOpteoEQ.java:10-19`)
  lists DIRAC_OPTEO, OPTEO, ROCK, ELECTRONIC, POP, ENHANCE_VOCALS, CLASSICAL,
  CUSTOM_EQ, IMMERSION_BOOST — used by the generic unknown-device path with
  (reportType, type) pairs incl. `(11,7)` and `(12,8)`; exact enum-name↔pair
  attribution is UNKNOWN (`WhenMappings` not extracted).
- donphan exposes an extra level **7** ("Dirac EQ" row) on non-Dirac hardware,
  written as F01D `[0x07, 0x00]`.
- gligar/forretress (B184/B175) run the whole 6-row EQ through F01D despite
  having no Opteo row — i.e. on those models F01D *is* the entire equalizer.

## 8. Model capabilities (CONFIRMED)

- `IOTProductDevice` defaults: `eqMutuallyExclusive()=false`,
  `spaceEqExclusive()=false`, `supportAdvanceEq()=false`
  (`re/dirac-src/.../device/IOTProductDevice.java:107,191,195`).
  espeon/donphan/girafarig do not override them (no match in their files).
  `supportAdvanceEq()=true` only on EarTwo (`…/IOTProductDeviceEarTwo.java:67-69`).
- `isSupportDirac()` exists on `IOTDevice` (`…/device/IOTDevice.java:107`);
  donphan gates its Dirac UI on it.
- Dirac models still register the base custom-EQ read (0xC044) alongside 0xC050
  (base `register()`, `BaseEqualizerViewModel.java:313-321`).
- espeon function components attach `EqualizerComponents` at order 620
  (`IOTProductDeviceEspeon.java:151`).

## 9. Transport semantics (CONFIRMED)

`TWSDeviceBuilder` (`re/proto-src/.../protocol/device/TWSDeviceBuilder.java`):
`setCommand()`→SET id (`:349-355`), `getCommand()`→GET id (`:339-347`),
`setSync(payload)` = acknowledged write (`:379`), `setASync` = fire-and-forget
(`:502-516`), `sendMessage$default` = fire-and-forget read (`:581`).
Preset writes use `syncSetResponse(...)` (ACK-gated) then manually refresh the
GET cache (`espeon …:358-376`; base `:690,699`).

## 10. Consistency check vs our B172 log + our implementation

Captured (`log/nothingbuds_20260906_155244.log`):
`Parsed response - command: 0x4050, payload: 04` → `Dirac EQ: preset=4`
(`:106`); prefs `last_dirac_eq=4`; header `eq=BALANCED, dirac=4`.
Per §3/§5, C050=4 means the earbuds are on **Enhance Vocals** while the
standard mode reads BALANCED — exactly the dual-state the official UI merges
into one 7-row list, and exactly what the first prompt's device log showed
(Opteo/Rock/Electronic/Pop/Enhance/Classical/Custom all → F01D).

Deviations of our current `master` implementation from the above findings:
1. Our EQ screen on Dirac models offers only standard presets + Opteo + sliders.
   Official states 1–6 (Rock/Electronic/Pop/Enhance/Classical/Custom-recall) have
   no row, so a real C050=1..6 (like the logged `04`) is unrepresentable —
   our subtitle falls back to the standard preset name, hiding the real state.
2. Our `Commands.kt` `SET_ADVANCED_EQ_MODE/VALUES = 0xF06C/0xF06D` equal the
   official **third-driver** commands; the first-driver advance pair is
   0xF04F/0xF050. Neither is used by any Dirac product in the extracts.
3. Our `setCustomEq` sends 8 raw bytes `[gain+6]` on 0xF06D, which matches none
   of the official custom formats (0xF041 `CustomEQ` 5+n·16 float struct;
   0xF050 `EQEntity` 6+n·13 float struct).
4. Our F010 payload `[preset, 0x00]` shape is CORRECT (official is 2-byte LE).
5. `girafarig` (B179) has a full 7-row Dirac screen in Nothing X, although our
   model table marks B179 as non-Dirac — treat our B179 flags as UNVERIFIED.
6. donphan (B168) has no HDAC gate and an extra type-7 row; our LDAC-block on
   Opteo matches espeon/girafarig but is UNVERIFIED for B168 specifically.

## 11. Verdict buckets

**A. CONFIRMED FROM NOTHING X SOURCE** — everything in §0–§9 cited file:line
above (preset rows/types per product, F01D-all-rows on Dirac VMs, 2-byte LE
payloads, command IDs, read commands, three custom-EQ systems and their
packets, HDAC-gate logic + per-product conditions, click paths, guide/warning
dialogs, capability flags, transport semantics).

**B. CONFIRMED FROM OUR EARBUD LOGS** — B172 answers C050 with level 4
(`log/…:106`); first prompt's device log showed all seven rows → F01D,
consistent with §3.

**C. INFERENCE / UNCERTAIN (marked UNKNOWN above)** —
`EqualizerTypeViewModel` constructor/field semantics (class file not extracted;
usage-inferred);
`DeviceConstant.NOISE_CANCELLATION_*` reportType string values (analytics only);
`WhenMappings` ordinal→case attribution in the unknown-device Dirac list;
which product uses the third-driver 0xF06C/0xF06D pair;
B179 Dirac support in our model table; B168 HDAC-gate behaviour;
`eqMutuallyExclusive`/`spaceEqExclusive` runtime effects (referenced by
`UnknownEqualizerViewModel`, bodies not traced);
`GET_ADAPTIVE_EQ_MODE` 0xC043 role in EQ (not traced).

*End of report. No implementation files were changed for this task.*

## Status / Changes Since Previous Report (2026-09-06 consolidation)

Superseded in detail by `re/INDEX.md` and section docs (start at `re/INDEX.md`).
Corrections to this report:
- "Hoothoot = B168 variant" shorthand was imprecise: hoothoot is its own product
  **B185** (`IOTProductDeviceHoothoot`), reusing the donphan action/VM with
  `isSupportDirac()=false` on all colors.
- Unknown-device enum-name↔(reportType,type) attribution was shifted by one;
  `WhenMappings` (`UnknownEqualizerViewModel.java:95-169`) resolves it:
  IMMERSION_BOOST→(12,8), DIRAC_OPTEO→(11,7), OPTEO→(10,0), POP→(4,3), ROCK→(6,1),
  ELECTRONIC→(7,2), ENHANCE_VOCALS→(9,4), CLASSICAL→(8,5), CUSTOM_EQ→(5,6).
- Newly proven since: product-selection chain (`IOTDeviceManager`), per-product
  HDAC-gate matrix (donphan: none), F06C/F06D + `simpleCustomEQ` zero-caller
  status, cloud bitmask schema (`UnknownFunction`), advance-EQ product list
  (Ear 2/3, EarTwos, Elekid), corsola/heracross EQ-unknown status.
