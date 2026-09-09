# Nothing Buds

A native Android companion app for Nothing and CMF earbuds, built with Kotlin and Jetpack Compose.

> **Status:** Independent community project. Earbud features are model- and firmware-dependent and are based on reverse-engineering of the Nothing / CMF Bluetooth SPP protocol.

## Features

### Connection
- Bluetooth discovery and connection handling
- Automatic reconnect with retry/backoff
- Android companion-device integration
- Background connection and boot handling

### Sound
- Noise Control: Off, Transparency, ANC levels, Adaptive where supported
- Equalizer with model-specific preset and custom-EQ support
- Bass enhancement
- Spatial audio
- Low-latency mode
- Detail enhancement on compatible devices
- LHDC on supported models
- Experimental Personal Sound Calibration and generated **My EQ** profiles where supported

### Earbud controls
- In-ear detection
- Model-specific gesture configuration
- Ear-tip fit / seal testing where supported
- Multipoint / dual-device controls
- Auto power-off
- Model-dependent charging-case controls

### Device information
- Left/right battery state
- Firmware information
- Device and model detection
- Quick Settings Noise Control tile

## Supported devices

Support is capability-driven rather than universal. The app contains model-specific behavior for Nothing and CMF earbuds represented in the reverse-engineering research under [`re/`](re/).

A feature being present in the app does **not** mean that every earbud model supports it. Unsupported capabilities should remain hidden or disabled rather than being assumed.

## Architecture

```text
Jetpack Compose UI
        │
        ▼
   MainActivity
        │
        ▼
  BudsRepository ◄──── EarbudsState
        │
        ▼
     BudsService
        │
        ├── Bluetooth / A2DP discovery
        ├── SPP socket connection
        ├── Serialized command queue
        ├── Response handling
        └── Android notifications / background events
                │
                ▼
        Nothing / CMF SPP protocol
        ├── Commands
        ├── PacketBuilder
        ├── ResponseParser
        └── CRC16
```

The implementation keeps protocol handling separate from the Compose presentation layer and uses explicit model capability checks where protocol behavior differs between products.

## Project structure

```text
app/src/main/java/com/nothingbuds/
├── data/          # State, repository, companion pairing
├── protocol/      # Commands, packet building, CRC, response parsing
├── qs/            # Quick Settings integration
├── service/       # Bluetooth/background service and notifications
└── ui/            # Compose screens and theme

re/                # Reverse-engineering notes and protocol research
.ai/               # Historical implementation/research notes
.github/           # CI workflow
```

## Build

### Requirements

- Android Studio or a compatible Gradle environment
- JDK 17
- Android SDK 37
- Android 8.0 (API 26) or newer

The repository includes the Gradle wrapper.

### Debug build

```bash
./gradlew assembleDebug
```

APK output:

```text
app/build/outputs/apk/debug/app-debug.apk
```

A `copyDebugApk` task is also available when the project build configuration provides it.

## Continuous integration

GitHub Actions builds the debug APK for changes to the application/build configuration and can also be started manually. The workflow uses JDK 17 and uploads the resulting APK as an artifact.

## Reverse engineering

This project does not use an official Nothing SDK. The protocol implementation is based on observed device traffic, decompiled application behavior, and model-specific research.

The [`re/`](re/) directory is the primary technical research archive. Findings should be treated according to their evidence level and should not be promoted from unknown/inferred behavior to confirmed behavior without supporting evidence.

Useful research entry points include:

- [`re/INDEX.md`](re/INDEX.md)
- Protocol command documentation under [`re/PROTOCOL/`](re/PROTOCOL/)
- EQ research under [`re/EQ/`](re/EQ/)
- Model-specific research under [`re/`](re/)

## Diagnostics and privacy

Diagnostic export is intended for troubleshooting. Diagnostic data may include Bluetooth/device identifiers and other connection state. Review and redact exported logs before sharing them publicly.

## Limitations

- Capability support varies by earbud model and firmware.
- Reverse-engineered formats may be incomplete or may differ across firmware versions.
- Some protocol behavior remains model-specific or unconfirmed.
- Experimental features can fail on unsupported devices.
- This project is not a medical device and experimental audio calibration is not a medical hearing test.

## Disclaimer

**Nothing Buds is an independent community project and is not affiliated with, endorsed by, or sponsored by Nothing Technology or CMF.** Nothing and CMF are trademarks of their respective owners.

Use the application at your own risk. Sending unsupported values to an earbud may produce unexpected behavior.

## Contributing

Useful contributions include reproducible bug reports, model/firmware compatibility results, protocol observations, and carefully redacted diagnostic captures.

When reporting a device-specific issue, include where possible:

- Earbud model
- Firmware version
- Android version
- Reproducible steps
- Redacted diagnostic information

## License

No license file is currently included in this repository. Do not redistribute this code under an assumed open-source license until a license is added by the project owner.
