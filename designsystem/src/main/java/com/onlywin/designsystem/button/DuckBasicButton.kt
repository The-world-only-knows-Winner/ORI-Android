package com.onlywin.designsystem.button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.clickable.duckClickable
import com.onlywin.designsystem.fondation.color.ButtonColor
import com.onlywin.designsystem.fondation.color.DuckButtonColor
import com.onlywin.designsystem.fondation.typography.Body1

@Composable
private fun DuckBasicButton(
    modifier: Modifier,
    text: String,
    shape: RoundedCornerShape,
    buttonColor: ButtonColor,
    enabled: Boolean,
    rippleEnabled: Boolean,
    onClick: () -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = modifier
            .clip(shape)
            .background(color = if (isPressed) buttonColor.pressedColor else buttonColor.backgroundColor)
            .duckClickable(
                onClick = onClick,
                enabled = enabled,
                rippleEnabled = rippleEnabled,
                interactionSource = interactionSource,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Body1(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = text,
            color = buttonColor.textColor,
            onClick = onClick,
        )
    }
}

@Composable
fun DuckLargeButton(
    text: String,
    buttonColor: ButtonColor = DuckButtonColor.DefaultColor,
    enabled: Boolean = true,
    rippleEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    DuckBasicButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        text = text,
        shape = RoundedCornerShape(12.dp),
        buttonColor = if (enabled) buttonColor else DuckButtonColor.DisabledColor,
        enabled = enabled,
        rippleEnabled = rippleEnabled,
        onClick = onClick,
    )
}

@Composable
fun DuckSmallButton(
    text: String,
    buttonColor: ButtonColor = DuckButtonColor.DefaultColor,
    enabled: Boolean = true,
    rippleEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    DuckBasicButton(
        modifier = Modifier
            .wrapContentWidth()
            .height(32.dp),
        text = text,
        shape = RoundedCornerShape(8.dp),
        buttonColor = if (enabled) buttonColor else DuckButtonColor.DisabledColor,
        enabled = enabled,
        rippleEnabled = rippleEnabled,
        onClick = onClick,
    )
}