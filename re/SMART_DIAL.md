# Smart Dial / case-control reverse engineering (source-verified)

Evidence-based write-up of how Nothing X's case-dial ("smart dial") gesture controls work,
derived from the decompiled sources under `re/control-src/`. Every claim cites a file:line.
Nothing here is guessed — where a link cannot be proven from the artifact it is listed under
"Gaps".

Same-family doc (older dig, has some superseded claims): `Nothing-x-open/re/control-and-smart-dial.md`.

## 1. End-to-end data flow

```
UI tap (ControlCaseOperationActivity.onSelectedOperation)
  → ControlViewModel.setGestureData(viewModel, dialogItemViewModel)      espeon/control/ControlViewModel.java:485-571
  → EspeonSppProtocol.setGestureData(op, newOperation, button)          ControlViewModel$setGestureData$1$1 (await l=151,156)
  → TWSDeviceExtKt.keyConfiguration(twsDevice) → TWSDeviceBuilder.sendMessage
        frame: 0xF003 SET_KEY_CONFIGURATION, payload = ControlConfigurationEntity.obtainDataPacket()
```

Read-back:

```
0xC018 GET_KEY_CONFIGURATION response
  → ControlConfigurationEntity(byte[])  parse via DataExtKt.toMultiValues(payload, 1,1,1,1,1)
  → espeon ControlViewModel.listenerLiveData:                                   ControlViewModel.java:282-399
      * extracts button==9 ops as "call gestures" (answer/decline channel)        :285
      * renders only ops whose gesture ∈ SUPPORT_GESTURES                        :341
      * device==4 ops paired with a same-gesture call op → call-paired item      :349-374
      * addGestureList dispatches to left/right/case lists                       :398
```

## 2. Packet layout (source-confirmed)

`ControlConfigurationEntity.obtainDataPacket()` (earbase/control/entity/ControlConfigurationEntity.java:183-194):

```
[ count, (device, button, gesture, operation) × count ]
  count = operations.size(), 1 byte; then 4 bytes per slot.
```

App-internal device codes (source-verified):
- `2` = left bud, `3` = right bud, `4` = case/dial.
  - `ControlItemViewModel.convertOptions`: `device == 2` → left, `device == 3` → right,
    `device == 4` → `isCase()` (espeon/control/ControlItemViewModel.java:216-232).
  - Lock item is created as `new Operation(4, 1, 15, 40)` — device 4 = case (espeon ControlViewModel.java:856-858).
  - Read-back pairing of call gestures matches `operation.getDevice() == 4` (espeon ControlViewModel.java:349).

> Correction: earlier notes/README claimed "1=case". In this current artifact the case device
> code is definitively **4**. The `1=case` claim in Nothing-x-open/re/control-and-smart-dial.md
> predates this reading and needs re-check against its source.

## 3. Per-model supported triggers — `SUPPORT_GESTURES` (read-back render filter)

Constant `private static final int[] SUPPORT_GESTURES` in each model's `control/ControlViewModel`:

| model (product) | SUPPORT_GESTURES | file:line |
|---|---|---|
| Espeon (CMF Buds Pro 2, B172) | `{1, 2, 3, 7, 9, 10, 15}` | espeon/…/ControlViewModel.java:63 |
| Gligar (24241) | `{1, 2, 3, 7, 9, 10, 15}` | gligar/…/ControlViewModel.java:63 |
| Girafarig (24232) | `{1, 2, 3, 7, 9, 10, 15}` | girafarig/…/ControlViewModel.java:63 |
| Corsola (Buds Pro, B163) | `{1, 2, 3, 7, 8, 9}` | corsola/…/ControlViewModel.java:63 |
| Donphan (Buds, B168) | `{2, 3, 7, 9}` | donphan/…/ControlViewModel.java:63 |
| Elekid (Headphone (1), B170) | `{1, 7}` | elekid/…/ControlViewModel.java:63 |
| Crobat (Neckband Pro, B164) | `{2, 3, 7}` | crobat/…/ControlViewModel.java:63 |

Notes:
- This filter applies to both bud and case slots returned by 0xC018 (it is gesture-type-only).
- The older reference table (earbuds `0/2/3/7/8/9/15`) included slide (0) and 8 for espeon;
  the current artifact's filters contain **no 0** and, for espeon, **9** (not 8). Use the table above.

## 4. Case gesture definitions — `caseGestures` (id → name/lottie/icon)

`IOTEarEspeonGestureAction.java:26` (line 26 is too long for the tool; content verified):

| id | R.string | lottie (highlight) | icon |
|---|---|---|---|
| 1 | `single_press` | `lottie/espeon_single_case.json` | control_ic_index_one |
| 2 | `double_press` | `lottie/espeon_double_case.json` | control_ic_index_two / _two_sub |
| 3 | `triple_press` | `lottie/espeon_triple_case.json` | control_ic_index_three / _three_sub |
| 7 | `press_hold` | `lottie/espeon_press_hold_case.json` | control_ic_index_tap_hold |
| 10 | `rotate` | `lottie/espeon_rotate_case.json` | control_ic_rotate |
| 15 | `double_press_hold` | `""` (empty) | control_ic_index_double_tap_hold |

Gligar's list is identical modulo the `gligar_*` asset names (gligar/…/IOTEarGligarGestureAction.java:26);
`createOrangeGesture()` returns this list (companion `createOrangeGesture`/`getCaseGestures`, line 43).

## 5. Operation (action) id → name (source-verified switches)

Resolved in `ControlItemViewModel`/`ControlOperationViewModel` (`operationName` / `getOperationName`):

