# Nothing X Buds — Reverse Engineering Status (Master Index)

Status: **AUDIT LOCKED, IMPLEMENTATION NOT STARTED**
Last updated: 2026-09-06

This is the master index for the Nothing X Buds reverse-engineering phase. It consolidates everything
recovered from the APK, classifies each area, and is the prerequisite for freezing the RE phase.

Two-repo layout (per project decision):

- `nothing-buds/` — the app to build. Evidence lives under `re/` (decompiled source + distilled docs).
- `Nothing-x-open/` — the reverse-engineering reference project. Its `re/` docs are the distilled
  narrative; `nothing-buds/re/*-src` is the evidence to cite (file:line).

Rules honored: work only under `re/`, do not modify `app/`, do not modify `Nothing-x-open/`,
no implementation yet (task 1.txt §13). The nothing-buds APK build pipeline (`.github/workflows/build.yml`)
is a separate, user-authorized deliverable and is unaffected by this audit.

---

## 1. Overall Status

| Area | Status | Evidence |
|---|---|---|
| Transport / framing / CRC | CONFIRMED | `re/SMART_DIAL.md`; `control-src/.../CommandCache`; CRC16 test vectors |
| Query command block (0xC001–0xC07F) | CONFIRMED (list) | `control-src/com/nothing/base/protocol/constant/ProtocolConstant.java` (§Query) |
| Set command block (0xF000–0xF07F) | CONFIRMED (list) | same file (§Set) + `TWSDeviceExtKt` call sites |
| Notification block (0xE000–0xE01F) | CONFIRMED | same file (§Notification) |
| Debug block (0xFC00–0xFCB0) | CONFIRMED | same file (§Debug) + `OTADevice` |
| Device-ID / operation-ID enums | CONFIRMED | `ControlGestureViewModel`, `DeviceBattery`, `ControlConfigurationEntity` |
| Controls (gestures / Smart Dial) | CONFIRMED | `re/SMART_DIAL.md`, `control-src/.../control/*` |
| Case protocol (SPP control path) | CONFIRMED | `re/CASE_PROTOCOL.md` |
| Case BLE (separate GATT link) | CONFIRMED (**new** this audit) | `case-src/com/nothing/caseble/*` |
| EQ / Dirac | CONFIRMED | `proto-src/com/nothing/core/entity/EQEntity.java`, `SimpleEQEntity.java`, `dirac-src/*` |
| ANC | CONFIRMED | `ProtocolConstant` + `TWSDeviceExtKt` call sites |
| Battery / device state | CONFIRMED | `proto-src/.../ota/entity/DeviceBattery.java` |
| Codec (LDAC / LHDC / LE Audio) | PARTIAL | `ldac-src`, `TWSDeviceExtKt.lhdc`, `IOTProductDevice.hasLeFunction` |
| Game / low-latency mode | CONFIRMED | `ProtocolConstant` (LAG_MODE), `TWSDeviceExtKt.lagMode` |
| Spatial audio | CONFIRMED | `ProtocolConstant` (SPATIAL_AUDIO, HEADTRACK), call sites |
| Smart ANC / personalized ANC | CONFIRMED | `ProtocolConstant` (SMART_ANC, PERSONALIZED_ANC), call sites |
| OTA | PARTIAL | `proto-src/.../nt_ear_ota/*`, `proto2-src/com/nothing/ota/*`, `n_firmware_data` |
| Pairing / connection / discovery | CONFIRMED | `proto2-src .../scan/*`, `NothingParser`, `XBluetoothManager`, `ParseUtil` (service-data 0xFE2C) |
| Feature-bit map (GET_SUPPORTED_FEATURE 0xC00D) | CONFIRMED | `DeviceSupportFeature` (§4.5) |
| Multipoint / dual device | CONFIRMED | `ProtocolConstant` (DUAL_ENABLE, DUAL_DEVICE_LIST/SWITCH/CONNECT) |
| Find my earbuds / locate | CONFIRMED | `GET_FIND_EAR_STATE`, case-BLE find ring path |
| Diagnostics / log fetch | CONFIRMED | `ProtocolConstant` (BURIED_*, GET_DEBUG_INFO, DEBUG_CURVE), `FileLog` |
| Encryption/authentication | UNKNOWN — no crypto observed in recovered transport | see §9 |

CONFIRMED areas: 20 · PARTIAL: 2 · UNKNOWN: 1 (+ transport-level crypto)

---

## 2. Evidence Inventory (what each `re/` tree is)

