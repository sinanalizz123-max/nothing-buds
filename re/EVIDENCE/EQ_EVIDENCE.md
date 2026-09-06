# EQ Evidence Index

Format: Finding | Evidence source | Class | Method | Product | Command | Confidence | Status.
Paths relative to repo root; `re/` = decompiled Nothing X (JADX from user-installed APK).

1. All 7 B172 rows write F01D | `re/dirac-src/.../espeon/equalizer/EqualizerViewModel.java:224-233,306-323` | EqualizerViewModel | initSoundTypes/sendEqModelData | B172 | F01D/C050 | CONFIRMED | current
2. Mode writes are `[v,00]` 2-byte LE | `re/proto-src/.../base/util/ext/DataExtKt.java` (`toByteArray$default`→width 2) | DataExtKt | toByteArray | all | F01D/F010/F04F | CONFIRMED | current
3. HDAC gate logic | `re/ldac-src/.../espeon/equalizer/EqualizerViewModel$getHDACStatus$1$1.java` | (suspend lambda) | invokeSuspend | B172 | C029→F01D | CONFIRMED | current
4. Gate conditions per VM | espeon `:244`; girafarig `:236-246`; gligar `:213-223`; forretress `:212-222`; donphan `:250-…` (none) | EqualizerViewModel | setEQMode | B172/B179/B184/B175/B168 | — | CONFIRMED | current
5. F010 mode enum 0–7 | `re/dirac-src/.../core/entity/EQModeEntity.java:24-32,81-87` | EQModeEntity.Mode | obtainDataPacket | simple | F010/C01F | CONFIRMED | current
6. 3-band custom packet | `re/proto-src/.../earbase/equalizer/entity/CustomEQ.java` + `BaseEqualizerViewModel.java:712-821` | CustomEQ/BaseEqualizerViewModel | obtainDataPacket/setCustomEQ | all Dirac+simple | F041/C044 | CONFIRMED | current
7. Per-model freq/Q | espeon `:71-76,:457-480` (+identical gligar/girafarig/forretress/donphan consts); base `:545-567`; `IOTProductDeviceEspeon.java:105-118` | EqualizerViewModel | getFreq/getQ | all | — | CONFIRMED | current
8. 8-band advanced system | `EQEntity.java:29-40,184-223`; `AdvanceEQViewModel.java:1732-…,1785`; advanceTab `:74-87` | EQEntity/AdvanceEQViewModel | obtainDataPacket/sendProfileDataToDevice | Ear family | F04F/F050, C04C/C04D | CONFIRMED | current
9. Third-driver pair declared, unused | `ProtocolConstant.java:57-58,158-159`; `TWSDeviceExtKt.java:227-256`; repo-wide caller search = 0 hits | — | — | UNKNOWN product | F06C/F06D | UNKNOWN | open
10. `simpleCustomEQ` dead | `TWSDeviceExtKt.java:266-273`; caller search = 0 hits | — | — | — | F041 | UNKNOWN (dead) | open
11. Product→VM mapping | `IOTProductDevice{Espeon,Donphan,Hoothoot,Girafarig,Gligar,Forretress,Corsola,Heracross,EarTwo,EarThree,EarTwos,Elekid}.java` PRODUCT_ID/BT lines; `IOTDeviceManager.java:64-…,143-…,926-…,1140-…,1224-…`; per-product `IOT*Action.startEqualizerActivity` | — | — | all | — | CONFIRMED | current
12. B168/B185 split | `IOTDonphan.java:30-32` (true); `IOTHoothoot{White,Black,Orange}.java` (false); `IOTProductDeviceHoothoot.java:37,60-77` (B185, donphan action) | IOTDonphan | isSupportDirac | B168/B185 | — | CONFIRMED | NEW (corrects "hoothoot=B168 variant" shorthand) |
13. Unknown-cloud schema | `UnknownFunction.java:352-…` (`isDiracEq`=bitmask>0, `getEQList`, `getDiracOpteoEQList` bitmask decode); `UnknownProduct.java:736-…` (`diracByPowered`) | UnknownFunction | isDiracEq/getEQList/getDiracOpteoEQList | unknown | F01D/F010 branch | CONFIRMED | current
14. `WhenMappings` resolved | `UnknownEqualizerViewModel.java:95-169` | WhenMappings | static init | unknown | — | CONFIRMED | NEW (fixes earlier shifted-label attribution) |
15. C050=4 on real B172 | `log/nothingbuds_20260906_155244.log:71,106` | (our log) | — | B172 | C050 | CONFIRMED (device-observed) | current
16. `EqualizerTypeViewModel` source | absent in all extracts + file lists | — | — | all | — | UNKNOWN | open
17. C043 role | `ProtocolConstant` only, zero callers | — | — | — | C043 | UNKNOWN | open
18. Corsola/heracross EQ UI | action references `com.nothing.corsola.equalizer.EqualizerActivity` (not extracted); heracross has no EQ package | — | — | B163/B187 | — | UNKNOWN | open

Prior reports (historical, superseded in detail by `/re` docs where they conflict):
`.ai/EQ_REVERSE_ENGINEERING.md`, `.ai/EQ_IMPLEMENTATION_BLUEPRINT.md` — see
"Status / Changes Since Previous Report" appended to each.
Older research preserved untouched: `re/README.md`, `re/CASE_PROTOCOL.md`,
`re/SMART_DIAL.md`, `re/REVERSE_ENGINEERING_STATUS.md`, `*-src/`, dex/zips.
