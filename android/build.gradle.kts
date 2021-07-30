plugins {
    id("com.android.application")
    id("kotlin-android")
}

val composeVersion = findProperty("version.compose") as String

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "app.spood.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        getByName("release") { isMinifyEnabled = false }
    }

    kotlinOptions { jvmTarget = "11" }

    buildFeatures { compose = true }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {
    implementation(project(":common"))

    implementation("com.google.android.material:material:${findProperty("version.material")}")
    implementation("io.insert-koin:koin-androidx-compose:${findProperty("version.koin")}")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.activity:activity-compose:1.3.0-rc02")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha05")
    implementation("com.google.accompanist:accompanist-insets:0.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
}