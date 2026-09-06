# Noise Control Configuration System (Nothing X, source-verified)

## Modes (CONFIRMED)
`DeviceNoiseReduction` (`re/proto-src/.../earbase/anc/entity/DeviceNoiseReduction.java:14-31`):
state is triplets `[key, value…]` with keys MODE=1, LEVEL=2, STEP=3 (`:24-26`).
Mode ids: CLOSE=5, STRONG=1, MEDIUM=2, WEAK=3, SMART_1=4, SMART_2=8,
PASS_THROUGH=7, COMFORTABLE=6. Wire values: CLOSE→0, SMART_1→253, SMART_2→252,
PASS_THROUGH→254, COMFORTABLE→255 (`:27-31`); level range 1–127 (`:32-33`).
Our `AncMode` (OFF=5, LOW=3, MID=2, HIGH=1, ADAPTIVE=4, TRANSPARENCY=7) matches
these ids exactly.

## Active mode path (CONFIRMED)
`noiseReduction(tws, mode)`: GET 0xC00E (getPayload `[3]`, i.e. STEP key),
SET 0xF00F payload `[1, mode, 0]` (MODE key), notify 0xE003
(`EVENT_NOISE_REDUCTION_LEVEL_CHANGED`)
(`TWSDeviceExtKt.java:594-610`; `ProtocolConstant`: SET 0xF00E-adjacent
`SET_NOISE_REDUCTION_CONFIGURATION=61454`, `SET_CURRENT_NOISE_REDUCTION=61455`,
`GET_NOISE_REDUCTION_CONFIGURATION=49181`, `GET_CURRENT_NOISE_REDUCTION=49182`,
`EVENT_…=57347`). Our `setAnc` sends identical `[0x01, mode, 0x00]` on 0xF00F.

## Supported / enabled / cycling set
- Cycle behavior (task-observed): enabled subset only, e.g. Transparency→Off→…
  or full ANC→Transparency→Off→… (STRONG EVIDENCE — behavior spec, not source).
- Backing store: `SET/GET_NOISE_REDUCTION_CONFIGURATION` (0xF00E/0xC00D) are
  DECLARED but have zero callers in all extracts → packet structure UNKNOWN.
- Cycling itself runs on-device (long-press advances through the enabled set);
  no app-side cycle sequencer found → INFERRED from absence + gesture mapping.

## Controls
- Earbud gestures: key-configuration packet maps gesture→operation id; gesture
  operations 10/20/22/21 reveal the noise-control sub-picker
  (`ControlViewModel.setVisibleOrGoneNoiseSubItems`, donphan/espeon variants;
  see `re/SMART_DIAL.md` for the packet layout).
- Case controls: case button (device id 4) accepts operations through the same
  key-configuration packet (see `re/SMART_DIAL.md`) — noise-op assignment to
  the case button is INFERRED (mapping proven, specific assignment unobserved).
- Long press = press-and-hold trigger in the per-model trigger sets (existing
  gesture capability tables).

## Persistence / events / models
- Our app persists `last_anc_mode`; official persistence path UNKNOWN in extracts.
- Earbud-initiated changes arrive via EVENT 0xE003 (DECLARED; handler unobserved).
- Model capability: `getSupportANCLevel()` (espeon/B172 = 4), per-product ANC
  flags; exact per-model supported-mode lists UNKNOWN beyond observed traffic.

## Confidence roll-up
CONFIRMED: mode ids/values, active-mode GET/SET/EVENT ids + payloads, gesture
sub-picker ops, our-app parity. UNKNOWN: configuration packet layout, on-device
cycle pointer, official persistence, event handler, full per-model matrices.
