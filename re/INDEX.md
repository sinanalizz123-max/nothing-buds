# Nothing X Reverse-Engineering Knowledge Base — Index

Start here. Then navigate into sections. Raw decompiled source lives in
`dirac-src/`, `proto-src/`, `ldac-src/`, `control-src/`, `case-src/`, `proto2-src/`
(JADX output; never compiled into the app). Historical notes preserved:
`README.md`, `CASE_PROTOCOL.md`, `SMART_DIAL.md`, `REVERSE_ENGINEERING_STATUS.md`.

## EQ knowledge (cumulative, source-verified)
- Protocol commands/payloads: `PROTOCOL/EQ_COMMANDS.md`
- Product→EQ-system matrix: `MODEL_MAPPING/EQ_PRODUCT_MATRIX.md`
- Dirac behavior: `DIRAC/DIRAC_EQ.md`
- UI rows per product: `EQ/EQ_UI_ROWS.md`
- 3-band custom (F041/C044): `CUSTOM_EQ/F041_C044.md`
- 8-band advanced (F04F/F050): `ADVANCED_EQ/F04F_F050.md`
- Third-driver F06C/F06D (zero callers): `THIRD_DRIVER/F06C_F06D.md`
- End-to-end call chains: `CALL_CHAINS/EQ_CALL_CHAINS.md`
- Evidence index (finding→file:line→confidence): `EVIDENCE/EQ_EVIDENCE.md`
- Open questions: `UNKNOWN/EQ_REMAINING_UNKNOWNS.md`

## Historical high-level reports
- `.ai/EQ_REVERSE_ENGINEERING.md` (1st pass) and
  `.ai/EQ_IMPLEMENTATION_BLUEPRINT.md` (2nd pass) — each ends with a
  "Status / Changes Since Previous Report" section noting what this KB
  confirmed, corrected, or newly discovered.

## Key conclusions (one-line)
- Dirac products (B172/B168/B179/B184/B175) run all EQ rows through F01D/C050;
  only Opteo is codec-gated, and only on espeon/girafarig/generic paths.
- Custom curves are 3-band float structs on F041/C044 — not F06C/F06D
  (which have no callers anywhere).
- 8-band editing (F04F/F050) belongs to the Ear/Headphone line, not CMF buds.
- Hoothoot is its own product (B185), not a B168 variant.
