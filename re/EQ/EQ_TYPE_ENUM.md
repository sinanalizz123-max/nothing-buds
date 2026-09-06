# Canonical EQ Type Table

Two separate numeric systems share small integers — never mix them.
`type` = Dirac/UI row selector (F01D); `mode` = standard EQ mode (F010).

## F01D row types (Dirac VMs) — CONFIRMED 0–6, product-specific 7–8

| Type | Meaning | Product/branch | Evidence | Confidence |
|---|---|---|---|---|
| 0 | Dirac Opteo | B172/B179/B168-Dirac/unknown (iff row exposed) | all five `initSoundTypes`; espeon `:68,224-233` | CONFIRMED |
| 1 | Rock | same as above (B184/B175 included) | same | CONFIRMED |
| 2 | Electronic | same | same | CONFIRMED |
| 3 | Pop | same | same | CONFIRMED |
| 4 | Enhance Vocals | same | same | CONFIRMED |
| 5 | Classical | same | same | CONFIRMED |
| 6 | Custom (recall stored curve) | same | same; recall-only proven, no extra ops | CONFIRMED |
| 7 | "Dirac EQ" row (donphan non-Dirac screen); `DIRAC_OPTEO` in unknown-cloud list | B168-non-Dirac/B185; unknown-cloud | donphan VM branch; unknown pair (11,7) | CONFIRMED (row exists + writes F01D); effect name INFERRED from label only |
| 8 | Immersion Boost | unknown-cloud only (`DiracOpteoEQ` list) | unknown pair (12,8) | CONFIRMED (pair exists); on-bud effect UNKNOWN |

## F010 modes (`EQModeEntity.Mode`) — names CONFIRMED, runtime effects per name INFERRED except where rows prove them

| Mode | Enum name | Used by UI rows | Evidence | Confidence |
|---|---|---|---|---|
| 0 | FLAT_OR_BALANCED | Balanced | `EQModeEntity.java:24-32`; `initSimpleEQItem` | CONFIRMED |
| 1 | VOICE | More Voice | same | CONFIRMED |
| 2 | MORE_TREBLE | More Treble | same | CONFIRMED |
| 3 | MORE_BASE | More Bass | same | CONFIRMED |
| 4 | DIRAC_EQ | no row in extracts | enum only | UNKNOWN (effect unproven) |
| 5 | SIMPLE_CUSTOM_EQ | Custom (simple) | `initSimpleEQItem` | CONFIRMED |
| 6 | NEW_VOICE | unknown-cloud simple rows only | unknown pair mapping | CONFIRMED (mapping); effect UNKNOWN |
| 7 | NEW_INSTRUMENT | unknown-cloud simple rows only | unknown pair mapping | CONFIRMED (mapping); effect UNKNOWN |

## Unknown-cloud simple `EQ` enum → type (via `WhenMappings`, CONFIRMED mapping)
FLAT_BALANCED→0, MORE_BASE→3, MORE_TREBLE→2, VOICE→1, NEW_VOICE→6,
NEW_INSTRUMENT→7, SIMPLE_CUSTOM_EQ→5.
(`UnknownEqualizerViewModel.java:95-169`.)
