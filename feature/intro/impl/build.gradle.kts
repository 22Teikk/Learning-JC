plugins {
    alias(libs.plugins.learningjc.android.feature.impl)
}

android {
    namespace = "com.teikk.learningjc.feature.intro.impl"
}

dependencies {
    implementation(projects.feature.intro.api)
    implementation(projects.core.data)
}
