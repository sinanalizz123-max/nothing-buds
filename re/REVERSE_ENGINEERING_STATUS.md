# Nothing X Buds — Reverse Engineering Status (Master Index)

> HISTORICAL / SUPERSEDED AS MASTER INDEX — preserved as evidence. The current
> entry point is `re/INDEX.md`; structured findings live in the `re/` section
> docs. Status taxonomy used across the knowledge base: COMPLETED /
> PARTIALLY VERIFIED / UNRESOLVED / HARDWARE VALIDATION REQUIRED.
> Original status line kept below for history:
> **AUDIT LOCKED, IMPLEMENTATION (B172 GESTURE + DIRAC) DONE**
> Last updated: 2026-09-06
>
> Current assessment of this document's areas: gesture/key-config mapping
> COMPLETED (with the GET_KEY_CONFIGURATION correction below); EQ/Dirac now
> covered in depth by `re/` section docs (PARTIALLY VERIFIED overall —
> HARDWARE VALIDATION REQUIRED for B168 gate, B179 flags, custom round-trip).

This is the master index for the Nothing X Buds reverse-engineering phase. It consolidates everything recovered from the APK and is the prerequisite for freezing the RE phase.

## Focused correction — GET_KEY_CONFIGURATION

The previous master index contained a stale command assignment. The authoritative decompiled source is:

`re/control-src/com/nothing/base/protocol/constant/ProtocolConstant.java`

It defines:

```java
public static final int GET_BOX_LED_COLOR = 49175;
public static final int GET_KEY_CONFIGURATION = 49176;
public static final int GET_DEVICE_WORKING_STATUS = 49177;
```

Therefore:

- `0xC017 = 49175 = GET_BOX_LED_COLOR`
- `0xC018 = 49176 = GET_KEY_CONFIGURATION`
- `0xC019 = 49177 = GET_DEVICE_WORKING_STATUS`

The runtime builder in `re/control-src/com/nothing/core/ext/TWSDeviceExtKt.java` calls the symbolic constant directly:

```java
TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_KEY_CONFIGURATION);
tWSDeviceBuilder.setCommand(ProtocolConstant.Set.SET_KEY_CONFIGURATION);
```

Since `GET_KEY_CONFIGURATION` resolves to `49176`, the Smart Dial / gesture configuration GET command is **definitively `0xC018`**.

The write command remains:

`SET_KEY_CONFIGURATION = 61443 = 0xF003`

The existing Smart Dial query-frame example is therefore correct:

```text
55 60 01 18 C0 00 00 0F B8 D9
```

`18 C0` is little-endian `0xC018`.

### Verification result

**Confidence: HIGH / SOURCE-VERIFIED.** The constant definition and runtime builder call site agree. No runtime capture is required to resolve this symbol-level discrepancy, though later hardware validation can confirm actual on-device traffic.

## Focused correction — case device code on the key-config channel

`re/control-src/com/nothing/espeon/control/ControlItemViewModel.java:216-232` and the case-lock row
`Operation(4, 1, 15, 40)` (espeon `ControlViewModel.java:856-858`) show the wire `device` byte is:
**2 = left bud, 3 = right bud, 4 = case/dial.** The previous app code wrote `0x01` for the case
(PacketBuilder.SIDE_CASE); that is corrected to `0x04` in the implementation, verified from source.

## B172 (CMF Buds Pro 2) gesture capabilities — source-verified, now implemented

- Earbud configurable triggers = `{2, 3, 7, 9, 15}` (ear list `{2,3,7,8,9,0,15}` masked by
  SUPPORT_GESTURES `{1,2,3,7,9,10,15}`). Type 15 renders as an arrow-only / fixed row.
- Per-trigger operation lists (espeon `ControlItemViewModel.java:34-42`): double=2 → `{2,8,9,11,1}`;
  triple=3 → `{8,9,11,1}`; press&hold=7 → `{22,11,1}`; double-tap-hold=9 → `{18,19,11,1}`.
- Case: single=1 → `{2,9,8,11,17,1}`; double=2 → +`{3,25,1}`; triple=3 → +`{26,1}`; press&hold=7 →
  `{22,11,17,1}`; rotate=10 → `{23,1}`. Type 15 is the fixed case-lock row.
- The app's SET_GESTURES write is acked by `0x7003`; the implementation now re-reads 0xC018 on that ack.

## Current RE status

The focused command-ID discrepancy is resolved and the B172 gesture/case device + capability mapping
is implemented and source-verified. Build succeeds on GitHub Actions.

Other previously documented RE areas remain unchanged, including case BLE separation,
transport/framing/CRC, EQ/Dirac, ANC, spatial audio, codec paths, OTA gaps, pairing/discovery,
multipoint, and hardware-only validation gaps.
