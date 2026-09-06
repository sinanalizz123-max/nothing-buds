# EQ UI Rows per Product (Nothing X, source-verified)

`EqualizerTypeViewModel(reportType, label, type, icon, …)` — only `type` reaches
the wire; `reportType` is analytics (`CHANGE_EQ_EVENT`). Row order = list order.
(Order, label → reportType → type | read | write | payload | extra.)

`DeviceConstant.java` is absent from the extracts, so the string values of
`NOISE_CANCELLATION_ADAPTIVE / _TRANSPARENCY / _OFF` are not directly readable.
They are pinned by cross-model literal consistency: the unknown-cloud Dirac
pairs use literals Pop→(4,3), Electronic→(7,2), Custom→(5,6) while product VMs
use the constants for exactly those rows (and literals 6/8/9/10/11 everywhere
else, all matching). Hence ADAPTIVE="4", TRANSPARENCY="7", OFF="5" at
STRONG EVIDENCE (not CONFIRMED).

## B172 (espeon `EqualizerViewModel.java:224-233`)
Opteo → 10 → 0 | C050 | F01D | `[00 00]` | HDAC gate + guide + warn dialog;
Pop → ADAPTIVE(4*) → 3 | C050 | F01D | `[03 00]`; Rock → 6 → 1 | `[01 00]`;
Classical → 8 → 5 | `[05 00]`; Electronic → TRANSPARENCY(7*) → 2 | `[02 00]`;
Enhance → 9 → 4 | `[04 00]`; Custom → OFF(5*) → 6 | `[06 00]` (recall).

## B179 (girafarig, same file lines)
Same 7 rows/types/commands; Opteo reportType **11**; gate `type==0` (no product check).

## B168 Dirac (donphan `:226-…, isSupportDirac()=true`)
Opteo → 10 → 0; Rock → 6 → 1; Electronic → TRANSPARENCY(7*) → 2; Pop → ADAPTIVE(4*) → 3;
Classical → 8 → 5; Enhance → 9 → 4; Custom → OFF(5*) → 6. All C050/F01D `[t 00]`. No gate.

## B185 Hoothoot — and any B168 unit with `isSupportDirac()=false` (donphan branch, `hasDiracEq=false`)
Dirac EQ → 11 → **7**; Pop → ADAPTIVE(4*) → 3; Rock → 6 → 1; Electronic → TRANSPARENCY(7*) → 2;
Enhance → 9 → 4; Classical → 8 → 5; Custom → OFF(5*) → 6. All C050/F01D. No gate.

## B184 (gligar `:202-…`) / B175 (forretress `:201-…`)
Pop 3, Rock 1, Electronic 2, Enhance 4, Classical 5, Custom 6. C050/F01D. No Opteo.

## Simple models (base `:824-833`; `IOTProductDevice.initSimpleEQItem :617-…`)
Balanced → 0 → 0; More Bass → 3 → 3; More Treble → 2 → 2; More Voice → 1 → 1;
Custom → OFF(5*) → 5 (iff `getIsSupportCustomEQ()`). All C01F/F010 `[t 00]`.

## Ear (2)/Ear family
Simple rows via `initSimpleEQItem` + 8-band `AdvanceEQViewModel` editor
(`EarTwoSimpleEQFragment` source not extracted).

## Unknown-cloud (`UnknownSimpleActivityViewModel.java:463-…,583-…`)
Simple (bitmask `eq` over FLAT_BALANCED/MORE_BASE/MORE_TREBLE/VOICE/NEW_VOICE/
NEW_INSTRUMENT/SIMPLE_CUSTOM_EQ): types 0/3/2/1/6/7/5, C01F/F010.
Dirac (bitmask `diracOpteo`, display sorted): Immersion (12,8), DiracOpteo (11,7),
Opteo (10,0, hidden unless `diracByPowered()`), Pop (4,3), Rock (6,1),
Electronic (7,2), Enhance (9,4), Classical (8,5), Custom (5,6); C050/F01D.
(`WhenMappings` static table `:95-169` maps every enum↔case; bitmask decode
`UnknownFunction.getEQList/getDiracOpteoEQList`; `isDiracEq()` = bitmask>0.)

## Screen chain (all products)
`IOTDeviceAction.startEqualizerActivity` → product `EqualizerActivity`
(`OnEQChangeListener`) → product VM (`register()` → GETs + `initSoundTypes()`)
→ rows; tap → `onClickType→setEQMode` (reselect-guard → gate? → `sendEqModelData`
→ ACK → single-row select); radar drag → `onChange→setCustomEQ` → F041 → ACK →
cache + radar refresh. Espeon evidence: activity `:106-130` (guide), `:240-267`
(HDAC observer), `:318-332` (click/drag).
