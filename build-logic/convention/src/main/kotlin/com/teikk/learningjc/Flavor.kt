package com.teikk.learningjc

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.ProductFlavor

@Suppress("EnumEntryName")
enum class FlavorDimension {
    environment,
}

@Suppress("EnumEntryName")
enum class LearningJCFlavor(
    val dimension: FlavorDimension,
    val applicationIdSuffix: String? = null,
) {
    dev(FlavorDimension.environment, applicationIdSuffix = ".dev"),
    stg(FlavorDimension.environment, applicationIdSuffix = ".stg"),
    prd(FlavorDimension.environment),
}

fun configureFlavors(
    commonExtension: CommonExtension,
    flavorConfigurationBlock: ProductFlavor.(flavor: LearningJCFlavor) -> Unit = {},
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.environment.name

        when (this) {
            is ApplicationExtension -> {
                productFlavors {
                    LearningJCFlavor.entries.forEach { flavor ->
                        create(flavor.name) {
                            dimension = flavor.dimension.name
                            flavorConfigurationBlock(this, flavor)
                            if (flavor.applicationIdSuffix != null) {
                                applicationIdSuffix = flavor.applicationIdSuffix
                            }
                        }
                    }
                }
            }
            is LibraryExtension -> {
                productFlavors {
                    LearningJCFlavor.entries.forEach { flavor ->
                        create(flavor.name) {
                            dimension = flavor.dimension.name
                            flavorConfigurationBlock(this, flavor)
                        }
                    }
                }
            }
        }
    }
}