| Tree / file | Contents | Classification |
|---|---|---|
| `re/control-src/` | App controllers, product-device capability classes, `ProtocolConstant` (Query/Set/Notification/Debug), `TWSDeviceExtKt` command builders, control/gesture VMs | CONFIRMED (heavily used) |
| `re/case-src/` | Case BLE: `NothingCaseParser` (adv), `NtCaseBleApi` (ear↔case match + connect), `XCaseBleConnector`, `NtPeerLinkBleUuids`, `ParseUtil`, battery parse | CONFIRMED |
| `re/dirac-src/` | EQ/Dirac UI : Equalizer VMs, `DiracOpteoEQ` enum, preset constants, `EqualizerComponents` | CONFIRMED |
| `re/ldac-src/` | LDAC/HDAC status handlers, older-model protocol device classes (ear two, ear color, girafarig) | CONFIRMED (partial paths) |
| `re/proto-src/` | Protocol model: `ProtocolConstant`, entities (`EQEntity`, `SimpleEQEntity`, `EQModeEntity`, `AdvanceCustomEQEntity`, `ClarityBoostEntity`, `MidUnitAdvanceCustomEQModeEntity`), OTA slice, SPP transport (`XSppOTAConnector`, `ActsSppRawParser`), `DeviceBattery`, `FirmwareVersion`, `EarphoneStatus` | CONFIRMED |
| `re/proto2-src/` | Transport SDK: `XCommand`/`XByteArrayParser`, `OTADevice`, case-BLE API, `NothingWatchParser`/`NothingAudioParser`/`NothingCaseParser` bases, `PacketFramer`, LE-audio plugin | CONFIRMED |
| `re/dig-matched.tar.gz` | Raw matched dig output (binaries matched to classes) | PARTIAL (supporting evidence, not fully read) |
| `re/nothing-x-dex.zip` | Raw DEX set used for decoding | CONFIRMED (source artifact) |
| `re/SMART_DIAL.md` | Deep-dive: framing, commands, key-config, Smart Dial control ops, device codes | CONFIRMED |
| `re/CASE_PROTOCOL.md` | Deep-dive: SPP case control path | CONFIRMED (updated this audit; §Case BLE) |
| `re/proto-files.txt`, `re/proto2-files.txt` | file listings from dig | CONFIRMED (index) |

Nothing-x-open/re docs are the distilled narrative and intentionally reference the same evidence;
**known corrections** to them are listed in §11 (Delias vs source).

---

## 3. Transport & Framing (CONFIRMED)

- Transport: **SPP** (serial, Android `uuid` socket) + **BLE** (ear control over SPP profile; case over BLE GATT; OTA over dedicated SPP profile).
- Control packet (see `re/SMART_DIAL.md`, verified against `CRC16.kt`):

```
[0x55 SOF][ctl:2 LE][cmd:2 LE][len:2 LE][fsn:1][payload N][crc16:2 LE]
```
- CRC16: polynomial 0xA001, init 0xFFFF (`app/src/main/java/com/nothingbuds/protocol/CRC16.kt`, `re/proto-src` CRC test vectors).
- Command bases: Query 0xC000, Set 0xF000, Notify 0xE000, Debug 0xFC00. Data byte carries:
  read/write/notify flag + fragment seq. Response command echoes request `cmd & 0x7FFF`.
- FSN / fragmentation & ACK behavior in `control-src .../CommandCache` + `XCommand` write task layer (retry/timeout in `XConnector.writeWithTask`, see §OTA).
- OTA transport is **raw SPP passthrough** (`ActsSppRawParser` builds `XCommand` "raw" frames; `XSppOTAConnector` default UUID placeholder `66666666-6666-6666-6666-666666666666`, tag `SppOTAWriter`, channel 13).

### 3.1 Transport / service UUID inventory (CONFIRMED, source-verified)

- **Control SPP socket UUID (default)**: `AEAC4A03-DFF5-498F-843A-34487CF133EB`
  (`proto2-src/com/nothing/link/bluetooth/sdk/connect/spp/XSppConnector.java:39` default; `proto2-src/com/nothing/nt_ble/plugin/EarphonesPluginImpl.java` `sppService` — channel 12, writer `SppWriter`; default channel 15).
- **Classic protocol-model SPP base UUID**: `00001105-0000-1000-8000-00805F9B34FB` (`proto-src/com/nothing/protocol/connector/BaseSppConnector.java` `DEFAULT_SPP_UUID`).
- **Ear OTA over SPP host socket**: standard serial `00001101-0000-1000-8000-00805F9B34FB`
  (`case-src/.../nt_ear_ota/NtEarOtaHostImpl.java:600,606` in `openEarTransport`).
- **Ear BLE service group `FD90`** (`EarphonesPluginImpl.java`): one service, two char pairs —
  - OTA: write `66666666-6666-6666-6666-666666666666`, notify `77777777-7777-7777-7777-777777777777`
    (`otaService`; notify corroborated by `proto2-src/.../connect/ble/XBleOTAConnector.java`).
  - Data/peer-link: write `68745353-1810-4B13-83A2-C1B21B652C9B`, notify `CA235943-1810-45E6-8326-FC8CA3BC45CE`
    (`dataService`; equal to `NtPeerLinkBleUuids`).
- **Case BLE group** (own GATT link): service `fb349b5f-8000-0080-0010-000000002211`, write/notify `66555943-1810-45e6-8326-fc8ca3bc45ce` (`case-src/.../caseble/XCaseBleConnector.java`).
- **Advertising service-data channel**: UUID `0000fe2c-0000-1000-8000-00805f9b34fb`
  (`case-src/.../earbase/os/cache/ParseUtil.java:61,133`, `.../broadcase/util/BleBroadcastParseUtil.java:50,113`)
  — buds/case publish model info in GATT service data; parsed alongside manufacturer data.
