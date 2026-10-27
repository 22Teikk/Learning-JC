package com.teikk.learningjc

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")

            dependencies {
                add("ksp", libs.findLibrary("hilt-compiler").get())
                libs.findLibrary("kotlin-metadata").ifPresent { add("ksp", it) }
                libs.findLibrary("kotlin.metadata").ifPresent { add("ksp", it) }
            }

            // Add support for JVM Modules (based on org.jetbrains.kotlin.jvm)
            pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
                dependencies {
                    add("implementation", libs.findLibrary("hilt-core").get())
                }
            }

            // Add support for Android modules (based on com.android.base)
            pluginManager.withPlugin("com.android.base") {
                pluginManager.apply("dagger.hilt.android.plugin")
                dependencies {
                    add("implementation", libs.findLibrary("hilt-android").get())
                }
            }
        }
    }
}
