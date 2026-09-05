# Smart Dial / case-control reverse engineering (source-verified)

Evidence-based write-up of how Nothing X's case-dial ("smart dial") gesture controls work,
derived from the decompiled sources under `re/control-src/`. Every claim cites a file:line.
Nothing here is guessed — where a link cannot be proven from the artifact it is listed under
"UNKNOWN" / "Gaps".

Same-family doc (older dig, has some superseded claims): `Nothing-x-open/re/control-and-smart-dial.md`.

## 1. Model / capability gating

`IOTProductDevice.supportSmartDial()`:

| model / SKU | supportSmartDial() | source |
|---|---|---|
| base (all others) | `false` | ear/base `IOTProductDevice.java:199-201` |
| Espeon — CMF Buds Pro 2, B172 (project 23272, release order 3) | `true` | `espeon/core/device/IOTProductDeviceEspeon.java:64-66` |
| Heracross — "24253" | `true` (reuses Espeon action/gesture/protocol classes) | `heracross/device/IOTProductDeviceHeracross.java:72-74` |

- Espeon is the only model with the full case-dial UI.
- `SmartDialUtil.checkSmartDial(address)` drives the one-time "smart dial tips" notice only
  (`DeviceItem.smartDialTips` in the app DB); callers: `com.nothing.crobat.control.ControlViewModel`
  and `SmartDialUtil` itself. No firmware/version/region gating for the dial was found.
- Nothing-x-open ref table claimed Buds Pro (Corsola) earbuds include a "slide" (0) gesture; this
  current artifact shows **no model's `SUPPORT_GESTURES` contains 0**.

## 2. Per-model supported triggers — `SUPPORT_GESTURES`

Constant `private static final int[] SUPPORT_GESTURES` in each model's `control/ControlViewModel` line 63 —
the read-back **render filter** (only ops whose gesture type is in the set are shown):

| model (product / id) | SUPPORT_GESTURES |
|---|---|
| Espeon (Buds Pro 2, B172) | `{1, 2, 3, 7, 9, 10, 15}` |
| Gligar (24241) | `{1, 2, 3, 7, 9, 10, 15}` |
| Girafarig (24232) | `{1, 2, 3, 7, 9, 10, 15}` |
| Corsola (Buds Pro, B163) | `{1, 2, 3, 7, 8, 9}` |
| Donphan (Buds, B168) | `{2, 3, 7, 9}` |
| Elekid (Headphone (1), B170) | `{1, 7}` |
| Crobat (Neckband Pro, B164) | `{2, 3, 7}` |

This filter is gesture-type-only (applies to bud and case slots alike).

## 3. Case gesture (trigger) IDs — `caseGestures`

Defined in `IOTEarEspeonGestureAction.java:26` (gligar twin identical with `gligar_*` assets).

| id | UI name (R.string) | lottie (animation) | icons |
|---|---|---|---|
| 1 | `single_press` | `lottie/espeon_single_case.json` | control_ic_index_one |
| 2 | `double_press` | `lottie/espeon_double_case.json` | control_ic_index_two(_sub) |
| 3 | `triple_press` | `lottie/espeon_triple_case.json` | control_ic_index_three(_sub) |
| 7 | `press_hold` | `lottie/espeon_press_hold_case.json` | control_ic_index_tap_hold |
| 10 | `rotate` | `lottie/espeon_rotate_case.json` | control_ic_rotate |
| 15 | `double_press_hold` | (empty) | control_ic_index_double_tap_hold |

`createOrangeGesture()` returns this list (companion, line 43). Ear-side gestures live in the same
files; the case gesture IDs are the six values above.

## 4. Operation (action) IDs → user-facing strings (source-verified)

Resolved in model `ControlItemViewModel.getGestureOperation()` (verified girafarig switch,
lines 260-344; espeon/nothing-x-open refs agree):

