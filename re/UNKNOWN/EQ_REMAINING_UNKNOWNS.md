# EQ Remaining Unknowns (genuinely unresolved)

1. `EqualizerTypeViewModel` class source (ctor/fields; usage-inferred only).
2. `DeviceConstant.NOISE_CANCELLATION_*` reportType string values (analytics-only).
3. Third-driver 0xF06C/0xF06D product and purpose (zero callers in extracts).
4. Radar gain min/max (`EQGainDragBarViewModel` not extracted).
5. `EQEntity.profileIndex` semantics; advanced-editor gain range.
6. B168 HDAC behavior on real hardware (code has no gate; untested on buds).
7. `eqMutuallyExclusive` / `spaceEqExclusive` runtime effects.
8. `GET_ADAPTIVE_EQ_MODE` 0xC043 role (zero callers).
9. Corsola B163 EQ screen behavior (activity referenced, not extracted).
10. Heracross B187 EQ behavior (no EQ package extracted).
11. `EarTwoSimpleEQFragment` rows (referenced, not extracted).
12. `SimpleEQEntity`/`simpleCustomEQ` purpose (dead builder here).
13. Home-screen EQ label data source (no EQ reads in extracted `NothingEarViewModel`).
14. B179 product-file capability flags (none found; behavior comes from its VM only).
