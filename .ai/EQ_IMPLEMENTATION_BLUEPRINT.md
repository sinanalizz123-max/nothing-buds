> HISTORICAL REPORT — preserved as investigation history. Current structured findings live under `re/` (start at `re/INDEX.md`); see the "Status / Changes Since Previous Report" section at the end of this file.

# Nothing X Equaliser — Implementation Blueprint (2nd pass)

Task source: `/storage/emulated/0/opencode/prompt/1.txt`.
Prior report (source of truth): `.ai/EQ_REVERSE_ENGINEERING.md`.
Status: **investigation only — no application code was modified.**
Only output: this report + a concise proven-vs-unknown summary (§J tail).

## A. Confirmed protocol facts

1. Mode/level writes are 2-byte LE `[value, 0x00]`: `toByteArray$default(v,0,1)`
   forces width 2 (`re/proto-src/.../base/util/ext/DataExtKt.java`, `$default`
   sets `i2=2`; LE loop). Floats are 4-byte LE.
2. Preset writes are ACK-gated (`syncSetResponse`/`setSync`) and then refresh the
   GET cache manually (`TWSDeviceBuilder.java:379`, `:502-516`, `:581`;
   espeon `EqualizerViewModel.java:358-376`; base `…C06742.AnonymousClass1`,
   `BaseEqualizerViewModel.java:687-700`).
3. Reads on screen entry are fire-and-forget (`sendMessage$default`).
4. Re-tapping the selected row sends nothing (early-return in every `setEQMode`).
5. `reportType` (e.g. `"10"`, `"11"`, `DeviceConstant.NOISE_CANCELLATION_*`) is
   analytics/buried-point only (`CHANGE_EQ_EVENT` + `getReportType()`); it never
   reaches the wire. Exact `DeviceConstant` string values were not extracted — UNKNOWN,
   immaterial.
6. F06C/F06D/C06C/C06D have **zero callers** in all extracts: only the
   `ProtocolConstant` declaration tables contain them
   (`re/{case,ldac,proto,control}-src/.../base/protocol/constant/ProtocolConstant.java`).
   `midUnitAdvanceCustomEQMode/Value` builders exist
   (`TWSDeviceExtKt.java:227-256`) but nothing calls them. Which product uses the
   third-driver pair is UNKNOWN.
7. `simpleCustomEQ` builder (0xF041 + `SimpleEQEntity`) has **zero callers**.
8. `EQGainDragBarViewModel.java` is not in the extracts; radar gain min/max is UNKNOWN
   (layouts `eq_gain_item_layout` exist, values do not).

## B. Confirmed model mappings

Runtime chain (`re/control-src/.../device/IOTDeviceManager.java`):
`getProductByModelId(modelId)` scans every registered product's color deviceList
for a matching color `modelId` (`:926-…`, prefers non-`UnknownProduct`);
`getNativeTemplateForModelId` returns that color `IOTDevice` (`:1224-…`);
`getAndCreateIOTDevice(mac, modelId)` clones it per-MAC (`:143-…`).
`getProductByBluetoothName` exists (`:1140-…`) but is only used from `NtEarPlugin`
(case/boxing path), not for EQ screen selection.
Screen selection is compile-time: each product's `IOTDeviceAction.startEqualizerActivity`
launches its own `EqualizerActivity` (e.g. donphan `:52-55`), whose VM is fixed.

| Product | Codename | Colors (`isSupportDirac`) | EQ path |
|---|---|---|---|
| B172 CMF Buds Pro 2 | espeon | Black/White/Orange/Blue | 7-row Dirac VM (Opteo gated by HDAC) |
| B168 CMF Buds | donphan | Black/White/Orange = true (`IOTDonphan.java:30-32`); hoothoot White/Black/Orange = false (`IOTHoothoot{White,Black,Orange}.java:14-15,24-25`) | Dirac VM if `isSupportDirac()` else non-Dirac 7-row variant; **no codec gate anywhere in donphan code** |
| B179 (24232) | girafarig | (no Dirac/capability overrides in product file) | 7-row Dirac VM, Opteo gated by HDAC (`type==0`, no product check) |
| B184 (24241) | gligar | — | 6-row Dirac VM (no Opteo row; gate dead code) |
| B175 Headphone Pro | forretress | — | 6-row Dirac VM (no Opteo row; gate dead code) |
| Ear (2) | ear/two | `supportAdvanceEq()=true` (`IOTProductDeviceEarTwo.java:67-69`) | `EarTwoSimpleEQFragment` (simple rows) + `AdvanceEQViewModel` (8-band) |
| anything else | unknown | cloud `UnknownConfigs`/`UnknownFunction` | `UnknownEqualizerViewModel` / `UnknownSimple*ViewModel` |