| id | action | string source |
|---|---|---|
| 1 | No action | case-list defaults |
| 2 | Play / pause | func helper |
| 3 | Answer call | call case list |
| 6 / 18 | Volume up | `volumeUp(context)` helper |
| 7 / 19 | Volume down | `volumeDown(context)` helper |
| 8 | Skip back | `R.string.control_skip_back` |
| 9 | Skip forward | `R.string.control_skip_forward` |
| 10 | ANC / noise-control | `ancNoiseControl(context)` |
| 11 | Voice assistant | `voice_ai_title` (GPT) else `control_voice_assistant` |
| 17 | Game mode | `R.string.case_game_model` |
| 20 / 21 / 22 | Noise sub-modes (ANC/transparency/off) | `ancNoiseControl` |
| 23 | **Volume control (dial)** | `volumeControl(context)` helper |
| 24 | Pairing mode | `R.string.pairing_mode` |
| 25 | Answer + mute | `R.string.case_answer_call_mute` |
| 26 | Hand-up / decline call | `R.string.control_hand_up_decline_incoming_calls` |
| 27 | Spatial audio | literal "Spatial audio" |
| 28 | Bass enhancement | literal "Bass enhancement" |
| 29 | Mic mute | literal "Mic mute" |
| 31 | AI news | `R.string.ai_news` |
| 32 | Nothing radio | literal "Nothing radio" |
| 39 | Switch BT connection | `R.string.switch_bluetooth_connection` |
| 40 | Case lock / unlock tips | `R.string.lock_unlock_tips` + `R.string.knob` |
| 255 (0xFF) | **Volume control** label | `volumeControl(context)` (girafarig `if (op != 255)` else return) |

> Correction vs Nothing-x-open table: op **255 is NOT "info/internal"** — it resolves to the
> volume-control string here. ops 51 reserved is not in this switch.

## 5. Espeon case-dial assignment whitelists — `CASE_SUPPORT_*`

Constant arrays in espeon `ControlItemViewModel.java:38-42`:

| constant | allowed operations |
|---|---|
| `CASE_SUPPORT_SINGLE_PRESS` | `{2, 9, 8, 11, 17}` |
| `CASE_SUPPORT_PRESS_HOLD` | `{22, 11, 17}` |
| `CASE_SUPPORT_DOUBLE_PRESS_CALL` | `{3, 25, 1}` |
| `CASE_SUPPORT_TRIPLE_PRESS_CALL` | `{26, 1}` |
| `CASE_SUPPORT_ROTATE` | `{23, 1}` |

Earbud arrays (same file:34-37): `SUPPORT_OPERATIONS {8,9,11}`, `SUPPORT_OPERATIONS_NO_CLOSE {22,11}`,
`SUPPORT_OPERATIONS_LONG_PRESS {18,19,11}`, `SUPPORT_DOUBLE_OPERATIONS {2,8,9,11}`.

- Rotate rendering (`convertOptions`, gesture 10): iterate `CASE_SUPPORT_ROTATE`, first item gets
  `ControlRadius.HEAD`, last `END`, else NONE; then `setDefaultOperation(1)` (espeon ControlItemViewModel.java:178-195).
- Case double/triple/call wiring and lock row (op 40, gesture 15): see espeon ControlItemViewModel case helpers.
- Lock item appended as `addLockCustomisable()` → `new Operation(4, 1, 15, 40)` (espeon ControlViewModel.java:856-858).

## 6. UI → configuration → wire (CONFIRMED, the full chain)

```
Control UI:
  ControlCaseOperationActivity.onSelectedOperation(dialog, item)      espeon/ControlCaseOperationActivity.java:141-151
    → ControlViewModel.setGestureData(viewModel, dialogItem)          espeon/ControlViewModel.java:485-571
      → ControlViewModel$setGestureData$1$1.invokeSuspend:
            syncGestureData(dialog, op, viewModel)                    (Ctrl Vm kt l=151)
            button = dialog.getButton() ?: op.getButton()
            EspeonSppProtocol.setGestureData(op, newOp, button)       (l=156, returns Boolean)
            on true: setVisibleOrGoneNoiseSubItems + onClickSelectedOperation (UI refresh)

  EspeonSppProtocol is CONFIRMED a thin subclass of BaseSppProtocol with ONLY
  (getDetailPageData, getDebugPageData, getConfiguration, syncUtcTime, getDualEnable, setDualEnable);
  setGestureData / resetGestureData / getGestureData are NOT overridden → pure inheritance.
  (proto/com/nothing/espeon/core/protocol/EspeonSppProtocol.java:54-56 ctor, 58-98 methods)
  Ctor: EspeonSppProtocol(address) → super(address, IOTProductDeviceEspeon.EAR_ID).

  → BaseSppProtocol.setGestureData(op, newOp, button, cont)   ear/spp/BaseSppProtocol.java:362-404
      if button == -1 → button = op.getButton()
      payload = ControlConfigurationEntity(Operation(dev, btn, gest, newOp)).obtainDataPacket()
              = [01 dev btn gest newOp]                        (count=1, then 4 bytes)
      TWSDeviceExtKt.keyConfiguration(twsDevice)               (get 0xC018 / set 0xF003)
      → builder.setSync(payload, cont)                         TWSDeviceBuilder.java:379-410
        → sendSyncResponse(isGet=false) → TWSDevice.syncSetResponse(tws, 0xF003, ...)
        → HeadsetSppConnector.syncSend(0xF003, payload)        (see §7)
        → returns Message.isOk() (rspCode==0) as Boolean
```

