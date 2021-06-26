plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "app.spood.android"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        getByName("release") { isMinifyEnabled = false }
    }

    kotlinOptions { jvmTarget = "11" }

    buildFeatures { compose = true }

    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
}

dependencies {
    implementation(project(":common"))

    implementation("com.google.android.material:material:1.3.0")

    implementation("androidx.activity:activity-compose:1.3.0-beta02")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha03")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")


    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
}