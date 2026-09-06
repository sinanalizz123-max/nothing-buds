# EQ Protocol Commands (Nothing X, source-verified)

All IDs from `TWSDeviceExtKt` (`re/dirac-src/com/nothing/core/ext/TWSDeviceExtKt.java`)
and `ProtocolConstant` (`re/proto-src/com/nothing/base/protocol/constant/ProtocolConstant.java`).
Payload shape: `toByteArray$default(v,0,1)` = 2-byte LE `[v, 0x00]`
(`re/proto-src/com/nothing/base/util/ext/DataExtKt.java`); floats 4-byte LE.

| Operation | GET | SET | SET payload | Response | Products | Confidence |
|---|---|---|---|---|---|---|
| Dirac preset select | 0xC050 (49232) | 0xF01D (61469) | `[type, 00]`, type 0–8 | ACK + `BasicInt` readback → row select | B172/B168/B179/B184/B175, unknown-Dirac | CONFIRMED |
| Standard preset select | 0xC01F (49183) | 0xF010 (61456) | `[mode, 00]`, `EQModeEntity.Mode` 0–7 | ACK + `BasicInt` readback | simple/unknown-simple/Ear2-simple | CONFIRMED |
| Codec (HDAC) check | 0xC029 (49193) `GET_LHDC_COMMANDS` | — | — | `BasicInt`: 0 = proceed, else warn dialog, nothing sent | espeon/girafarig/(gligar/forretress dead code)/unknown | CONFIRMED |
| Product custom curve (3-band) | 0xC044 (49220) | 0xF041 (61505) `SET_CUSTOM_EQ` | `CustomEQ` 5+n·16 float struct (see `../CUSTOM_EQ/F041_C044.md`) | ACK + GET-cache refresh + radar refresh | all Dirac VMs + simple models | CONFIRMED |
| Advance custom mode flag | 0xC04C (49228) | 0xF04F (61519) | `[ON=01, 00]` (`AdvanceCustomEQEntity.Mode` OFF 0/ON 1) | ACK | `supportAdvanceEq` products (Ear 2/3, EarTwos, Elekid), unknown-generic | CONFIRMED |
| Advance custom values (8-band) | 0xC04D (49229; getPayload `[profileIndex]`) | 0xF050 (61520) | `EQEntity` 6+n·13 float struct (see `../ADVANCED_EQ/F04F_F050.md`) | ACK | same as above | CONFIRMED |
| Third-driver custom mode | 0xC06C (49260) | 0xF06C (61548) | `[mode, 00]` (builder only) | UNKNOWN | UNKNOWN | UNKNOWN (zero callers) |
| Third-driver custom value | 0xC06D (49261) | 0xF06D (61549) | `EQEntity.obtainDataPacket()` (builder only) | UNKNOWN | UNKNOWN | UNKNOWN (zero callers) |
| `SimpleEQEntity` packet | 0xC044 | 0xF041 | 5+n·13 float struct (builder only) | UNKNOWN | UNKNOWN | UNKNOWN (zero callers) |
| `GET_ADAPTIVE_EQ_MODE` | 0xC043 (49219) | — | — | UNKNOWN | UNKNOWN | UNKNOWN (zero callers; likely non-EQ) |

Evidence: `TWSDeviceExtKt.java:23-34` (IDs), `:167-195` (advance builders),
`:227-289` (third-driver/simple/`eqMode`), `:321-328` (`diracOpteoEQ`),
`:554-561` (`customEQValue`); `ProtocolConstant.java:31,34,57-58,101,110,119,130,158-159`;
`TWSDeviceBuilder.java:189-201,339-379,483-516,581` (SET/GET/sync/async semantics).

Writes use `syncSetResponse` (ACK-gated) then refresh the GET cache; reads on
screen entry are fire-and-forget (`sendMessage$default`). Re-tapping the
selected row sends nothing (guard in every `setEQMode`).
