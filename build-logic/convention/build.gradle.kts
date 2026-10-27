plugins {
    `kotlin-dsl`
}

group = "com.teikk.learningjc.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.findLibrary("android-gradlePlugin").get())
    implementation(libs.findLibrary("kotlin-gradlePlugin").get())
    implementation(libs.findLibrary("compose-compiler-gradlePlugin").get())
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "learningjc.android.application"
            implementationClass = "com.teikk.learningjc.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "learningjc.android.application.compose"
            implementationClass = "com.teikk.learningjc.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "learningjc.android.library"
            implementationClass = "com.teikk.learningjc.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "learningjc.android.library.compose"
            implementationClass = "com.teikk.learningjc.AndroidLibraryComposeConventionPlugin"
        }
        register("jvmLibrary") {
            id = "learningjc.jvm.library"
            implementationClass = "com.teikk.learningjc.JvmLibraryConventionPlugin"
        }
    }
}
