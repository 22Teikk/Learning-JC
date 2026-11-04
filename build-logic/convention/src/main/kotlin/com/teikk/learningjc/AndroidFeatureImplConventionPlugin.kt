package com.teikk.learningjc

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureImplConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("learningjc.android.library")
            pluginManager.apply("learningjc.android.library.compose")
            pluginManager.apply("learningjc.hilt")

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:designsystem"))

                add("implementation", libs.findLibrary("androidx-lifecycle-runtime-compose").get())
                add("implementation", libs.findLibrary("androidx-navigation3-runtime").get())
                add("implementation", libs.findLibrary("androidx-navigation3-ui").get())
            }
        }
    }
}

typealias AndroidFeatureConventionPlugin = AndroidFeatureImplConventionPlugin
