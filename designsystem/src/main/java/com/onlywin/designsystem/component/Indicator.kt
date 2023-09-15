package com.onlywin.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.R

@Composable
fun Indicator(isEnabled: Boolean) {

    val width by animateDpAsState(
        targetValue = if (isEnabled) 24.dp
        else 8.dp,
        label = stringResource(id = R.string.animation_label_indicator_width),
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isEnabled) DuckTheme.colors.primary
        else DuckTheme.colors.surface,
        label = stringResource(id = R.string.animation_label_indicator_background_color)
    )

    Box(
        modifier = Modifier
            .size(
                width = width,
                height = 8.dp,
            )
            .background(
                color = backgroundColor,
                shape = CircleShape,
            )
            .clip(CircleShape)
    )
}