ANC variant (`setAncGestureData`, used by Noise-cancellation/Transparency/Off rows):

```
ControlCaseOperationActivity.onClickNoiseCancellation/Transparency/Off   :223-260
  → ControlViewModel.setAncGestureData(viewModel, value, dialog)        ControlViewModel.java:596-604
    → ControlViewModel$setAncGestureData$1$1:
          syncAncGestureData(...)                                       (kt l=246)
          BaseSppProtocol.setGestureData$default(op, newOp, <defaulted>, cont)  (kt l=248) — espeon/ControlViewModel$setAncGestureData$1$1.java:64
          on true: op.setOperation; dialog.setOperation; convertAnc(newOp,false)
```

Reset (reset-all button):

```
ControlViewModel.resetGestureData()                                     ControlViewModel.java:631-638
  → resetLeftGestureData + resetRightGestureData + resetCallGestureData (build Operation list,
        each slot set to its defaultOperation; case lock(op40)/call rows pruned)  :759-857
  → ControlViewModel$resetGestureData$1:
        EspeonSppProtocol.resetGestureData(operations)                 (kt l=305-306)
```

## 7. Configuration → wire details (CONFIRMED)

### Command IDs

- Command IDs (ProtocolConstant, `KEY_CONFIGURATION` renamed `GET_ln`/`SET_ln` by the decompiler):
  - **Query `GET_KEY_CONFIGURATION = 0xC018 (49176)`**
  - **Set `SET_KEY_CONFIGURATION  = 0xF003 (61443)`**
- `TWSDeviceExtKt.keyConfiguration(twsDevice)` wires the builder: `getCommand(0xC018)` + `setCommand(0xF003)`
  (com/nothing/core/ext/TWSDeviceExtKt.java:546-552). Used by `ControlViewModel.listenerLiveData`.
- Payload builder (all sources agree, `1 + 4N` bytes):
  - single-slot set: `[0x01, device, button, gesture, operation]` — `ControlConfigurationEntity.obtainDataPacket()`
    (earbase/control/entity/ControlConfigurationEntity.java:183-194); identical to the 5-byte form produced by
    `DeviceProtocol.setGestureData` (ear/base/os/DeviceProtocol.java:115-125) used on the parallel earbase-OS route.
  - full set/reset: `[count, (device, button, gesture, operation) × count]`.
- Device codes on the wire equal the app-internal codes (no translation):
  **2 = left bud, 3 = right bud, 4 = case/dial**
  (`ControlItemViewModel.convertOptions`, espeon ControlItemViewModel.java:216-232; lock op `Operation(4,1,15,40)`; read-back pairing `getDevice()==4`).

### Frame format on the BLE GATT link (CONFIRMED, 3 independent sources)

`Message.obtainDataPacket()` (proto/com/nothing/protocol/model/Message.java:295-322 + parser
parse:79-99), written via `XConnector.writeWithTask`, and re-verified by the receive parser
`XDefaultParser.getReceiveCommand` (proto2/com/nothing/link/bluetooth/sdk/connect/tranform/XDefaultParser.java:60-80):