| id | action | verified at |
|---|---|---|
| 1 | No action | espeon case lists (default) |
| 2 | Play / pause | girafarig ControlItemViewModel (control_skip…) switch |
| 6 | Volume up | girafarig switch `R.string.volume_up` |
| 7 | Volume down | girafarig switch `R.string.volume_down` |
| 8 | Skip back | girafarig switch `R.string.control_skip_back` |
| 9 | Skip forward | girafarig switch `R.string.control_skip_forward` |
| 10 | ANC / noise-control | girafarig switch `ancNoiseControl(context)` |
| 11 | Voice assistant | girafarig switch `voice_ai_title` (GPT-aware), else voice-assistant string |
| 20 / 21 / 22 | Noise sub-modes (ANC/transparency/off) | espeon `convertAnc` disposal, ControlViewModel.java:844 |
| 40 | Case lock / unlock tips | girafarig switch `R.string.lock_unlock_tips` + `R.string.knob` |
| 255 | reserved/internal | girafarig switch special-case |
| (flow) | `switch_bluetooth_connection` string exists in the same switch family | girafarig ControlItemViewModel |

Espeon earbud operation lists (companion arrays, earlier session):

- double/triple tap: `SUPPORT_OPERATIONS {8, 9, 11}`
- noise slots: `SUPPORT_OPERATIONS_NO_CLOSE {22, 11}`
- press & hold: `SUPPORT_OPERATIONS_LONG_PRESS {18, 19, 11}`
- double-tap extra: `SUPPORT_DOUBLE_OPERATIONS {2, 8, 9, 11}`

## 6. Espeon case-dial assignment — allowed operations per slot

From espeon `ControlItemViewModel` case helpers (`caseSinglePressGesture` 401-…, `casePressHoldGesture` 430-…,
`caseDoublePressGesture` 334-…, `caseTriplePress` 236-…, rotate via `caseOperationList`):

| case slot (gesture id) | allowed operations (op, order) |
|---|---|
| 1 single press | {2, 9, 8, 11, 17} |
| 7 press & hold | {22, 11, 17} |
| 2 double press (call) | {3, 25, 1} |
| 3 triple press (call) | {26, 1} |
| 10 rotate (smart dial) | {23 volume control, 1 no action}, default = 1 |
| 15 double-press-hold | lock item (op 40) |

- Rotate render: `caseOperationList(23, …)` first → HEAD, then `1` → END
  (espeon ControlItemViewModel rotate dispatch, ControlViewModel.java:190-191 path).
- `addLockCustomisable()` appends `Operation(4, 1, 15, 40)` (`lock_unlock_tips`) as a non-customisable row (espeon ControlViewModel.java:856-858).

## 7. ANC / noise-control special-casing

- Selection ops 10/20/22/21 go through `convertAnc(defaultOperation, true)`; other ops set
  `noiseControlVisible=false` (espeon ControlViewModel.java:841-849).
- UI handlers `onClickNoiseCancellation/onClickTransparency/onClickOff`
  → `setAncGestureData(viewModel, value, dialogItemViewModel)` (espeon/ControlCaseOperationActivity.java:223-260;
  espeon ControlViewModel.java:596-604, launch + jadx-skipped `syncAncGestureData` at 623-629).
- Sub-mode translation `dialogItemViewModel.toTransparency()/toNoiseCancellation()/toOff()`;
  a slot marked as a noise operation is re-stamped with the noise sub-op at write (`setGestureData`
  noise check, espeon ControlViewModel.java:545-546, 576-594).

## 8. Smart-dial gating

- `IOTProductDevice.supportSmartDial()` = `false` (earbase/…/IOTProductDevice.java:199-201).
- Overridden `true` only for **Espeon (B172)** (`IOTProductDeviceEspeon.java:64-66`, productId B172/project 23272,
  Buds Pro 2) and **Heracross** (`IOTProductDeviceHeracross.java:72-74`, device "24253"; reuses
  IOTEspeonAction / IOTEarEspeonGestureAction / EspeonProtocol). Espeon is the only one with full dial UI.
- `SmartDialUtil.checkSmartDial(address)` = one-time "smart dial tips" notice, DB-gated per device
  (DeviceItem.smartDialTips); callers: `com.nothing.crobat.control.ControlViewModel`, SmartDialUtil itself.

## 9. Call-channel (button == 9)

When read-back contains an op with `button == 9`, it is pulled out as a call-assignment
(`getCallOperation`) and applied to the matching case slot (espeon ControlViewModel.java:283-287, 349-374;
UI pairing in `caseDoublePressGesture`/`caseTriplePress`). On write, a paired `callOperation` is
re-serialized to the same slot (espeon ControlViewModel.java:789-794).

## 10. Gaps

- `EspeonSppProtocol` and `EspeonProtocol` class files are **not present** in the control-src artifact,
  though referenced (`setGestureData` from `ControlViewModel$setGestureData$1$1`, `setProtocol(new
  EspeonProtocol())` from the device constructors). The exact 0xF003 write/read bodies cannot be read
  here; the packet framing is anchored via `ControlConfigurationEntity.obtainDataPacket()` + the
  verified 0xC018/0xF003/0xC009 constants in `ProtocolConstant.java`.
- `DataExtKt.toMultiValues` (read-back parser) is not in this artifact either — its semantics are
  inferred to mirror `obtainDataPacket` (count + 4-byte slots) but not directly verified.
- `BaseSppProtocol` method bodies (generic write helpers) opened but not yet fully read.