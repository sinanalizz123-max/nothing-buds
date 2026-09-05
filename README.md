# Nothing Buds

A native Android companion app for Nothing and CMF earbuds, built with Kotlin and Jetpack Compose.

> **Project status:** Experimental / reverse-engineering project. Protocol behavior is model-dependent and some features still require validation against additional earbuds.

## What it does

Nothing Buds communicates with supported earbuds over Bluetooth and exposes controls that are normally handled by the official companion app.

### Current feature areas

- **Bluetooth connection & automatic reconnect**
  - Dedicated foreground service for the earbuds connection
  - Saved-device reconnect logic with retry/backoff
  - Bluetooth attach/detach handling
- **Listening controls**
  - ANC: Off, Low, Mid, High, Adaptive
  - Transparency mode
  - Quick Settings ANC tile
- **Equalizer**
  - Balanced, Voice, More Treble, More Bass, Custom
  - Model-specific Dirac Opteo handling where supported
- **Audio extras**
  - Bass boost / enhanced bass
  - Spatial audio
  - Low-latency mode
  - Detail enhancement
  - LHDC support on compatible models
- **Earbud controls**
  - In-ear detection
  - Gesture configuration
  - Ear-tip fit / seal test
  - Multipoint / dual-device controls
  - Auto power-off
- **Device information**
  - Battery state
  - Firmware information
  - Device/model detection
- **Background integration**
  - Companion-device association on Android 12+
  - Boot handling
  - Connection notifications
  - Shareable diagnostic log export

## Supported devices

The implementation targets the Nothing / CMF Bluetooth SPP protocol and contains model-specific capability handling. Support is **not universal** across every Nothing or CMF product.

The protocol layer currently includes explicit handling for features such as Dirac Opteo EQ, LHDC, bass-enhancer variants, multipoint, ANC, gestures, and model-dependent case LED controls.

Because this project is based on reverse-engineering, a feature appearing in the UI does not necessarily mean every earbud model supports it.

## Architecture

```text
Android UI (Jetpack Compose)
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
        ├── Command queue + serialized writes
        ├── Response handling
        └── Notifications / background events
                │
                ▼
        Nothing / CMF SPP protocol
        ├── Commands
        ├── PacketBuilder
        ├── ResponseParser
        └── CRC16
```

The code is separated into `data`, `protocol`, `service`, `qs`, and `ui` areas, keeping protocol work independent from the Compose presentation layer.

## Project structure

```text
app/src/main/java/com/nothingbuds/
├── data/
│   ├── BudsRepository.kt
│   ├── CompanionPairing.kt
│   └── EarbudsState.kt
├── protocol/
│   ├── Commands.kt
│   ├── Crc16.kt
│   ├── PacketBuilder.kt
│   └── ResponseParser.kt
├── qs/
│   └── AncTileService.kt
├── service/
│   ├── BootReceiver.kt
│   ├── BluetoothConnectionReceiver.kt
│   ├── BudsCompanionService.kt
│   ├── BudsService.kt
│   └── NotificationHelper.kt
└── ui/
    ├── MainActivity.kt
    ├── screens/
    └── theme/
```

## Build

### Requirements

- Android Studio or a compatible Gradle environment
- JDK 17
- Android SDK 37
- Android device running Android 8.0 (API 26) or newer

The project includes the Gradle wrapper, so a local Gradle installation is not required.

### Build a debug APK

```bash
./gradlew assembleDebug
```

The APK is generated at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

The project also contains a `copyDebugApk` task that copies the debug APK into the repository's `debug/` directory after a successful debug build.

## CI

GitHub Actions builds the debug APK on pushes and pull requests targeting `master`, and the workflow can also be started manually. The workflow uses JDK 17 and uploads the generated debug APK as an artifact.

## Reverse-engineered protocol

The protocol implementation is based on observed Nothing / CMF SPP traffic and behavior rather than a public vendor SDK. Commands are represented as 16-bit values and response handling is centralized in the protocol package.

The source documents protocol assumptions directly in code, including command/response relationships and model-specific behavior. Treat these details as reverse-engineering notes rather than an official specification.

## Diagnostics

The app includes a diagnostic log-sharing flow. The version row can be tapped seven times to export application logs and earbuds state for troubleshooting.

**Privacy note:** exported logs can contain device identifiers such as Bluetooth MAC addresses. Do not publish raw diagnostic logs publicly without reviewing and redacting them.

## Important repository notes

This repository currently contains a committed `debug.keystore` and `debug.keystore.base64`. The latter is explicitly allowed by `.gitignore`, and the build configuration can recreate the keystore from that Base64 file. For a public release, these development signing artifacts should be removed from version control and replaced with a proper release-signing strategy.

There is also no repository license file at the time of writing, so the code should not be redistributed under an assumed open-source license.

## Limitations

- Earbud feature support varies by model and firmware.
- Reverse-engineered packet formats may change or be incomplete.
- Some advanced protocol formats, including parts of Dirac custom EQ handling, are still being validated.
- The project is not an official Nothing product or official Nothing software.

## Disclaimer

**Nothing Buds is an independent community project and is not affiliated with, endorsed by, or sponsored by Nothing Technology or CMF.** Nothing and CMF are trademarks of their respective owners.

Use the app at your own risk. Writing unsupported values to an earbud may produce unexpected behavior.

## Contributing

Bug reports, protocol observations, model compatibility results, and reproducible logs are especially useful. When reporting an issue, include the earbud model, firmware version, Android version, and a redacted diagnostic log when possible.

## Development philosophy

The project favors small, explicit protocol abstractions and model capability checks over assuming that a single command format works for every Nothing / CMF device.
