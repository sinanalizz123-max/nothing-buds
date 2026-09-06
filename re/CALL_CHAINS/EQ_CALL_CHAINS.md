# EQ Call Chains (Nothing X, source-verified)

Notation: `File.java:line` under `re/`.

## Dirac preset tap (B172)
`espeon/.../EqualizerActivity.onClickType` (`:318-322`)
→ `EqualizerViewModel.setEQMode` (reselect-guard `:239-243`; `type==0 &&
hldcOrDiracOne()` → `getHDACStatus` `:244-248`, else `sendEqModelData`)
→ `getHDACStatus` (`:449-454`) → `…$getHDACStatus$1$1`: `sendMessageSync`
GET 0xC029 → null/≠0: `needHDACWarning.post` → `ConfirmMsgDialog`
(activity `:240-267`), end; 0 → `sendEqModelData`
→ coroutine `AnonymousClass1` (`:306-323`): buried point + `diracOpteoEQ(tws,type)`
(`TWSDeviceExtKt.java:321-328`) + `syncSetResponse(F01D, [t,00])`
→ ACK ok: refresh C050 cache + single-row select (`:358-438`).

## Dirac product, non-Opteo tap / donphan any tap
Same minus the gate (donphan `setEQMode` `:250-…` launches the write coroutine
directly, `:317-323`; girafarig/gligar/forretress gate only `type==0`).

## Simple preset tap
`BaseSppProtocol.setEQMode` (`BaseSppProtocol.java:243-280`):
`eQMode` write F010 `[m,00]` via `setSync` → VM `AnonymousClass1`
(`BaseEqualizerViewModel.java:680-704`): `setCacheCommandsManualPayload(0xC01F,
[type])`, single-row select, `updateFromCache(0xC01F)`.

## Custom drag (all Dirac + simple products)
`onChange(index)` (espeon activity `:328-332`) → `setCustomEQ`
(`:712-737`) → `CustomEQ.obtainDataPacket(-maxGain, bands)` (`:779`) →
`customEQValue` SET 0xF041 `syncSetResponse` (`:781-789`) → ACK: GET-cache
refresh + `onUpdate` + `updateCustomEQValue` → radar (`:804-866`).

## Screen open
`register()` → `getEQData()` (C050 on Dirac VMs, e.g. espeon `:122-207`;
C01F on base `:416-501`) + `getCustomEQData()` (C044, base `:323-408`) +
`initSoundTypes()` (base `:313-321`). Unknown-generic additionally reads C04C
mode + spatial config (`UnknownEqualizerViewModel.java:180,254-…,778-…`).

## Advanced editor (Ear family)
`AdvanceEQViewModel.sendProfileDataToDevice` (`:1732-…,1785`) → F050
`syncSetResponse`; mode ON via F04F (advanceTab `:74-87`).

## Product dispatch
`IOTDeviceManager.getProductByModelId` (`:926-…`) → product →
`IOTDeviceAction.startEqualizerActivity` (per-product Activity class) → fixed VM.
`getProductByBluetoothName` (`:1140-…`) used only in `NtEarPlugin`.
