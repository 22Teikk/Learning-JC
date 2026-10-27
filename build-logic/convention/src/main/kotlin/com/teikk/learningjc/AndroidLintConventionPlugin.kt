package com.teikk.learningjc

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.Lint
import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            when {
                pluginManager.hasPlugin("com.android.application") ->
                    configure<ApplicationExtension> { lint(Lint::configure) }

                pluginManager.hasPlugin("com.android.library") ->
                    configure<LibraryExtension> { lint(Lint::configure) }

                else -> {
                    pluginManager.apply("com.android.lint")
                    configure<Lint>(Lint::configure)
                }
            }

            // Spotless configuration with ktlint and .editorconfig
            pluginManager.apply("com.diffplug.spotless")
            extensions.configure<SpotlessExtension> {
                kotlin {
                    target("**/*.kt")
                    targetExclude("**/build/**/*.kt")
                    val ktlintVersion = libs.findVersion("ktlint").map { it.requiredVersion }.orElse("1.5.0")
                    ktlint(ktlintVersion).setEditorConfigPath("${project.rootDir}/.editorconfig")
                    endWithNewline()
                }
                kotlinGradle {
                    target("**/*.kts")
                    targetExclude("**/build/**/*.kts")
                    val ktlintVersion = libs.findVersion("ktlint").map { it.requiredVersion }.orElse("1.5.0")
                    ktlint(ktlintVersion).setEditorConfigPath("${project.rootDir}/.editorconfig")
                    endWithNewline()
                }
                format("misc") {
                    target("*.gradle", "*.md", ".gitignore")
                    trimTrailingWhitespace()
                    endWithNewline()
                }
            }
        }
    }
}

private fun Lint.configure() {
    xmlReport = true
    checkDependencies = true
}
