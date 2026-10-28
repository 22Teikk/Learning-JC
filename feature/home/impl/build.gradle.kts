plugins {
    alias(libs.plugins.learningjc.android.feature.impl)
}

android {
    namespace = "com.teikk.learningjc.feature.home.impl"
}

dependencies {
    implementation(project(":feature:home:api"))
}