Gate matrix: espeon `type==0 && hldcOrDiracOne()` (true on espeon);
girafarig/gligar/forretress `type==0`; donphan none; unknown-simple
`type==0 && hldcOrDiracOne()`. HDAC check = `GET_LHDC_COMMANDS` (0xC029) via
`sendMessageSync`; null/non-zero → `needHDACWarning` dialog, nothing sent;
zero → `sendEqModelData` (`…EqualizerViewModel$getHDACStatus$1$1.java`).

## C. Confirmed UI rows

Columns: Product | UI label | reportType | type | Read source | Write command | Payload | Extra operation.

**B172 (espeon)** — `…/espeon/equalizer/EqualizerViewModel.java:224-249,306-323`:

| Product | UI label | reportType | type | Read source | Write | Payload | Extra |
|---|---|---|---|---|---|---|---|
| B172 | Dirac Opteo | 10 | 0 | C050 | F01D | `[00 00]` | HDAC gate + `DiracEQGuideDialog` + HDAC warn dialog |
| B172 | Pop | 7(=ANC_ADAPTIVE const) | 3 | C050 | F01D | `[03 00]` | — |
| B172 | Rock | 6 | 1 | C050 | F01D | `[01 00]` | — |
| B172 | Classical | 8 | 5 | C050 | F01D | `[05 00]` | — |
| B172 | Electronic | 5(=ANC_TRANSP const) | 2 | C050 | F01D | `[02 00]` | — |
| B172 | Enhance Vocals | 9 | 4 | C050 | F01D | `[04 00]` | — |
| B172 | Custom | 4(=ANC_OFF const) | 6 | C050 | F01D | `[06 00]` | selects stored curve (curve bytes via §E.1) |

**B179 (girafarig)** — identical 7 rows/types/commands; Opteo reportType `11`;
same F01D/C050; HDAC gate `type==0` without product check.

**B168 (donphan)** — `…/donphan/equalizer/EqualizerViewModel.java:226-…,250-…,317-323`:
`isSupportDirac()=true` → Opteo 0 (reportType `10`), Rock 1, Electronic 2,
Pop 3, Classical 5, Enhance 4, Custom 6 — all F01D `[type 00]`, read C050,
**no gate**. `=false` (hoothoot colors) → `hasDiracEq=false`, rows:
Dirac EQ **7** (reportType `11`), Pop 3, Rock 1, Electronic 2, Enhance 4,
Classical 5, Custom 6 — all F01D, read C050, no gate.

**B184/B175 (gligar/forretress)** — Pop 3, Rock 1, Electronic 2, Enhance 4,
Classical 5, Custom 6 — all F01D `[type 00]`, read C050, no Opteo row.

**Simple models (base)** — `BaseEqualizerViewModel.java:824-833` + `initSimpleEQItem`
(`IOTProductDevice.java:617-…`): Balanced 0, More Bass 3, More Treble 2,
More Voice 1, Custom 5 (iff `getIsSupportCustomEQ()`) — all F010 `[type 00]`,
read C01F via `BaseSppProtocol.setEQMode/getEQMode`
(`BaseSppProtocol.java:233-280`).

**Ear (2)** — simple rows via `initSimpleEQItem` + 8-band advanced editor
(`AdvanceEQViewModel`, profiles/undo/redo/wave chart); `EarTwoSimpleEQFragment`
source not extracted.

**Unknown** — `UnknownSimpleActivityViewModel`: `isSupportDiracEq()` false →
simple ordinals 0/3/2/1/6(NEW_VOICE)/7(NEW_INSTRUMENT)/5(Custom), F010, read C01F;
true → `DiracOpteoEQ` ordinals with (reportType,type) pairs
`(10,0),(11,7),(12,8),(4,3),(6,1),(7,2),(9,4),(8,5),(5,6)`, F01D, read C050;
Opteo row hidden unless cloud `diracByPowered()` (`:706-712`);
gate `type==0 && hldcOrDiracOne()`; writes branch on `isSupportDiracEq()` (`:873-902`).

