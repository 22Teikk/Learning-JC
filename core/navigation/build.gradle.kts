plugins {
    alias(libs.plugins.learningjc.android.library)
    alias(libs.plugins.learningjc.android.library.compose)
}

android {
    namespace = "com.teikk.learningjc.core.navigation"
}

dependencies {
    api(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.savedstate.compose)
    implementation(libs.androidx.lifecycle.viewModel.navigation3)
}
