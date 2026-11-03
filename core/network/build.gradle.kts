plugins {
    alias(libs.plugins.learningjc.android.library)
    alias(libs.plugins.learningjc.hilt)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.teikk.learningjc.core.network"
}

dependencies {
    implementation(projects.core.common)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.database)
}