- **GATT CCCD**: client characteristic config descriptor `00002902-0000-1000-8000-00805f9b34fb` (`XBaseBleConnector`, `sdk/config/Constants.java`).
- **Watch-only / CMF scope** (not buds): OTA service `02f00000-0000-0000-0000-00000000ff01/ff02`, log service `E49A3001/2/3-F69A-11E8-8EB2-F2801F1B9FD1`, customs `0000CCAA-0000-1000-8000-00805F9B34FB`, `00006666-0000-1000-8000-00805F9B34FB` (`proto2-src/.../nt_ble/plugin/WatchPluginImpl.java`, `NothingWatchPluginImpl.java`).

> Decompiler caveat: most other string constants in `control-src`/`proto-src` are obfuscated to `"n"` and unrecoverable; the literal inventory above comes from the un-obfuscated `case-src` + `proto2-src` plugin/sdk layers.
>
> Both a **real RFCOMM SPP profile** (`AEAC4A03-…` control, `00001105-…` legacy base, `00001101-…` OTA host; channels 12/13/15) and a **GATT peer-link** (`FD90` group, chars `68745353-…`/`CA235943-…`) exist in the app. SMART_DIAL.md traced the Smart-Dial key-config (0xF003 device=4 rows) through the GATT peer-link path; the RFCOMM sockets are opened by the SDK/plugin layer (`HeadsetSppConnector` logic).

## 4. Protocol Registry Status

Marking rules (task §3): CONFIRMED USED = builder call site traced; DEFINED BUT UNTRACED = constant exists, no call site confirmed; UNKNOWN = not found.

### 4.1 Query block (source: `ProtocolConstant.java` §Query)
Values verified in source (0xC001 base). Select CONFIRMED-USED entries (call site in `TWSDeviceExtKt`, product-device class, or VM):

| cmd | name | status |
|---|---|---|
| 0xC001 | GET_PROTOCOL_VERSION | CONFIRMED USED (handshake) |
| 0xC002 | GET_FIND_EAR_STATE | CONFIRMED USED |
| 0xC005 | GET_REMOTE_DEVICE_IDENTIFICATION | CONFIRMED USED (scan binding) |
| 0xC006 | GET_REMOTE_CONFIGURATION | CONFIRMED USED |
| 0xC007 | GET_REMOTE_BATTERY_LEVEL | CONFIRMED USED (battery UI; `DeviceBattery`) |
| 0xC008 | GET_UPGRADE_CAPABILITY | CONFIRMED USED (OTA preflight) |
| 0xC00D | GET_SUPPORTED_FEATURE | CONFIRMED USED (feature bits) |
| 0xC00E | GET_EXTRA_FEATURE_STATUS | CONFIRMED USED |
| 0xC014 | GET_CODEC_CAPABILITY | CONFIRMED USED (codec gates) |
| 0xC015 | GET_MANUFACTURE | CONFIRMED USED |
| 0xC016 | GET_BOX_LED_COLOR | DEFINED BUT UNTRACED (Set twin traced) |
| 0xC017 | GET_KEY_CONFIGURATION | CONFIRMED USED (`TWSDeviceExtKt.keyConfiguration`) |
| 0xC018 | GET_DEVICE_WORKING_STATUS | CONFIRMED USED |
| 0xC01C | GET_EQ_MODE | CONFIRMED USED (`TWSDeviceExtKt.eqMode`: GET 49183) |
| 0xC01E | GET_REGISTERED_NOTIFICATION | CONFIRMED USED |
| 0xC01F | GET_HOST_UTC_TIME | CONFIRMED USED |
| 0xC022 | GET_DEVICE_MODEL | CONFIRMED USED |
| 0xC02F | GET_3D_MODE | CONFIRMED USED (spatial 3D) |
| 0xC035 | GET_LHDC_COMMANDS | CONFIRMED USED (LDAC toggle cmd class) |
| 0xC044 | GET_CUSTOM_EQ_VALUE | CONFIRMED USED (`simpleCustomEQ`/`advanceCustomEQValue` GET) |
| 0xC043 | GET_ADAPTIVE_EQ_MODE | DEFINED BUT UNTRACED |
| 0xC05C | GET_BOX_VERSION | CONFIRMED USED (case OTA/version) |
| 0xC069 | GET_DETAIL_ENHANCEMENT | CONFIRMED USED (`clarityBoost`) |

Full numeric table: `control-src/.../ProtocolConstant.java` §Query (52 entries). Cross-ref: `Nothing-x-open/re/official-command-table.md` (note §11 deltas).

### 4.2 Set block (source: same file §Set)
| cmd | name | status |
|---|---|---|
| 0xF001 | SET_PROTOCOL_ACTIVATED | CONFIRMED USED |
| 0xF002 | SET_WHERE_AM_I | CONFIRMED USED |
| 0xF003 | SET_KEY_CONFIGURATION | CONFIRMED USED (Smart Dial write path, see SMART_DIAL.md) |
| 0xF00D | SET_BOX_LED_COLOR | CONFIRMED USED (case LED) |
| 0xF010 | SET_EQ_MODE | CONFIRMED USED (`TWSDeviceExtKt.eqMode` SET 61456) |
| 0xF013 | REGISTER_NOTIFICATION / UNREGISTER_NOTIFICATION | CONFIRMED USED |
| 0xF014 | SET_LAG_MODE (game mode) | CONFIRMED USED (`lagMode`) |
| 0xF041 | SET_CUSTOM_EQ | CONFIRMED USED (`simpleCustomEQ` SET 61505) |
| 0xF044/0xF045/0xF046 | OTA_FIND_NEW_VERSION / OTA_DOWNLOADED_NEW_VERSION / OTA_STOP_ERROR | CONFIRMED USED (OTA flow) |
| 0xF00A | SET_ADVANCE_CUSTOM_EQ_MODE/VALUE (see §7) | CONFIRMED USED |

