# EQ Product Matrix (authoritative — source-verified)

Runtime selection (`re/control-src/com/nothing/device/IOTDeviceManager.java`):
`getProductByModelId(modelId)` scans registered products' color deviceLists
(`:926-…`, prefers non-`UnknownProduct`); `getNativeTemplateForModelId` picks the
color `IOTDevice` (`:1224-…`); `getAndCreateIOTDevice(mac, modelId)` clones it
per-MAC (`:143-…`). `getProductByBluetoothName` (`:1140-…`) is only used from
`NtEarPlugin` (case path). Each product's `IOTDeviceAction.startEqualizerActivity`
launches its fixed `EqualizerActivity` (e.g. donphan `:52-55`).

| Product | Model | Codename | EQ system | Rows | Opteo | Custom | Advanced 8-band | Codec gate |
|---|---|---|---|---|---|---|---|---|
| CMF Buds Pro 2 | B172 | espeon | Dirac F01D/C050 | 7 (0,3,1,5,2,4,6) | yes, reportType 10, HDAC-gated (`type==0 && hldcOrDiracOne()`, true) | 3-band F041 (140/980/3500, Q .8/.66/1.0) | no | type 0 only |
| CMF Buds | B168 | donphan | Dirac F01D/C050 | 7 if `isSupportDirac()` else 7-row non-Dirac variant (Dirac-EQ type 7 first) | yes iff `isSupportDirac()` (base `IOTDonphan` true; all B168 colors inherit) | 3-band F041 (same freq/Q) | no | NONE anywhere in donphan code |
| Hoothoot (24283) | B185 | hoothoot (own product, `IOTDonphanAction`) | Dirac VM, non-Dirac branch | 7 (type 7 first, no Opteo) | no (`isSupportDirac()=false` all colors) | 3-band F041 | no | none |
| CMF Buds 2 (24232) | B179 | girafarig | Dirac F01D/C050 | 7 (Opteo reportType 11 first) | yes, HDAC-gated (`type==0`, no product check) | 3-band F041 | no | type 0 only |
| 24241 | B184 | gligar | Dirac F01D/C050 | 6 (no Opteo) | no (type==0 branch present but unreachable — no type-0 row) | 3-band F041 | no | none effective |
| Headphone Pro (24211) | B175 | forretress | Dirac F01D/C050 | 6 (no Opteo) | no (type==0 branch present but unreachable — no type-0 row) | 3-band F041 | no | none effective |
| Buds Pro | B163 | corsola | UNKNOWN (own `com.nothing.corsola.equalizer.EqualizerActivity` referenced, not extracted) | UNKNOWN | UNKNOWN | UNKNOWN | no override (false) | UNKNOWN |
| 24253 | B187 | heracross | UNKNOWN (no EQ package extracted; `hldcOrDiracOne()=false`) | UNKNOWN | UNKNOWN | UNKNOWN | no override (false) | UNKNOWN |
| Ear (2) | — | ear/two | Simple F010/C01F + Advanced F04F/F050 | simple rows (`initSimpleEQItem`) | n/a | 3-band F041 + 8-band F050 | **yes** (`supportAdvanceEq()=true`) | n/a |
| Ear (B173), Nothing Ear (B171), Headphone (1) (B170) | B173/B171/B170 | ear-three/ear-twos/elekid | Advanced (`supportAdvanceEq()=true` each) | per `initSimpleEQItem` + advance editor | n/a | both | yes | n/a |
| Unrecognised | any | unknown (cloud `UnknownConfigs`) | Dirac iff `diracOpteo` bitmask>0 else simple | bitmask-driven (see `../EQ/EQ_UI_ROWS.md`) | iff `diracByPowered()` | 3-band F041 | mode read only | `type==0 && hldcOrDiracOne()` |

Capability defaults (`IOTProductDevice.java:107,191,195`):
`eqMutuallyExclusive()=false`, `spaceEqExclusive()=false`, `supportAdvanceEq()=false`
(not overridden by espeon/donphan/girafarig/gligar/forretress/corsola/heracross).

Product identity evidence: espeon B172 (`IOTProductDeviceEspeon.java:37-41,69-70,88`);
donphan B168 (`IOTProductDeviceDonphan.java:37,50-51,67` + colors `:58-60`);
hoothoot B185 (`IOTProductDeviceHoothoot.java:37,60-61,68-70,77`, action `IOTDonphanAction`);
girafarig B179 (`...Girafarig.java:41,59-60,74`); gligar B184 (`...Gligar.java:40,63-64,77`);
forretress B175 (`...Forretress.java:51,119-120,136`); corsola B163 (`...Corsola.java:31,39-40,65`);
heracross B187 (`...Heracross.java:44`, `hldcOrDiracOne=false :59-61`, `24253` `:77,92`).
