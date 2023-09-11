package com.onlywin.designsystem.fondation.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.onlywin.designsystem.DuckTheme

data class ButtonColor(
    val backgroundColor: Color,
    val pressedColor: Color,
    val textColor: Color,
)

object DuckButtonColor {

    @Stable
    val DefaultColor: ButtonColor
        @Composable get() = ButtonColor(
            backgroundColor = DuckTheme.colors.primary,
            pressedColor = DuckTheme.colors.onPrimary,
            textColor = DuckTheme.colors.background,
        )

    @Stable
    val SubColor: ButtonColor
        @Composable get() = ButtonColor(
            backgroundColor = DuckTheme.colors.secondary,
            pressedColor = DuckTheme.colors.onSecondary,
            textColor = DuckTheme.colors.primary,
        )

    @Stable
    val DisabledColor: ButtonColor
        @Composable get() = ButtonColor(
            backgroundColor = DuckTheme.colors.onSurface,
            pressedColor = DuckTheme.colors.onSurface,
            textColor = DuckTheme.colors.background,
        )
}