All remaining Set entries (bass boost 0xF019, spatial 0xF01x, FIR/ANC 0xF021+…, LHDC 0xF034, LE 0xF02x, smart-ANC 0xF0x, detail enhancement 0xF046+, scenario mode) are DEFINED + linked to `TWSDeviceExtKt` builders.

### 4.3 Notification block (0xE000 base, source verified)
`NOTIFICATION_COMMANDS=57344 (0xE000)`; `EVENT_BATTERY_CHANGED=0xE001`, `EVENT_DEVICE_STATUS_CHANGED=0xE002`,
`EVENT_NOISE_REDUCTION_LEVEL_CHANGED=0xE003`, `EVENT_GAME_MODE_CHANGED=0xE005`, `EVENT_DUAL_DEVICE_SWITCH_STATE=0xE006`,
`EVENT_WORKING_STATUS_CHANGE=0xE009`, `EVENT_LED_COLOR_SYNC_NOTIFICATION=0xE00B`, `EVENT_TIP_FIT_RESULT=0xE00D`,
`NOTIFY_DISCONNECT_PROFILE=0xE00F`, `NOTIFY_REQUEST_START_OTA=0xE010`, `NOTIFY_REQUEST_STOP_OTA=0xE011`,
`EVENT_MAGIC_BUTTON=0xE014`, `EVENT_HEAD_TRACK=0xE015`, `EVENT_LE_AUDIO_CONNECT=0xE016`,
`EVENT_RECORDING=0xE018`, `EVENT_DUAL_DEVICE_CONNECT_STATE=0xE01E`, `EVENT_PERSONALIZE_SYNC_NOTIFICATION=0xE00C`.

### 4.4 Debug / test-mode block (0xFC00 base, source verified)
`COMMANDS=0xFC00`; `ENTER_TEST_MODE=0xFC01`, `PARAMETER_NEGOTIATION=0xFC02`, `GET_FILE_LIST=0xFC03`,
`QUERY_SINGLE_FILE_INFO=0xFC04`, `REQUEST_SINGLE_FILE_INFO=0xFC05`, `DEVICE_SEND_DATA=0xFC06`,
`EXIT_TEST_MODE=0xFC07`, `CHANGE_LEVEL=0xFC08`, `GET_DEBUG_INFO=0xFC09`, `BURIED_DEVICE_SEND=0xFCA0`,
`BURIED_LOG_INFO=0xFCA1`, `BURIED_LOG_REQUEST=0xFCA2`, `DEBUG_CURVE_COMMAND=0xFCB0`.
Used primarily by the OTA/test-mode slice (`OTADevice.syncSend`, `TWSSliceCallBack`).

### 4.5 Feature-bit map — GET_SUPPORTED_FEATURE (0xC00D payload decode, CONFIRMED)
`DeviceSupportFeature` (`proto-src/com/nothing/base/protocol/entity/DeviceSupportFeature.java`) parses the
0xC00D payload as **4-byte LE integer** (offset 0) and masks:

| bit value | flag | | bit value | flag |
|---|---|---|---|---|
| 0x00000001 | WEAR_DETECT | | 0x00001000 | MUSIC_SHARE |
| 0x00000002 | GAME_MODE | | 0x00002000 | DENOISE_ANC |
| 0x00000004 | AV | | 0x00008000 | COMFORTABLE_MODE |
| 0x00000008 | GAV | | 0x00020000 | DENOISE_ENC |
| 0x00000010 | BISTO | | 0x00100000 | VOLUME_ADJUST |
| 0x00000020 | ALEXA | | 0x00200000 | SONG_SWITCH |
| 0x00000040 | GOOGLE_FAST_PAIR | | 0x00000400 | AUTO_ANSWER |
| 0x00000080 | INHOUSE_FAST_PAIR | | 0x00000800 | AUTO_RECONNECT |
| 0x00000100 | NEW_MOBILE | | 0x00000200 | MULTI_SPLIT |

This resolves the "wear in-ear detection", "assistant (Alexa)/Bisto", "Fast Pair" and "volume/song-switch"
feature-flag semantics for the feature gate call sites. Flag usage is gated through the model's
`GET_SUPPORTED_FEATURE` handler; runtime behavior is firmware-side (see §12).

---

## 5. Feature → Command Mapping (CONFIRMED USED)