## D. Confirmed command/payload table

Columns: Operation | GET | SET | Payload | Response | Product | Evidence.

| Operation | GET | SET | Payload (SET) | Response | Product | Evidence |
|---|---|---|---|---|---|---|
| Dirac preset select | 0xC050 (49232) | 0xF01D (61469) | `[type, 00]`, type 0-8 | ACK + `BasicInt` readback via `updateEQMode` | B172/B168/B179/B184/B175/unknown-Dirac | `TWSDeviceExtKt.java:25,32,321-328`; §C VMs |
| Standard preset select | 0xC01F (49183) | 0xF010 (61456) | `[mode, 00]`, `EQModeEntity.Mode` 0-7 | ACK + `BasicInt` readback | simple/unknown-simple/Ear2-simple | `TWSDeviceExtKt.java:26,33,282-289`; `BaseSppProtocol.java:243-280`; `EQModeEntity.java:24-32` |
| HDAC/codec check | 0xC029 (49193) | — | — | `BasicInt`: 0=proceed else warn-dialog | espeon/girafarig/(gligar/forretress dead)/unknown | `…$getHDACStatus$1$1.java`; `ProtocolConstant.java:130` |
| Product custom curve (3-band) | 0xC044 (49220) | 0xF041 (61505) | `CustomEQ` 5+n·16 (worked example §E.1) | ACK + cache refresh + `updateCustomEQValue` | all Dirac VMs + simple models | `TWSDeviceExtKt.java:27,554-561`; `BaseEqualizerViewModel.java:323-408,712-737,771-821,835-866`; `CustomEQ.java:41-…,…:138-151` |
| Advance custom mode flag | 0xC04C (49228) | 0xF04F (61519) | `[ON=01, 00]` | ACK | supportAdvanceEq products, unknown-generic | `TWSDeviceExtKt.java:23,30,167-175`; `…advanceTab$1$1.java:74-87`; `UnknownEqualizerViewModel.java:180,254-256` |
| Advance custom values (8-band) | 0xC04D (49229, getPayload `[profileIndex]`) | 0xF050 (61520) | `EQEntity` 6+n·13 | ACK | supportAdvanceEq products (Ear 2) | `TWSDeviceExtKt.java:24,31,187-195`; `AdvanceEQViewModel.java:1785`; `EQEntity.java:184-223` |
| Third-driver custom mode | 0xC06C (49260) | 0xF06C (61548) | `[mode, 00]` (builder; no caller) | UNKNOWN | UNKNOWN | `TWSDeviceExtKt.java:227-237`; `ProtocolConstant.java:57-58,158-159` |
| Third-driver custom value | 0xC06D (49261) | 0xF06D (61549) | `EQEntity.obtainDataPacket()` (builder; no caller) | UNKNOWN | UNKNOWN | `TWSDeviceExtKt.java:249-256` |
| Simple custom entity | 0xC044 | 0xF041 | `SimpleEQEntity` 5+n·13 (builder; no caller) | UNKNOWN | UNKNOWN | `TWSDeviceExtKt.java:266-273`; `SimpleEQEntity.java` |

## E. Custom EQ systems

