plugins {
    alias(libs.plugins.learningjc.android.library)
    alias(libs.plugins.learningjc.hilt)
    alias(libs.plugins.learningjc.android.room)
}

android {
    namespace = "com.teikk.learningjc.core.database"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.common)
}
