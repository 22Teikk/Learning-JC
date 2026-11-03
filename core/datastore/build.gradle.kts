plugins {
    alias(libs.plugins.learningjc.android.library)
    alias(libs.plugins.learningjc.hilt)
}

android {
    namespace = "com.teikk.learningjc.core.datastore"
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.androidx.dataStore)
    implementation(libs.androidx.dataStore.preferences)
}