**E.1 Product 3-band editor (B172/B168/B179/B184/B175 + simple models).**
Radar items Mid(type 1)/Treble(type 2)/Bass(type 0) (`BaseEqualizerViewModel.java:169`).
`setCustomEQ` → `CustomEQ.Companion.obtainDataPacket(-maxGain, [EQ(type,gain,freq,Q)])`
(`:712-737,779`) → `customEQValue` SET 0xF041 (`:781-789`;
`syncSetResponse` + GET-cache refresh + `onUpdate`, `:804-815`).
Packet: `[count][totalGain f32 LE][type(1),gain f32,freq f32,Q f32 ×n]`.
Freq/Q: Dirac VMs 140/0.8, 980/0.66, 3500/1.0 (espeon `:71-76,:457-480`;
identical in girafarig/gligar/forretress/donphan); simple 140/0.8, 980/0.7, 6900/1.0
(base `:545-567`; `IOTProductDeviceEspeon.getSimpleCustomEQParameter`, `:105-118`).
`totalGain` = −(max band gain), always recomputed.
*Worked example (source-derived, espeon, gains Bass +2.0 / Mid 0.0 / Treble −1.0):*
`totalGain=−2.0`; 53-byte packet
`[03][C0000000? no: −2.0 LE = 00 00 00 C0][00,00000040,00000C43,CDCC4C3F][01,00000000,00007544,2935D13F][02,000080BF,00005B45,0000803F]`
i.e. count 3, then per band (type, gain, freq, Q) as LE floats
(Bass type 0/140 Hz/Q 0.8; Mid type 1/980/Q 0.66; Treble type 2/3500/Q 1.0).
Gain min/max: UNKNOWN (drag-bar VM not extracted).
Type-6 recall sends F01D `[06 00]` only — no extra operations
(same `sendEqModelData` path as all rows).

**E.2 `SimpleEQEntity` (0xF041/0xC044)** — `[count][totalGain f32][filterType,gain,freq,Q ×n]`
= 5+n·13; builder `simpleCustomEQ` has no callers: dead/legacy in these extracts.

**E.3 8-band advanced editor** — `EQEntity`: 55/110/220/440/1320/3300/6600/13200 Hz,
LOW_SHELF 0/PEAK 1/HIGH_SHELF 2, `DEFAULT_Q=1.0`, `[profileIndex][count][totalGain]…`
(`EQEntity.java:29-40,184-223`); `sendProfileDataToDevice` → F050
(`AdvanceEQViewModel.java:1732-…,1785`); mode ON via F04F (advanceTab `:74-87`);
readback of mode C04C; value GET C04D takes getPayload `[profileIndex]`
(`TWSDeviceExtKt.java:187-195`). Products: `supportAdvanceEq()=true` (Ear 2 family).
Profile-index semantics beyond passthrough: UNKNOWN. Gain range: UNKNOWN.

## F. Remaining unknowns

1. `EqualizerTypeViewModel` class source (ctor/field semantics usage-inferred).
2. `DeviceConstant` reportType string values (analytics-only, immaterial).
3. `WhenMappings` ordinal→case tables (unknown-device enum attribution).
4. Third-driver 0xF06C/0xF06D product/user (no callers in extracts).
5. Radar gain min/max (`EQGainDragBarViewModel` not extracted).
6. `EQEntity.profileIndex` semantics; advance-editor gain range.
7. B168 HDAC behaviour on real hardware (code has no gate; untested against buds).
8. `eqMutuallyExclusive`/`spaceEqExclusive` runtime effects; `GET_ADAPTIVE_EQ_MODE`
   0xC043 role; `EarTwoSimpleEQFragment` rows; corsola/heracross EQ UI.

## G. Evidence references (file + line)

- `re/dirac-src/.../espeon/equalizer/EqualizerViewModel.java:62-76` (level/freq consts),
  `:122-213` (C050 read), `:224-249` (rows + gate), `:306-323,358-376` (F01D write +
  cache refresh), `:431-447` (row re-mark + `sendEqModelData`), `:449-480` (HDAC + freq/Q)
- `re/ldac-src/.../espeon/equalizer/EqualizerViewModel$getHDACStatus$1$1.java`
  (C029 gate: null/≠0 → warn dialog; 0 → write)
- `re/dirac-src/.../core/ext/TWSDeviceExtKt.java:23-34` (all EQ command IDs),
  `:155-195` (advance builders), `:227-289` (third-driver/simple/`eqMode`),
  `:321-328` (`diracOpteoEQ`), `:554-561` (`customEQValue`)
- `re/dirac-src/.../core/entity/EQModeEntity.java:24-32,50-58,81-87`
- `re/proto-src/.../core/entity/{EQEntity.java:29-40,66-99,184-223,
  AdvanceCustomEQEntity.java, SimpleEQEntity.java}`
