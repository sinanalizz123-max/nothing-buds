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
      val keystoreFile = file("${rootDir}/debug.keystore")
      if (!keystoreFile.exists()) {
        val base64File = file("${rootDir}/debug.keystore.base64")
        if (base64File.exists()) {
          val decoded = Base64.getDecoder().decode(base64File.readText().trim())
          keystoreFile.writeBytes(decoded)
        }
      }
      storeFile = keystoreFile
      storePassword = "android"
      keyAlias = "androiddebugkey"
      keyPassword = "android"
    }
  }

  buildTypes {
    debug {
      signingConfig = signingConfigs.getByName("debugConfig")
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
}

dependencies {
  implementation("androidx.core:core-ktx:1.19.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")
  implementation("androidx.activity:activity-compose:1.13.0")

  implementation(platform("androidx.compose:compose-bom:2026.06.01"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
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