```
byte 0        SOF      0x55
byte 1..2     control  LE 16b: bits0-4 rspCode | bit5 CRC present | bit6 multiFrame | (deviceType<<8)&0x0F00
byte 3..4     command   LE 16b: write uses raw id (0xF003); response wires bit15 (0x8000)
byte 5..6     length    LE 16b: payload byte count only (no header/frame)
byte 7        fsn       seq = createFsn() (AtomicInteger, wraps to 0 after 254);
                         matched only when isNeedFsn set; syncSet always sets it
byte 8..      payload   (length bytes)
+length+8..2  CRC-16 LE  only when control bit5 set
frameLen = length + 8,  (+10 when CRC present)
```

- **Transport** is BLE GATT, not RFCOMM: the link SDK writes to
  SERVICE `0000fd90-0000-1000-8000-00805f9b34fb`, WRITE `68745353-1810-4b13-83a2-c1b21b652c9b`,
  notify `ca235943-1810-45e6-8326-fc8ca3bc45ce` (`NtPeerLinkBleUuids`, case-src). "SPP" is nominal.
- **Devices**: Espeon deviceType = 1 (IOTProductDeviceEspeon.EAR_ID), no payload-endpoint byte
  (`getPayloadEndpointType()` null) — the frame shown below is exact for Espeon.
- **FSN**: syncSet/syncSend generate `createFsn()` per write; responses are matched by key
  `responseCommand + "_" + fsn` (HeadsetSppConnector.java:822-827) with 5 s timeout.
- **CRC** (`Utils.obtainCrc16`, proto2/com/nothing/base/util/Utils.java:356-366):
  CRC-16/ARC, init 0xFFFF, poly 0xA001, reflected per-byte:
  `crc=(crc&0xFFFF)^(byte); 8× {crc=lsb? (crc>>1)^0xA001 : crc>>1}` — no final XOR. Stored little-endian.
- **Timing** (XConnector.writeWithTask): 100 ms between writes, 5000 ms default response timeout, retry list.

### Worked frames (lock row: device 4, button 1, gesture 15, op 40)

```
SET 0xF003 (14 bytes), fsn=F, crc bit set:
  55 60 01  03 F0  05 00  0F  01 04 0F 28  58 6C
  SOF ctlLE cmdLE lenLE fsn payload        CRC16-LE
  ctl 0x0160 = rspCode0 | crc(0x20) | multi(0x40) | (1<<8)
  CRC16 = obtainCrc16([55 60 01 03 F0 05 00 0F 01 04 0F 28]) = 0x6C58

QUERY 0xC018 (10 bytes), fsn=F, crc bit set:
  55 60 01  18 C0  00 00  0F        B8 D9
  payload length 0; CRC16 = obtainCrc16([55 60 01 18 C0 00 00 0F]) = 0xD9B8
  response: same header, cmd bit15 set (0x8018), rspCode in ctl bits0-4
```

Read-back response payload for N slots = `[count, (dev,btn,gest,op)×count]`, parsed by
`DataExtKt.toMultiValues(payload, 1,1,1,1,1)` (see §8).

## 8. Read-back (CONFIRMED at app layer)

```
ControlViewModel.register(extras)                                      espeon/ControlViewModel.java:129-134
  protocol = new EspeonSppProtocol(address)
  listenerLiveData()                                                   :136-220
  getGestureData(false)  →  BaseControlViewModel.getGestureData triggers the 0xC018 query

listenerLiveData():
  keyConfiguration(twsDevice)  →  command-cache LiveData
  Transformations.map(getLiveDataCommand(getCommand=0xC018, notifyCommand), …)
      message.getPayload()  →  new ControlConfigurationEntity(byte[])   (reflective ctor)  :144-186
  distinctUntilChanged → observe → listenerLiveData$lambda$11           :226+
      splits ops into left / right / case lists:
        - pulls button==9 ops as call-channel                         :285
        - renders only gestures ∈ SUPPORT_GESTURES                     :341
        - case (device==4) op paired with same-gesture call op         :349-374
  → ControlActivity / ControlCaseOperationActivity lists
```

