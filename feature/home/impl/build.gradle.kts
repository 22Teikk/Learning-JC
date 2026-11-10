plugins {
    alias(libs.plugins.learningjc.android.feature.impl)
}

android {
    namespace = "com.teikk.learningjc.feature.home.impl"
}

dependencies {
    implementation(projects.feature.home.api)
    implementation(projects.core.data)

}