| Feature | Read | Write | Notify |
|---|---|---|---|
| Battery (buds+case) | 0xC007 | — | 0xE001 (`DeviceBattery`) |
| Device status / connection | 0xC00A, 0xC012 | — | 0xE002 |
| ANC select | 0xC01B | SET_CURRENT_NOISE_REDUCTION | 0xE003 |
| ANC config (adaptive/smart) | 0xC01A | SET_NOISE_REDUCTION_CONFIGURATION | — |
| Smart ANC | 0xC036 | SET_SMART_ANC_MODE | — |
| Personalized ANC | 0xC019 | SET_PERSONALIZED | 0xE00C |
| ANC FIR curve (debug) | 0xC031 | SET_FIR_ANC_MODE | — |
| EQ mode | 0xC01C | 0xF010 | — |
| Custom EQ (simple) | 0xC044 | 0xF041 | — |
| Advance custom EQ (8-band) | GET_ADVANCE_CUSTOM_EQ_VALUE | SET_ADVANCE_CUSTOM_EQ_VALUE | — |
| Dirac Opteo EQ | GET_DIRAC_OPTEO_EQ | SET_DIRAC_OPTEO_EQ | — |
| Bass boost / enhancer | 0xC02E/0xC033 | SET_BASS_BOOST / SET_BASS_ENHANCER_MODE | — |
| Spatial audio / head-track | 0xC02F/0xC038 | SET_SPATIAL_AUDIO / SET_SYSTEM_AUDIO | 0xE015 |
| Game mode (low latency) | 0xC020 | 0xF014 | 0xE005 |
| LDAC/LHDC toggle | 0xC035 | SET_LHDC_COMMANDS | — |
| LE Audio switch | 0xC036+ | SET_LE_SWITCH_MODEL | 0xE016 |
| Key config (Smart Dial) | 0xC017 | 0xF003 | — |
| Find ear state + ring case | 0xC002 | (case-BLE ring command) | — |
| Factory reset / restore | — | RESTORE_FACTORY_SETTING | — |
| Auto power-off | 0xC011 | SET_AUTO_POWER_OFF_TIME | — |
| Box LED color | 0xC016 | 0xF00D | 0xE00B |
| Box version | 0xC05C | — | — |
| UTC time sync | 0xC01F | SET_UTC_TIME | — |
| Multipoint/dual | 0xC024 | SET_DUAL_ENABLE | 0xE01E, 0xE006 |
| Third-driver EQ (advance) | GET_THIRD_DRIVER_ADVANCE_CUSTOM_EQ_{MODE,VALUE} | SET_THIRD_DRIVER_… | — |
| Detail enhancement (clarity) | 0xC069 | SET_DETAIL_ENHANCEMENT | — |
| Scenario mode | GET_SCENARIO_MODE | SET_SCENARIO_MODE | — |
| OTA | 0xC008, 0xFC0x | 0xF044/0xF045/0xF046 | 0xE010/0xE011 |

---

## 6. Model-by-Model Capability Matrix (CONFIRMED gates from product-device classes)

Source: `control-src/com/nothing/{model}/.../IOTProductDevice*.java`
Gates: `getSupportANCLevel`, `hasBassBoostFunction`, `hasSpatialAudioFunction`, `hldcOrDiracOne`,
`supportSmartDial`, `supportAdvanceEq`, `hasFirFunction`, `hasNewFirFunction`, `hasLeFunction`,
`hasCaseUpdate`, `hasBassEnhancerFunction`, `hasMagicButton`, `hasHeadTrack`, `essentialSpaceSync`, `spaceEqExclusive`.

| Codename | ProductId | Display name | ANC | SmartDial | Advance EQ | BassBoost | Spatial | Dirac/LDAC | LE | CaseUpdate | NewFIR | Notes |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| Donphan | B168 | Buds | 3 | — | — | T | — | — | — | — | — | base Buds |
| Corsola | B163 | Buds Pro | 3 | — | — | — | — | — | — | — | — | |
| Espeon | B172 | Buds Pro 2 (EAR fx29566/white ca36a6/orange a7b220) | 4 | T | — | T | T | T (hldcOrDiracOne) | — | — | — | flagship gate set |
| EarOne | B181 | ear (1) | — | — | — | T | — | — | — | — | — | |
| EarTwo | B155 | ear (2) | 4 | — | — | — | — | — | — | — | — | |
| EarTwos | — | ear | — | — | — | — | — | — | — | — | — | |
| EarStick | — | ear (stick) | — | — | — | — | — | — | — | — | — | |
| Flaffy | B174 | ear (open) | 4 | — | — | — | — | — | — | — | FIR=F | open-ear |
| EarThree | B173 | Ear (3) | 4 | — | T | T | — | — | T | T | T (hasNewFir T, hasFir F) | essentailSpaceSync T, spaceEqExclusive T, colorCRC T, tnlGain −6 dB |
| EarColor | — | ear (a) | — | — | — | — | — | — | — | — | — | |
| Hitmontop | B183 | (EarColor impl, model 24272) | 4 | — | — | — | — | — | — | — | FIR=T | |
| Gligar | B184 | (24241) | 4 | — | — | — | — | — | — | — | — | |
| Hoothoot | B185 | (Donphan impl, 24283) | 3 | — | — | — | — | — | — | — | — | |
| Heracross | B187 | (24253) | 4 | T | — | T | T | F (hldcOrDiracOne) | — | — | — | smart-Dial device |
| Forretress | — | Headphone Pro | — | — | — | — | — | — | — | — | — | over-ear |
| Elekid | — | Headphone (1) | — | — | — | — | — | — | — | — | — | over-ear |

`24253/24272/24283/24232/24241` are the integer model IDs used for OTA/newer routing (deviceName fallback). Ear (1)/Ear(2)/stick/open supported via `EarOneDevice/EarTwoDevice/EarStickDevice/FlaffyDevice` and their `*Protocol` classes (`ldac-src` holds older-model device protocols: ear two, ear color, girafarig).