App-side `getGestureData` actually sends `sendCommands([0xC018])` via `TWSDevice`
(ear/base/os/DeviceProtocol.java:107-113). The reply payload is parsed in `ControlConfigurationEntity(byte[])`
(earbase/control/entity/ControlConfigurationEntity.java:104-114) using
`DataExtKt.toMultiValues(payload, 1,1,1,1,1)` (proto/com/nothing/base/util/ext/DataExtKt.java:560-570):
count + per-row `(dev, btn, gest, op)` through the 1-byte `toInt` unsigned getter (`byte & 0xFF`,
DataExtKt.java:459-467, 630-639), assembled into `Operation(i[0..3])`.

**Signedness RESOLVED (UNSIGNED)**: 1-byte reads use `data[offset] & 0xFF` — so op byte `0xFF` reads back **255**,
never -1. This matches the girafarig op→string switch `case 255: volumeControl` and the
`OPERATION_VOLUME_DOWN_OR_UP = 255` constant. (Two-byte reads are little-endian: `(b1<<8)|b0`.)

## 9. Default configuration

- **No proactive default write**: on connect/enter the page the app only issues `0xC018` (read),
  then renders what the device returns (`register` → `getGestureData(false)`).
- The app's only "write defaults" path is the reset-all button (§6), which re-stamps selected slots
  with each slot's `defaultOperation`:
  - case single / double / triple / rotate: default = **1 (no action)** (espeon ControlItemViewModel.java:195, 361, 402, 431)
  - ear double tap: default 9; ear triple tap: default 8; long-press: default 22; call rows per whitelist.
  - reset rewrites `copy$default(op,0,0,0,0,15).setOperation(defaultOperation)` preserving device/button/gesture.
- Firmware factory defaults for rotation when the app never writes are therefore **device-defined, not
  app-defined** (UNKNOWN; likely `1` no-action given the app's own default).

## 10. Which case gestures are "real configurable" vs framework-only

Source-defined, per-model control availability is a combination of:

1. `supportSmartDial()` (Espeon B172 only + Heracross) → tips + dial UX + lock row;
2. `SUPPORT_GESTURES` membership → whether that trigger type is even rendered from read-back;
3. presence of the model's `ControlItemViewModel` case builders (`CASE_SUPPORT_*` handling —
   only espeon has the full case op-list construction; girafarig renders only ear gestures
   2/3/7/8/9 and its case rows fall back to the base `ControlGestureViewModel`);
4. firmware actually returning slots (observed at read-back).

Result: on Espeon, case slots **1 (single), 2 (double), 3 (triple), 7 (press & hold), 10 (rotate),
15 (double press & hold / lock)** are all real, configurable controls on the main key-config channel.
Models without the espeon case builders only show framework rows (no dial).

## 11. Validation checklist (§13 of the task)

- Numeric IDs cross-checked ≥1 source each — see tables above (file:line cited).
- Operation-ID reuse: **10 vs 20/21/22** (noise-control family) collapse to the same UI string;
  **6/7 vs 18/19** (volume up/down) are alias pairs; **23 vs 255** both render "Volume control".
  These are the only collisions found.
- Endianness: frame header fields (control/command/length/CRC) are little-endian (Message.java + XDefaultParser);
  payload bytes are single-byte fields. All confirmed.
- Signedness: write uses `put((byte) op)`; ops up to 255 → 0xFF. Read-back `DataExtKt.toMultiValues` is
  **UNSIGNED** (`byte & 0xFF`), so op 255 reads back 255 → matches `case 255`. RESOLVED.
- Packet length: `1+4N` (single set = 5 bytes) — confirmed by `ControlConfigurationEntity.obtainDataPacket`.
- Frame on link: `[0x55 SOF][ctl16 LE][cmd16 LE][len16 LE][fsn][payload][crc16 LE]`, opts in ctl bits —
  CRC-16/ARC (0xA001, init 0xFFFF). RESOLVED (§7).
- Value translation before send: YES — ANC rows write the resolved sub-op (0/20/21/22) via
  `setAncGestureData`/`convertAnc`; call rows + lock handled separately; otherwise op is sent raw.
- Separate case protocol for smart dial: NO — same 0xF003 key-config channel as buds.

## 12. Gaps / not verifiable from this artifact

