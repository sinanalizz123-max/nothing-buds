# Nothing X Reverse-Engineering Knowledge Base — Index

Start here. A future AI cloning this repository should read this file first,
then navigate into sections — no original investigation should need repeating.

## What lives where
- `/re` (this directory): canonical structured knowledge base. Section docs
  (`PROTOCOL/`, `MODEL_MAPPING/`, `DIRAC/`, `EQ/`, `CUSTOM_EQ/`, `ADVANCED_EQ/`,
  `THIRD_DRIVER/`, `CALL_CHAINS/`, `EVIDENCE/`, `UNKNOWN/`) hold cumulative
  findings with file:line evidence. Raw decompiled source lives in `dirac-src/`,
  `proto-src/`, `ldac-src/`, `control-src/`, `case-src/`, `proto2-src/`
  (JADX output; never compiled into the app).
- `/.ai`: high-level historical investigation reports
  (`EQ_REVERSE_ENGINEERING.md`, `EQ_IMPLEMENTATION_BLUEPRINT.md`) — kept as
  history with "Status / Changes" sections pointing here.
- Old research preserved untouched: `re/README.md`, `re/CASE_PROTOCOL.md`,
  `re/SMART_DIAL.md`, `re/REVERSE_ENGINEERING_STATUS.md` (marked historical
  as master index; still evidence for gestures/key-config).
- Captured device traffic: `log/` (repo root).

## Evidence hierarchy (highest wins on conflict unless documented otherwise)
1. Direct runtime hardware capture (`log/`, e.g. C050=4 on B172)
2. Decompiled source with actual caller/call chain
3. Decompiled implementation without confirmed caller (DECLARED only)
4. Cross-file inference (marked STRONG/PROBABLE, never CONFIRMED)
5. Historical/external research

Per-command status: DECLARED (constant/builder exists) · CALLED (runtime caller
found) · HARDWARE OBSERVED (device traffic confirmed) · INFERRED · UNKNOWN.

## Confidence terminology
CONFIRMED (source + caller or hardware) · STRONG EVIDENCE (convergent sources,
one link indirect) · PROBABLE · UNKNOWN. Area status: COMPLETED /
PARTIALLY VERIFIED / UNRESOLVED / HARDWARE VALIDATION REQUIRED.

## Current status
- EQ/Dirac/custom protocol: PARTIALLY VERIFIED (14 open items in
  `UNKNOWN/EQ_REMAINING_UNKNOWNS.md`; hardware validation required for B168
  gate, B179 flags, custom round-trip).
- Gestures/key-config: COMPLETED (see `REVERSE_ENGINEERING_STATUS.md` correction).
- Case BLE/transport: see `CASE_PROTOCOL.md`. Smart Dial: see `SMART_DIAL.md`.

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