---

## 7. EQ / Dirac Deep Audit (CONFIRMED, source-verified)

### 7.1 Presets
- `DiracOpteoEQ` (dirac-src `.../earbase/unknown/entity/DiracOpteoEQ.java`): 9 values
  `DIRAC_OPTEO, OPTEO, ROCK, ELECTRONIC, POP, ENHANCE_VOCALS, CLASSICAL, CUSTOM_EQ, IMMERSION_BOOST`.
- Equalizer presets (`BaseEqualizerViewModelKt`): `BALANCED, VOICE, MORE_TREBLE, MORE_BASS, DIRAC_HD, EQ_CUSTOM, NEW_VOICE, NEW_INSTRUMENT`;
  tuning params FREQ_LOW/FREQ_PEAK=980/FREQ_HIGH, Q_LOW/Q_PEAK=0.7/Q_HIGH (stick: FREQ_PEAK=980, Q=0.66).
- Command builders: `TWSDeviceExtKt.diracOpteoEQ` (GET/SET_DIRAC_OPTEO_EQ), `eqMode`, `clarityBoost`, `bassBoost`.

### 7.2 Custom EQ wire format (PROTO-SRC CONFIRMED — supersedes earlier "3-band"/"8-band float" notes)
`SimpleEQEntity.obtainDataPacket()` (`proto-src/com/nothing/core/entity/SimpleEQEntity.java:69-89`):

```
[count:1B][totalGain:4B LE float][(filterType:1B)(gain:4B)(frequency:4B)(quality:4B)]*count   → size = 5 + 13*count
```
`EQEntity.obtainDataPacket()` (`proto-src/.../EQEntity.java:184-223`) — Advance Custom EQ (Ear (3) `supportAdvanceEq`):

```
[profileIndex:1B][count:1B][totalGain:4B LE float][(filterType:1B)(gain:4B)(frequency:4B)(quality:4B)]*count → size = 6 + 13*count
```
- Filters: `LOW_SHELF=0, PEAK=1, HIGH_SHELF=2` (+ `INDEX_STEP_FOUR=4, INDEX_STEP_FIVE=5, INDEX_STEP_SIX=6, INDEX_STEP_THIRTY=13` stepping constants). LOW_PASS=3/HIGH_PASS=4 referenced only in tuning data — UNKNOWN as filter codes.
- 8 default bands (`EQEntity.DEFAULT_FREQUENCY`): 55, 110, 220, 440, 1320, 3300, 6600, 13200 Hz; each with min/max clamp range; `DEFAULT_Q=1.0`; parser clamps frequency into band range and treats Q=0 as 1.0, filterType 0 as 1 (decompiler artifact caution).
- Read path: GET payload = `[profileIndex:1B]`; write path: SET payload builder above; both share `ITWSParse`.
- Simple EQ (2-band UI / bass-treble) and advance (8-band) use the **same protocol stack** (same SPP channel, command builder layer).

### 7.3 EQ-related commands (protocol registry cross-check)
`eqMode` SET=0xF010/GET=0xC01F · `simpleCustomEQ` SET=0xF041/GET=0xC044 · `advanceCustomEQ*` via ProtocolConstant ·
`clarityBoost` SET_DETAIL_ENHANCEMENT/GET 0xC069 · mid-unit (third-driver) variants `SET/GET_THIRD_DRIVER_ADVANCE_CUSTOM_EQ_*`.

---

## 8. OTA Deep Audit (PARTIAL — gaps marked)

Confirmed flow shape:

```
update check (GET_UPGRADE_CAPABILITY 0xC008 + SET_FIND_NEW_VERSION 0xF044)
→ metadata in Room "n_firmware_data" (address, updateStatus, fileSize, serverVersion,
   downloadUrl, filePath, codes, fileMD5)
→ download/validate (downloadUrl + fileMD5 fields; downloader not decompiled → PARTIAL)
→ device session: NOTIFY_REQUEST_START_OTA 0xE010 / STOP 0xE011 (slice binder TWSSliceCallBack)
→ transport selection: `NtEarOtaTransportKind` enum = EAR_SPP, EAR_BLE, CASE_BLE, EAR_WIFI, CASE_WIFI
   (case-src/com/nothing/nt_ear_ota/NtEarOtaHostImpl.java — openEarTransport/openCaseTransport/write sessions):
   - EAR_SPP → socket UUID 00001101-0000-1000-8000-00805F9B34FB (openEarTransport)
   - EAR_BLE → FD90 service, OTA chars write 66666666-… / notify 77777777-… (EarphonesPluginImpl.otaService,
     XBleOTAConnector)
   - CASE_BLE → case service fb349b5f-… char 66555943-… (XCaseBleConnector); writeWithTask timeout 10000 ms
   - EAR_WIFI / CASE_WIFI → enumerated, no recovered implementation (PARTIAL)
→ test-mode file transfer: ENTER_TEST_MODE 0xFC01, PARAMETER_NEGOTIATION 0xFC02,
   GET_FILE_LIST 0xFC03, QUERY_SINGLE_FILE_INFO 0xFC04, REQUEST_SINGLE_FILE_INFO 0xFC05,
   DEVICE_SEND_DATA 0xFC06, EXIT_TEST_MODE 0xFC07
→ legacy SPP OTA path: raw byte passthrough (ActsSppRawParser "raw", XSppOTAConnector channel 13);
   writeWithTask timeout 5000 ms, retry counters, mock ack 0x8B; per-message progress
   (OTADevice.updateProcess / updateCaseProgress)
→ completion: NOTIFY / OTA_DOWNLOADED_NEW_VERSION 0xF045; error path 0xF046
```