- `re/proto-src/.../earbase/equalizer/entity/CustomEQ.java` (5+n·16; `:138-151` writer)
- `re/dirac-src/.../earbase/equalizer/viewmodel/BaseEqualizerViewModel.java:169`
  (radar), `:313-321` (register), `:323-501` (C044/C01F reads), `:569-577,616-627,680-704`
  (F010 write + cache), `:712-821` (custom write), `:824-933` (simple rows + updates)
- `re/control-src/.../earbase/spp/BaseSppProtocol.java:233-284`
  (C01F read, F010 write); `.../espeon/core/protocol/EspeonSppProtocol.java`
  (no EQ override — dual/time only)
- `re/dirac-src/.../{girafarig,gligar,forretress,donphan}/.../EqualizerViewModel.java`
  (rows/gates/writes per §C); donphan `:226-…` branch, `:250-…,317-323` gateless write
- `re/dirac-src/.../device/IOTDevice.java:107` (`isSupportDirac=false` base);
  `.../donphan/core/device/IOTDonphan.java:30-32` (true);
  `.../hoothoot/core/device/IOTHoothoot{White,Black,Orange}.java` (false)
- `re/control-src/.../device/IOTDeviceManager.java:64-119` (registry),
  `:143-…` (clone per MAC), `:926-…` (modelId→product), `:1140-…` (BT-name path),
  `:1224-…` (native template)
- Product IDs: espeon `.../IOTProductDeviceEspeon.java:37-41`;
  donphan/girafarig/gligar/forretress/corsola/heracross control-src product files;
  `IOTProductDeviceEarTwo.java:67-69` (`supportAdvanceEq`)
- `.../espeon/equalizer/EqualizerActivity.java:106-130` (guide dialog),
  `:240-…` (HDAC observer → `ConfirmMsgDialog`), `:318-332`
  (`onClickType→setEQMode`, `onChange→setCustomEQ`); donphan activity `:60,111,264`
- `.../earbase/unknown/UnknownSimpleActivityViewModel.java:240-360` (C050/C01F branch),
  `:654-712` (Dirac pairs + Opteo visibility), `:775-902` (gate + F01D/F010 branch),
  `:1059-1062` (HDAC); `UnknownProduct.java:736-…` (`diracByPowered`)
- `re/proto-src/.../base/protocol/constant/ProtocolConstant.java:31,34,57-58,101,110,119,130,158-159`
- `re/proto-src/.../base/util/ext/DataExtKt.java` (`toByteArray` int/float)
- `re/proto-src/.../protocol/device/TWSDeviceBuilder.java:189-201,339-379,483-516,581`
- `re/proto-src/.../earbase/equalizer/viewmodel/AdvanceEQViewModel.java:149-…,:869,:1007,:1726-…,1785,:2171,:2238,:2307`
  (mode read, profile send → F050)
- `.../earbase/equalizer/activity/BaseEqualiserActivity$onInit$advanceTab$1$1.java:62-99`
  (F04F ON write)
- `log/nothingbuds_20260906_155244.log:71` (`EQ Preset: BALANCED`), `:106`
  (`0x4050 payload 04` → Enhance Vocals)

## H. Current app deviations (master @ 6dd675a)

1. EQ screen on Dirac models exposes standard presets + Opteo + sliders only:
   official states 1–5,7,8 and type-6 recall have no row; real C050=4 (as logged)
   is unrepresentable and the subtitle hides it.
2. `SET_ADVANCED_EQ_MODE/VALUES = 0xF06C/0xF06D` are the official *third-driver*
   commands, which have no callers anywhere in the extracts.
3. `setCustomEq` (8 raw `[gain+6]` bytes on 0xF06D) matches no official custom
   format (0xF041 float struct or 0xF050 float struct).
4. `setEq` 2-byte `[preset, 00]` shape: CORRECT per §A.1.
5. B179 marked non-Dirac in our table; officially full Dirac screen — UNVERIFIED.
6. LDAC-block on Opteo matches espeon/girafarig; donphan has no gate — B168
   behaviour UNVERIFIED on hardware.

## I. Proposed implementation architecture (no code written)

- `DeviceProfile`: per-PRODUCT_ID record — `eqSystem` (`DIRAC_F01D` | `SIMPLE_F010`
  | `ADVANCE` | `UNKNOWN`), `diracRows: List<DiracRow(type,label,reportType,gated)>`,
  `hasOpteo`, `hdacGate: NONE | TYPE0 | TYPE0_HLDC_OR_DIRAC_ONE`,
  `customBands: 3-UINT (freq/Q per product) | ADV_8 | NONE`,
  `supportAdvanceEq`, `diracCapableByDefault` + per-color `isSupportDirac` override
  (hoothoot-false pattern).
