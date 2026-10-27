plugins {
    alias(libs.plugins.learningjc.android.application)
    alias(libs.plugins.learningjc.android.application.compose)
    alias(libs.plugins.learningjc.hilt)
    alias(libs.plugins.learningjc.android.room)
}

android {
    namespace = "com.teikk.learningjc"

    defaultConfig {
        applicationId = "com.teikk.learningjc"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
}