**UNKNOWN / hardware-dependent**: exact firmware file packet layout inside the raw stream, per-buffer
chunk sizes, reboot/apply trigger, Wi-Fi transports' implementation, download/check server endpoints
(URLs are external to APK — `downloadUrl` comes from DB row produced by an update-check service not
present in the decompiled set).

---

## 9. Case Audit (everything recovered — incl. NEW case-BLE findings)

SPP control path (already in `re/CASE_PROTOCOL.md`, not redone):
- battery 0xC007→0xE001 (`DeviceBattery`), box version 0xC05C, LED 0xF00D/0xC016/0xE00B,
  key-config 0xC017/0xF003 (device code **4 = case**, espeon/extended models), case gestures (single/double/triple press),
  find ring flow, case firmware/OTA (isCaseUpdate; 10 s timeout; `hasCaseUpdate` gate on Ear (3)).

### 9.1 Case = separate BLE device (NEW)
- The case is reached over its **own GATT link**, not only via the ear relay: `case-src/com/nothing/caseble/NtCaseBleApi.java`.
- `XCaseBleConnector`: service UUID `fb349b5f-8000-0080-0010-000000002211`,
  write/notify char UUID `66555943-1810-45e6-8326-fc8ca3bc45ce`.
- MAC binding: `findCaseMacForEar(earMac, timeout)` scans BLE and selects the advertisement whose
  manufacturer payload's `pairedEarphoneMac` equals the ear MAC (`earToCaseMacMap`).
- Advertisement payload (`NothingCaseParser`, case-src): 11 bytes =
  `[connectionFlag:1][colorId:1][productId:2][pairedEarphoneMac:6][deviceType:1]` (hex-len ≥ 22);
  deviceType must be 0x01 to accept as case; min adv len 11 bytes. Bundle keys
  `KEY_CASE_MAC_ADDRESS=device_address`, `KEY_PAIRED_EARPHONE_MAC=paired_earphone_mac`,
  `KEY_CONNECTION_FLAG=connection_flag`, `KEY_DEVICE_TYPE=device_type`.
- Scan filter manufacturer IDs (`BaseApplication`, `ParseUtil`): `{0x0CCB (3275, NOTHING_MANUFACTURER_ID_NEW), 0x2CBE (11454), 0xFFFF (65535), 0xBE4C (48684)}`.
  **NOTE**: company ID 0x0056 is NOT used in this build — earlier notes claiming 0x0056 for case adv are outdated.
- Peer-link (ear↔ear) BLE: `NtPeerLinkBleUuids` service `0000fd90-0000-1000-8000-00805f9b34fb`,
  write `68745353-1810-4b13-83a2-c1b21b652c9b`, notify `ca235943-1810-45e6-8326-fc8ca3bc45ce` (XPeerLinkBleConnector).

### 9.2 Case battery decode (CONFIRMED)
`DeviceBattery` (proto-src): payload = pairs `[devId:1][level|charging:1]`; level=`b & 0x7F`, recharging=`b & 0x80`;
devIds: 1=watch, 2=left, 3=right, **4=case**, 5=TWS pair, 6/7=stereo. This definitively resolves the device-code
dispute: **2=left, 3=right, 4=case** (also `ControlGestureViewModel.convertToViewModel` + espeon override).

---

## 10. Pairing / Connection / Discovery (CONFIRMED)

- Bluetooth infra: `XBluetoothManager` (max 6 connects, connect timeout 40 s, retry 0/1 s, op interval 100 ms,
  op timeout 3 s, scan timeout 300 s, MTU 511).
- Scan parsers: `NothingWatchParser`, `NothingAudioParser`, `NothingCaseParser` (device types in
  `NothingParser.getDeviceType`). Parsed manufacturer data → productId/colorId/paired-MAC/connection-flag bundles;
  **service-data** scans (UUID `0000fe2c-…`) via `ParseUtil`/`BleBroadcastParseUtil` → model/remote-config matching.
- Auth/handshake: `GET_PROTOCOL_VERSION` 0xC001 + `GET_REMOTE_DEVICE_IDENTIFICATION` 0xC005; `SET_PROTOCOL_ACTIVATED` 0xF001.
- **No transport encryption/authentication found in the recovered stack** — framing/CRC only. Mark UNKNOWN (would need live capture to prove order/anti-spoofing).

---

## 11. Corrections to Nothing-x-open/re distilled docs

These reflect source evidence in `nothing-buds/re/*-src`:

1. **Device code for case**: `control-and-smart-dial.md` "1=case" is wrong. Source: 2=left, 3=right, 4=case
   (6=right-variant used by one model). See `ControlGestureViewModel.java:366-388`, espeon override `ControlItemViewModel.java:216-233`, `DeviceBattery`.
2. **Custom EQ format**: earlier "3-band float ±6 dB fixed 53-byte" and "8-band fixed" claims are superseded by
   the count-based `[profile?][count][totalGain F32][filter records 13B]` formats (see §7.2). Band count is dynamic (up to 8).
