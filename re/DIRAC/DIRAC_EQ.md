# Dirac EQ (Nothing X, source-verified)

## Wire
`TWSDeviceExtKt.diracOpteoEQ(tws, type)`:
SET 0xF01D payload `[type, 0x00]` (2-byte LE), GET 0xC050 → `BasicInt`
(`TWSDeviceExtKt.java:25,32,321-328`). All writes ACK-gated (`syncSetResponse`)
with manual GET-cache refresh (espeon `EqualizerViewModel.java:358-376`).

## Level meanings (CONFIRMED — identical `type` in all five Dirac VMs)
0 Opteo, 1 Rock, 2 Electronic, 3 Pop, 4 Enhance Vocals, 5 Classical, 6 Custom-recall,
7 "Dirac EQ" (donphan non-Dirac row only), 8 Immersion Boost (unknown-cloud only).
`DiracOpteoEQ` enum order: DIRAC_OPTEO, OPTEO, ROCK, ELECTRONIC, POP,
ENHANCE_VOCALS, CLASSICAL, CUSTOM_EQ, IMMERSION_BOOST
(`earbase/unknown/entity/DiracOpteoEQ.java:10-19`).

## Per-product behavior
- **B172**: 7 rows via F01D; only type 0 HDAC-gated
  (`type==0 && hldcOrDiracOne()`; espeon `:236-249`). Gate = GET 0xC029 sync read:
  null/≠0 → `needHDACWarning` → `ConfirmMsgDialog`, nothing sent; 0 → write
  (`…$getHDACStatus$1$1.java`).
- **B179**: same 7 rows/F01D; gate `type==0` (no product check).
- **B168 Dirac**: same 7 rows/F01D; **no gate at all** (donphan `:250-…,317-323`).
- **B168 non-Dirac / B185**: type-7-led 7 rows via F01D, no gate, `hasDiracEq=false`.
- **B184/B175**: 6 rows via F01D (F01D *is* their whole EQ); no Opteo row.
- Unknown-cloud: `diracOpteo` bitmask>0 → Dirac rows; Opteo row hidden unless
  cloud `diracByPowered()` (`UnknownSimpleActivityViewModel.java:706-712`;
  `UnknownProduct.java:736-…`); same F01D/C050 + `type==0 && hldcOrDiracOne()` gate.

## Read/authority
Dirac VMs read **only** C050 (`getEQData`, e.g. espeon `:122-213`) and select the
row whose `type` matches (`updateEQMode`, base `:868-931`). They never read C01F,
so C01F≠C050 (e.g. our log: `eq=BALANCED` + C050=4) is normal: C050 wins for the
Dirac screen; C01F is simply not consulted there.

## Custom recall
Type 6 sends F01D `[06 00]` only — no extra operations (same `sendEqModelData`
path as every row). The stored curve itself is the 3-band F041 blob
(see `../CUSTOM_EQ/F041_C044.md`).