- `EqState`: **two** authoritative fields — `eqMode: Int?` (last C01F) and
  `diracLevel: Int?` (last C050); UI selection = Dirac row iff the active
  profile is a Dirac product AND `diracLevel` maps to a row, else standard row
  from `eqMode`. Never merge into one enum. Disagreement (C01F≠C050 mapping)
  displays the Dirac row (C050 wins on Dirac products) and keeps both values.
- Builders: `setDiracEq(type)` F01D `[t,00]`; `setEqMode(mode)` F010 `[m,00]`;
  `setSimpleCustom3Band(gains[], freqs[], Qs[], totalGain)` F041 `CustomEQ`;
  `setAdvanceMode(ON/OFF)` F04F; `setAdvanceValues(EQEntity)` F050;
  third-driver builders stay **out** until a caller/product is proven.
- Flows: entry → fire C050 (+C044) on Dirac products, C01F (+C044) on simple;
  tap → reselect-guard → HDAC gate iff row.type==0 per product rule →
  `syncSetResponse` → on ACK update the matching cache + single-row selection;
  drag → `CustomEQ` packet → F041 `syncSetResponse` → cache + radar refresh.
- Custom representation: `CustomCurve { bands: List<Type,GainF,FreqF,QF>, totalGainF }`;
  totalGain always recomputed as −max(gain).

## J. Exact implementation checklist

1. Add `DeviceProfile` table: B172/B168(+hoothoot-false)/B179/B184/B175/Ear2/unknown
   with rows/gates/custom per §C–§E; mark F-items UNKNOWN where §F says so.
2. Split state into `eqMode` (C01F) + `diracLevel` (C050); keep both; C050 wins
   for selection on Dirac profiles.
3. Restore rows 1–5 (+6 recall, +7 where donphan-non-Dirac) writing F01D `[t,00]`;
   keep Opteo HDAC dialog on espeon/girafarig rules; none on donphan.
4. Reimplement custom write as F041 `CustomEQ` float struct with per-product
   freq/Q (§E.1) + worked-example unit test; drop raw-byte 0xF06D path.
5. Rename our `0xF06C/0xF06D` constants to third-driver names or remove until proven.
6. Add F04F/F050 + `EQEntity` support behind `supportAdvanceEq` (Ear 2 only).
7. Verify on hardware: B168 gate behaviour, B179 Dirac screen, C050=1..8 selection,
   custom round-trip C044→UI→F041, type-6 recall effect.
8. Keep `reportType` out of the wire path (analytics only).

**Proven vs still unknown.** Proven: full per-product row tables with types;
F01D-all-rows + 2-byte payloads; C050/C01F/C044/C04C-C04D/C029 command map;
HDAC-gate logic per product; click/read/cache/ACK flows; all three custom-EQ
packets; product-selection chain (modelId→product→action→Activity/VM);
hoothoot-false and type-7 donphan branches; zero-caller status of F06C/F06D and
`simpleCustomEQ`. Still unknown: §F items 1–8 (type-VM source, reportType strings,
WhenMappings attribution, third-driver product, gain limits, profileIndex/gain-range
semantics, B168-gate-on-hardware, exclusivity flags/0xC043/EarTwo-fragment/corsola-heracross UI).

*End of report. No implementation files were changed for this task.*

## Status / Changes Since Previous Report (2026-09-06 consolidation)

Detail moved to `re/` section docs (`re/INDEX.md`); this file stays as the
2nd-pass historical record. Changes:
- Hoothoot corrected to product B185 (not a B168 variant).
- Unknown Dirac pairs corrected per `WhenMappings` (see `re/EQ/EQ_UI_ROWS.md`).
- New: full product-selection chain, gate matrix, zero-caller proof for
  F06C/F06D + `simpleCustomEQ`, cloud bitmask schema, advance-EQ adopters,
  corsola B163 (own EQ activity, not extracted) and heracross B187
  (no EQ package; distinct from espeon/B172) status.
