# Nothing X Buds — Reverse Engineering Status (Master Index)

Status: **AUDIT LOCKED, IMPLEMENTATION NOT STARTED**
Last updated: 2026-09-06

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

## Current RE status

The focused command-ID discrepancy is resolved. Implementation remains **not started**.

Other previously documented RE areas remain unchanged, including Smart Dial operation IDs, case BLE separation, transport/framing/CRC, EQ/Dirac, ANC, spatial audio, codec paths, OTA gaps, pairing/discovery, multipoint, and hardware-only validation gaps.

No `app/` files are to be modified during this RE phase.
