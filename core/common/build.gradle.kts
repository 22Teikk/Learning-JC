plugins {
    alias(libs.plugins.learningjc.android.library)
    alias(libs.plugins.learningjc.hilt)
}

android {
    namespace = "com.teikk.learningjc.core.common"
}

dependencies {
    api(libs.timber)
    implementation(libs.kotlinx.coroutines.core)
}
