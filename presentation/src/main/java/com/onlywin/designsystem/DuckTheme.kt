package com.onlywin.designsystem

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.onlywin.designsystem.fondation.color.DuckColor
import com.onlywin.designsystem.fondation.color.DuckDarkColor


private val DuckDarkColorTheme = darkColorScheme(
    primary = DuckDarkColor.Primary100,
    secondary = DuckColor.Primary300,
    tertiary = DuckDarkColor.Primary200,
    error = DuckColor.Red,
    background = DuckDarkColor.Gray100,
    onBackground = DuckDarkColor.Gray200,
    surface = DuckDarkColor.Gray300,
    onSurface = DuckDarkColor.Gray400,
    onPrimary = DuckDarkColor.Primary200,
    onSecondary = DuckColor.Primary400,
    scrim = DuckColor.Green,
    surfaceTint = DuckDarkColor.Gray500,
    surfaceVariant = DuckDarkColor.Gray600,
    inverseSurface = DuckDarkColor.Gray700,
)

private val DuckLightColorTheme = lightColorScheme(
    primary = DuckColor.Primary100,
    secondary = DuckColor.Primary300,
    tertiary = DuckColor.Primary200,
    error = DuckColor.Red,
    background = DuckColor.Gray100,
    onBackground = DuckColor.Gray200,
    surface = DuckColor.Gray300,
    onSurface = DuckColor.Gray400,
    onPrimary = DuckColor.Primary200,
    onSecondary = DuckColor.Primary400,
    scrim = DuckColor.Green,
    surfaceTint = DuckColor.Gray500,
    surfaceVariant = DuckColor.Gray600,
    inverseSurface = DuckColor.Gray700,
)

@Composable
fun DuckTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DuckDarkColorTheme
        else -> DuckLightColorTheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}