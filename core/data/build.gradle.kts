plugins {
    alias(libs.plugins.learningjc.android.library)
    alias(libs.plugins.learningjc.hilt)
}

android {
    namespace = "com.teikk.learningjc.core.data"
}

dependencies {
    api(projects.core.common)
    api(projects.core.network)
    api(projects.core.database)
    api(projects.core.datastore)
}
