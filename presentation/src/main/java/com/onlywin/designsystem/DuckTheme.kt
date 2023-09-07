package com.onlywin.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.onlywin.designsystem.fondation.color.DuckColor
import com.onlywin.designsystem.fondation.color.DuckDarkColor


private val duckDarkColorPalette = darkColorScheme(
    primary = DuckColor.Primary300,
    onPrimary = DuckColor.Primary400,
    secondary = DuckDarkColor.Primary100,
    onSecondary = DuckDarkColor.Primary200,
    background = DuckDarkColor.Gray100,
    onBackground = DuckDarkColor.Gray700,
    surface = DuckDarkColor.Gray300,
    onSurface = DuckDarkColor.Gray400,
    surfaceTint = DuckDarkColor.Gray500,
    surfaceVariant = DuckDarkColor.Gray600,
    inverseSurface = DuckDarkColor.Gray200,
    error = DuckColor.Red,
    scrim = DuckColor.Green,
)

private val duckLightColorPalette = lightColorScheme(
    primary = DuckColor.Primary300,
    onPrimary = DuckColor.Primary400,
    secondary = DuckColor.Primary100,
    onSecondary = DuckColor.Primary200,
    background = DuckColor.Gray100,
    onBackground = DuckColor.Gray700,
    surface = DuckColor.Gray300,
    onSurface = DuckColor.Gray400,
    surfaceTint = DuckColor.Gray500,
    surfaceVariant = DuckColor.Gray600,
    inverseSurface = DuckColor.Gray200,
    error = DuckColor.Red,
    scrim = DuckColor.Green,
)

@Composable
fun DuckTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val rememberedColors =
        remember { if (darkTheme) duckDarkColorPalette else duckLightColorPalette }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
    ) {
        MaterialTheme(
            colorScheme = DuckTheme.colors,
            content = content,
        )
    }
}

@Stable
object DuckTheme {
    val colors: ColorScheme
        @Composable get() = LocalColors.current
}

internal val LocalColors = staticCompositionLocalOf { lightColorScheme() }