- Ear↔case relay in firmware: after `0xF003` the app shows "case restarts to apply"; the ear relays the config
  to the case over the ear↔case link. Relay framing/behavior is firmware, not in this app artifact.
- Physical GATT stack / SparkLink transport scheduling below `XConnector` — app code ends at `writeWithTask`.
- Behavior of `0xF003` is inferred from DeviceProtocol/Builder wiring + the ANC alias rows writing 0/20/21/22,
  which are themselves read back through the same channel (self-consistent). No live-device capture was done.
- Office/call "smart dial" V1 models (flare/c'dim/Martian) — app-level gates exist but were not traced in depth.

Resolved from earlier drafts: EspeonSppProtocol hop (now in artifact), `DataExtKt` signedness (UNSIGNED),
body of `TWSDevice.syncSet/sendMessage/syncSend` + frame format + CRC/seq (now in proto-src/proto2-src),
`BaseSppProtocol` body (now in control-src, ANC path included).

## 13. Source index (key files)

- `control-src/com/nothing/espeon/control/ControlViewModel.java` — SUPPORT_GESTURES:63; register:129; listenerLiveData:136; read-back split:226-399; setGestureData:485; setAncGestureData:596; reset:631, 759-854; addLockCustomisable:856.
- `control-src/com/nothing/espeon/control/ControlItemViewModel.java` — earbud/case arrays:34-42; convertOptions device codes:216-232; rotate:178-195; case helpers + defaults.
- `control-src/com/nothing/espeon/control/ControlCaseOperationActivity.java` — UI entry:141; ANC:223-260.
- `control-src/com/nothing/espeon/control/ControlViewModel$setGestureData$1$1.java` — save hop.
- `control-src/com/nothing/earbase/spp/BaseSppProtocol.java` — getGestureData 291-298; setGestureData:362-404; reset:set-ops.
- `control-src/com/nothing/earbase/os/DeviceProtocol.java:107-125` — 0xC018 query + 5-byte 0xF003 set payload.
- `control-src/com/nothing/core/ext/TWSDeviceExtKt.java:546-552` — keyConfiguration builder.
- `control-src/com/nothing/earbase/control/entity/ControlConfigurationEntity.java` — obtainDataPacket:183-194; ctor parse:104-114.
- `control-src/com/nothing/{espeon,gligar}/core/device/IOTEar*GestureAction.java:26,43` — caseGestures.
- `control-src/com/nothing/girafarig/control/ControlItemViewModel.java:260-344` — op→string switch (incl. case 255).
- `control-src/com/nothing/base/protocol/constant/ProtocolConstant.java` — GET_ln=49176 (0xC018), SET_ln=61443 (0xF003).
- `control-src/com/nothing/{espeon,heracross}/core/device/IOTProductDevice*.java` + base — supportSmartDial.
- `proto-src/com/nothing/espeon/core/protocol/EspeonSppProtocol.java` — subclass, NO gesture overrides.
- `proto-src/com/nothing/espeon/core/protocol/device/EspeonProtocol.java` — deviceType=1, SPP UUID AEAC4A03-DFF5-498F-843A-34487CF133EB, activation, payload-endpoint null.
- `proto-src/com/nothing/protocol/device/TWSDevice.java` (1964 ln) + `TWSDeviceBuilder.java` (1228 ln) — syncSet/syncSetResponse/receive; build() wiring.
- `proto-src/com/nothing/protocol/connector/HeadsetSppConnector.java` — sendMessage:700-708; syncSend:858-901; writeWithTask:755/885; fsn match-key:822-827.
- `proto-src/com/nothing/protocol/model/Message.java` — frame build 295-322, parse 79-99, fsn 254-wrap.
- `proto-src/com/nothing/base/util/ext/DataExtKt.java` — toMultiValues:560-570; unsigned one-byte getIntOrZero:459-467.
- `proto2-src/com/nothing/base/util/Utils.java` — obtainCrc16:356-366 (CRC-16/ARC, 0xA001/0xFFFF).
- `proto2-src/com/nothing/link/bluetooth/sdk/connect/tranform/XDefaultParser.java:60-80` — receive-side frame validation (SOF 0x55, len+8/+10).
- `control-src/com/nothing/earbase/control/SmartDialUtil.java` — tips gate.