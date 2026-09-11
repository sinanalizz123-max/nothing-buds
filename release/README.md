# Release APKs

This folder holds signed release builds for sideloading (e.g. `app-release.apk`).

- APK binaries are **not** committed to git (see `.gitignore`); only this README is tracked.
- The published artifacts live on the [GitHub Releases page](https://github.com/sinanalizz123-max/nothing-buds/releases).
- To build one: `./gradlew :app:assembleRelease` in the ext4 build copy with
  `RELEASE_STORE_PASSWORD`, `RELEASE_KEY_ALIAS` and `RELEASE_KEY_PASSWORD` exported.
