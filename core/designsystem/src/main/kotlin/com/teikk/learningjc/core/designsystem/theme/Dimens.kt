package com.teikk.learningjc.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Design system dimension constants (Padding, Height, Width, Icon sizes, Font sizes, Corner radii, Elevation).
 */
object Dimens {
    // Spacing & Padding
    val paddingNone = 0.dp
    val padding2 = 2.dp
    val padding4 = 4.dp
    val padding8 = 8.dp
    val padding12 = 12.dp
    val padding16 = 16.dp
    val padding20 = 20.dp
    val padding24 = 24.dp
    val padding32 = 32.dp
    val padding40 = 40.dp
    val padding48 = 48.dp
    val padding56 = 56.dp
    val padding64 = 64.dp

    // Heights
    val heightNone = 0.dp
    val heightButtonSmall = 36.dp
    val heightButtonDefault = 48.dp
    val heightButtonLarge = 56.dp
    val heightTopAppBar = 56.dp
    val heightBottomNav = 64.dp
    val heightBanner = 180.dp
    val heightIntroImage = 280.dp
    val heightCardMin = 72.dp
    val heightDivider = 1.dp

    // Widths
    val widthDivider = 1.dp
    val widthButtonMin = 120.dp

    // Icon Sizes
    val iconExtraSmall = 12.dp
    val iconSmall = 16.dp
    val iconMedium = 24.dp
    val iconLarge = 32.dp
    val iconExtraLarge = 48.dp

    // Corner Radii
    val cornerNone = 0.dp
    val cornerSmall = 4.dp
    val cornerMedium = 8.dp
    val cornerLarge = 16.dp
    val cornerExtraLarge = 24.dp
    val cornerFull = 1000.dp

    // Elevation
    val elevationNone = 0.dp
    val elevationLow = 2.dp
    val elevationMedium = 4.dp
    val elevationHigh = 8.dp

    // Font Sizes
    val fontSizeTiny = 10.sp
    val fontSizeSmall = 12.sp
    val fontSizeBodySmall = 14.sp
    val fontSizeBody = 16.sp
    val fontSizeTitleSmall = 18.sp
    val fontSizeTitle = 20.sp
    val fontSizeHeadline = 24.sp
    val fontSizeDisplaySmall = 28.sp
    val fontSizeDisplay = 32.sp
    val fontSizeDisplayLarge = 40.sp

    // Grouped namespaces for structured access
    object Spacing {
        val extraSmall = padding4
        val small = padding8
        val default = padding16
        val medium = padding16
        val large = padding24
        val extraLarge = padding32
        val huge = padding48
    }

    object Height {
        val buttonSmall = heightButtonSmall
        val buttonDefault = heightButtonDefault
        val buttonLarge = heightButtonLarge
        val topAppBar = heightTopAppBar
        val bottomNav = heightBottomNav
        val banner = heightBanner
        val introImage = heightIntroImage
        val divider = heightDivider
    }

    object Icon {
        val small = iconSmall
        val medium = iconMedium
        val large = iconLarge
        val extraLarge = iconExtraLarge
    }

    object Corner {
        val small = cornerSmall
        val medium = cornerMedium
        val large = cornerLarge
        val extraLarge = cornerExtraLarge
        val full = cornerFull
    }

    object FontSize {
        val caption = fontSizeSmall
        val bodySmall = fontSizeBodySmall
        val body = fontSizeBody
        val titleSmall = fontSizeTitleSmall
        val title = fontSizeTitle
        val headline = fontSizeHeadline
        val display = fontSizeDisplay
    }
}

val LocalDimens = staticCompositionLocalOf { Dimens }

val MaterialTheme.dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current