3. **Case advertisement manufacturer ID**: 0x0056 → **0x0CCB** (3275) + 0x2CBE/0xFFFF/0xBE4C in this build.
4. **Case transport**: case is directly BLE-addressable (own GATT UUIDs), not only via ear relay.

---

## 12. Hardware-Validation Requirements

| Question | Why software cannot answer it | How hardware resolves it |
|---|---|---|
| OTA packet split per write (chunk size, headers) | raw passthrough confirmed only | sniff SPP OTA channel during upgrade |
| Firmware file format + integrity/apply | downloader/server code absent | capture a real OTA + update server response |
| Update-check endpoints | URLs external to APK | proxy the phone's update check |
| Encryption/auth on control channel | none recovered | sniff or try unauth writes |
| Exact Q/gain ranges per model | parser clamps but bounds unverified | send crafted values on real buds/case |
| Find-ear/ring hardware behavior | command confirmed, ring effect firmware-side | run on device |
| Case wake / reset / power-down semantics | SPP+GATT commands known, effect firmware-side | device testing |

## 13. CONFIRMED / PARTIAL / UNKNOWN counts

- CONFIRMED areas: 20 (see §1 table) · CONFIRMED used commands: ~42 (registry §4) · UUID inventory: §3.1
- PARTIAL: 2 (OTA, LDAC/LHDC/LE-audio internals)
- UNKNOWN: 1 (encryption/auth) + hardware-dependent items in §12
- Doc deltas fixed: 4 (§11)

## 14. Remaining Investigation Targets (if audit continues)

1. Call-site trace for every DEFINED-but-untraced constant (XOR sweep across `control-src`/`ldac-src`)
2. LDAC/LHDC runtime state machine (`ldac-src` `getHDACStatus` flows)
3. LE-Audio + `EarphonesPluginImpl` newer command additions
4. Case reset/wake commands (search `case-src` reset/boot/power)
5. `NothingWatchParser`/`WatchCommandParser` — watch-side commands (out of buds scope; keep for CMF)

**Buds RE phase readiness: AUDIT COMPLETE → READY TO FREEZE** (implementation may proceed from §5/§6/§7 maps; only OTA + codec internals and hardware-verified semantics remain firmware-side).

## 15. Evidence file map

- Framing/CRC: `re/SMART_DIAL.md` + `nothing-buds/app/src/main/java/com/nothingbuds/protocol/CRC16.kt`
- Command constants: `re/control-src/com/nothing/base/protocol/constant/ProtocolConstant.java`
- Builders: `re/control-src/com/nothing/core/ext/TWSDeviceExtKt.java`
- EQ entities: `re/proto-src/com/nothing/core/entity/{EQEntity,SimpleEQEntity,EQModeEntity,AdvanceCustomEQEntity,ClarityBoostEntity,MidUnitAdvanceCustomEQModeEntity}.java`
- Dirac: `re/dirac-src/com/nothing/earbase/unknown/entity/DiracOpteoEQ.java`; `dirac-src/.../equalizer/*`
- Battery: `re/proto-src/com/nothing/earbase/ota/entity/DeviceBattery.java`
- Device codes: `re/control-src/com/nothing/earbase/control/ControlGestureViewModel.java`; `.../espeon/control/ControlItemViewModel.java`
- Model gates: `re/control-src/com/nothing/{espeon,ear,heracross,hoothoot,hitmontop,donphan,corsola,ear/three,...}/*/IOTProductDevice*.java`
- OTA: `re/proto-src/com/nothing/nt_ear_ota/ActsSppRawParser.java`; `re/proto-src/com/nothing/link/bluetooth/sdk/connect/spp/XSppOTAConnector.java`; `re/proto2-src/com/nothing/ota/device/OTADevice.java`; `re/proto-src/com/nothing/earbase/ota/slice/*`; `re/case-src/com/nothing/nt_ear_ota/NtEarOtaHostImpl.java` (transport kinds + 00001101 SPP UUID)
- SPP/BLE service inventory: `re/proto2-src/com/nothing/nt_ble/plugin/EarphonesPluginImpl.java`; `re/proto2-src/com/nothing/link/bluetooth/sdk/connect/spp/XSppConnector.java`; `re/proto2-src/com/nothing/link/bluetooth/sdk/connect/ble/XBleOTAConnector.java`; `re/proto-src/com/nothing/protocol/connector/BaseSppConnector.java`
- Feature-bit map: `re/proto-src/com/nothing/base/protocol/entity/DeviceSupportFeature.java`
- Service-data scans: `re/case-src/com/nothing/earbase/os/cache/ParseUtil.java`; `re/case-src/com/nothing/broadcase/util/BleBroadcastParseUtil.java`
- Case BLE: `re/case-src/com/nothing/caseble/{NothingCaseParser,NtCaseBleApi,XCaseBleConnector,XCaseBleParser,NtPeerLinkBleUuids,PeerLinkAdvParser}.java`
- Scan/transport: `re/proto2-src/com/nothing/link/bluetooth/sdk/scan/parser/NothingParser.java`; `re/case-src/com/nothing/base/view/BaseApplication.java` (XBluetoothConfig)
- Specialized deep-dives: `re/SMART_DIAL.md`, `re/CASE_PROTOCOL.md`