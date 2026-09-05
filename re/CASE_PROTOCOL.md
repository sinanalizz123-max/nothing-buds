# Nothing Ear Smart Dial — Case protocol trace

Status of every claim is tagged **CONFIRMED** (in-artifact code path) / **PARTIAL**
(convergent evidence, one hop inferred) / **UNKNOWN** (outside the app artifact).

## 1. Scope and question

"Smart dial" = the case's physical dial (device code **4** on the key-config channel).
Two DIFFERENT transports exist in the app for the case; this doc separates them and
answers: which channel carries key-config for the dial, and what does the case BLE channel do.

## 2. The two transport domains

| Domain | Class(es) | Carries |
|---|---|---|
| **Key-config / "Smart Dial"** | `ControlConfigurationEntity` → `HeadsetSppConnector` | logical case rows (device=4) over the ear's GATT link — CONFIRMED |
| **Case BLE** | `NtCaseBleApi` / `NtPeerLinkBleApi` / `XCaseBleConnector` / `NtPeerLinkBleUuids` | box LEDs, wake-up, OTA, case battery — NOT key-config — CONFIRMED |

Grepping the whole `case-src/` artifact for `ControlConfigurationEntity`, `setGestureData`,
`KEY_CONFIGURATION`, `0xF003`/61443 finds **no** key-config references in the case-BLE stack.
The dial configuration never goes over case BLE.

## 3. Key-config channel for the dial (CONFIRMED)

- Logical rows `(device=4)` ride the same channel as buds: 5-byte payload
  `[0x01, device, button, gesture, operation]` → 0xC018 query / 0xF003 set (see SMART_DIAL.md §7).
- Transport: BLE GATT write on the ear NtPeerLink service — SERVICE
  `0000fd90-0000-1000-8000-00805f9b34fb`, WRITE `68745353-1810-4b13-83a2-c1b21b652c9b`,
  notify `ca235943-1810-45e6-8326-fc8ca3bc45ce`. Frame format, CRC16-ARC and FSN see
  SMART_DIAL.md §7.
- Espeon-specific case gesture → op defaults and whitelists: SMART_DIAL.md §5/§10.

## 4. Case BLE in this app (CONFIRMED role)

- `case-src/com/nothing/caseble/NtCaseBleApi.java` — high-level case API: connect, find case MAC
  for an ear, clear binding, `sendData` with fire-and-forget callbacks.
- `case-src/com/nothing/caseble/NtPeerLinkBleApi.java` (extends/uses `NtPeerLinkBleApi`) + 
  `XPeerLinkBleConnector.java` / `XCaseBleConnector.java` — GATT over the same NtPeerLink UUIDs
  (case instance), parser `NothingCaseParser` / `XCaseBleParser`.
- Consumers in-artifact: **OTA** (`nt_ear_ota/NtEarOtaCaseBleSession`, `NtEarOtaHostImpl`),
  battery/box state — not control configuration.

## 5. Ear ↔ case relay (PARTIAL → UNKNOWN)

- After a successful 0xF003 for device=4 the UI shows "case restarts to apply"; the app treats
  the save as complete once the ear's sync response returns `rspCode==0` (Message.isOk()).
- The ear relaying the stored config to the case over the proprietary ear↔case link, and the
  dial-firmware applying it, is **firmware behavior, not present in this app artifact** — UNKNOWN.
- Firmware factory defaults (before the app ever writes) are device-defined, not app-defined — UNKNOWN.

## 6. Status map (for prompt §11-13 "case protocol")

| Question | Answer | Status |
|---|---|---|
| Does smart dial use a separate/parallel protocol? | No. Same 0xF003 key-config channel as the buds; dial = device=4 rows. | CONFIRMED |
| Does the case BLE stack touch key-config? | No references in `case-src/`. | CONFIRMED |
| Who writes the wire bytes? | `Message.obtainDataPacket()` — SOF 0x55, ctl/cmd/len/fsn/crc16 described in SMART_DIAL.md §7. | CONFIRMED |
| How are case slots read back? | 0xC018 payload `[count,(dev,btn,gest,op)×count]`, parsed UNSIGNED via `DataExtKt.toMultiValues`. | CONFIRMED |
| What happens inside the case/dial firmware after an op? | Not in artifact (relay + LED/etc. runtime behavior). | UNKNOWN |
| Factory defaults for rotation etc.? | Not in artifact (app writes nothing proactively). | UNKNOWN |

## 7. Key files

- `case-src/com/nothing/caseble/NtPeerLinkBleUuids.java` — SERVICE/WRITE/NOTIFY UUIDs.
- `case-src/com/nothing/caseble/NtCaseBleApi.java`, `NtPeerLinkBleApi.java`,
  `XCaseBleConnector.java`, `XPeerLinkBleConnector.java`, `NothingCaseParser.java`.
- `case-src/com/nothing/nt_ear_ota/NtEarOtaCaseBleSession.java` — case BLE OTA usage.
- `re/SMART_DIAL.md` — full key-config trace (payload, frame, CRC, op map, whitelists).
- `proto-src/…` + `proto2-src/…` — retained decompiled sources used to verify every claim.