# Detail Enhancement (aka Clarity Boost) — investigation

Note: the task text's "0x7069" is a typo; the command is **0xF069**
(`SET_DETAIL_ENHANCEMENT = 61545`, `ProtocolConstant.java:32`).

## Decompiled source / caller (CONFIRMED code, UNKNOWN UI exposure)
`clarityBoost(tws, enabled, level)` → SET 0xF069 payload
`[enabled(0/1), level]`, null level defaults MID
(`TWSDeviceExtKt.java:207-218`). Levels: `ClarityBoostEntity.Level`
LOW=0, MID=1, HIGH=2 (`ClarityBoostEntity.java:26-29`).
No Activity/ViewModel caller exists in any extract → whether Nothing X exposes
it on any model is UNKNOWN.

## Payload semantics (CONFIRMED shape, INFERRED effect)
`[on/off, level]`; level selects a DSP clarity curve. Whether/how it changes
DSP/audio behavior beyond the name is UNKNOWN (no algorithm source extracted).

## Supported models (UNKNOWN officially)
No per-model gating found in extracts. Our app gates on `hasDetailEnhancement`.

## B172 hardware observation (device-observed, separate from official support)
`log/nothingbuds_20260906_193449.log:878-898`: F069 writes with levels 1/2/3
accepted; reads echo `enabled/level` (`:123,241`). Firmware acceptance is
proven; official UI support is not.

## Level-base mismatch (flagged, NOT changed)
Official levels are 0-based (LOW=0); our UI sends 1/2/3 (`ExtrasScreen`
`DETAIL_LEVELS`, `PacketBuilder.setDetailEnhancement` coercing 1..3) and the
buds echo the sent value. Whether firmware interprets 1-based labels or
0-based ids is UNKNOWN — left untouched per implementation safety rules.
