import java.util.Base64

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "com.nothingbuds"
  compileSdk { version = release(36) { minorApiLevel = 1 } }

  defaultConfig {
    applicationId = "com.nothingbuds"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.androidx.lifecycle.viewmodel.compose)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.core.ktx)
  implementation(libs.kotlinx.coroutines.android)

  testImplementation(libs.junit)
  debugImplementation(libs.androidx.compose.ui.tooling)
  debugImplementation(libs.androidx.compose.ui.tooling.preview)
}

tasks.register<Copy>("copyDebugApk") {
    from(file("${layout.buildDirectory.get().asFile}/outputs/apk/debug/app-debug.apk"))
    into(file("${project.rootDir}/debug"))
}

afterEvaluate {
    tasks.findByName("assembleDebug")?.finalizedBy("copyDebugApk")
}