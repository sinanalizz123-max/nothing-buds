import java.util.Base64

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "com.nothingbuds"
  compileSdk = 37

  defaultConfig {
    applicationId = "com.nothingbuds"
    minSdk = 26
    targetSdk = 37
    versionCode = 1
    versionName = "1.0.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  signingConfigs {
    create("debugConfig") {
      // Sign debug builds with a stable key so installed updates keep working. The keystore
      // never lives in the repo: prefer a local file, else the base64 injected by CI as a
      // GitHub secret (ANDROID_DEBUG_KEYSTORE_BASE64), else AGP's default debug keystore.
      val keystoreFile = file("${rootDir}/debug.keystore")
      val envBase64 = System.getenv("ANDROID_DEBUG_KEYSTORE_BASE64")
      when {
        keystoreFile.exists() -> {
          storeFile = keystoreFile
        }
        envBase64 != null && envBase64.isNotBlank() -> {
          keystoreFile.writeBytes(Base64.getDecoder().decode(envBase64.trim()))
          storeFile = keystoreFile
        }
        else -> {
          // No committed key: fall back to the well-known per-developer debug keystore
          // (~/.android/debug.keystore, auto-created by AGP).
          storeFile = file(
            "${System.getProperty("user.home")}/.android/debug.keystore"
          )
        }
      }
      storePassword = "android"
      keyAlias = "androiddebugkey"
      keyPassword = "android"
    }

    create("releaseConfig") {
      // Release keystore lives outside the repo. Passwords come only from the
      // environment (never committed): RELEASE_STORE_PASSWORD, RELEASE_KEY_ALIAS,
      // RELEASE_KEY_PASSWORD. Keystore path defaults to the local release key,
      // overridable via RELEASE_KEYSTORE_FILE.
      val releaseKeystore = System.getenv("RELEASE_KEYSTORE_FILE")
        ?: "/storage/emulated/0/opencode/keystore/release-key.jks"
      storeFile = file(releaseKeystore)
      storePassword = System.getenv("RELEASE_STORE_PASSWORD")
      keyAlias = System.getenv("RELEASE_KEY_ALIAS")
      keyPassword = System.getenv("RELEASE_KEY_PASSWORD")
    }
  }

  buildTypes {
    debug {
      signingConfig = signingConfigs.getByName("debugConfig")
    }
    release {
      signingConfig = signingConfigs.getByName("releaseConfig")
      // Kept off for the first signed release: R8 full-mode needs-keeps tuning
      // against the Kyant RuntimeShader/reflection paths; enable only with testing.
      isMinifyEnabled = false
      isShrinkResources = false
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures {
    compose = true
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  testOptions {
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.19.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")
  implementation("androidx.activity:activity-compose:1.13.0")

  implementation(platform("androidx.compose:compose-bom:2026.06.01"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("io.github.kyant0:backdrop:2.0.0")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3:1.5.0-alpha25")
  implementation("androidx.compose.material:material-icons-extended")

  implementation("androidx.navigation:navigation-compose:2.9.8")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")

  implementation("androidx.datastore:datastore-preferences:1.2.1")

  testImplementation("junit:junit:4.13.2")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
}

tasks.register<Copy>("copyDebugApk") {
    from(file("${layout.buildDirectory.get().asFile}/outputs/apk/debug/app-debug.apk"))
    into(file("${project.rootDir}/debug"))
}

afterEvaluate {
    tasks.findByName("assembleDebug")?.finalizedBy("copyDebugApk")
}