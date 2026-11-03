plugins {
    alias(libs.plugins.learningjc.android.feature.api)
}

android {
    namespace = "com.teikk.learningjc.feature.intro.api"
}

dependencies {
    api(projects.core.navigation)
}
