package com.onlywin.designsystem.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.R
import com.onlywin.designsystem.clickable.duckClickable
import com.onlywin.designsystem.fondation.color.ButtonColor
import com.onlywin.designsystem.fondation.color.DuckButtonColor
import com.onlywin.designsystem.fondation.typography.Body1
import com.onlywin.designsystem.isKeyboardShowed

enum class ButtonType {
    LARGE,
    MEDIUM,
}

@Composable
private fun DuckBasicButton(
    modifier: Modifier,
    text: String,
    shapeSize: Dp,
    buttonColor: ButtonColor,
    enabled: Boolean,
    rippleEnabled: Boolean,
    isKeyboardShowed: Boolean,
    type: ButtonType,
    isKeyboardMode: Boolean,
    onClick: () -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    val isPressed by interactionSource.collectIsPressedAsState()

    val padding by animateDpAsState(
        targetValue = if (isKeyboardShowed) 0.dp
        else 20.dp,
        label = stringResource(id = R.string.animation_label_button_padding),
    )

    val shape by animateDpAsState(
        targetValue = if (isKeyboardShowed && isKeyboardMode) 0.dp
        else shapeSize,
        label = stringResource(id = R.string.animation_label_button_shape),
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) buttonColor.pressedColor
        else buttonColor.backgroundColor,
        label = stringResource(id = R.string.animation_label_button_background),
    )

    Box(
        modifier = modifier
            .padding(
                horizontal = if (type == ButtonType.LARGE && isKeyboardMode) padding
                else 0.dp,
            )
            .clip(shape = RoundedCornerShape(shape))
            .duckClickable(
                onClick = onClick,
                enabled = enabled,
                rippleEnabled = rippleEnabled,
                interactionSource = interactionSource,
            )
            .background(backgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        Body1(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = text,
            color = buttonColor.textColor,
        )
    }
}

@Composable
fun DuckLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: ButtonColor = DuckButtonColor.DefaultColor,
    enabled: Boolean = true,
    rippleEnabled: Boolean = true,
    isKeyboardMode: Boolean = false,
    onClick: () -> Unit,
) {
    DuckBasicButton(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        text = text,
        shapeSize = 12.dp,
        buttonColor = if (enabled) buttonColor else DuckButtonColor.DisabledColor,
        enabled = enabled,
        rippleEnabled = rippleEnabled,
        isKeyboardShowed = isKeyboardShowed.value,
        type = ButtonType.LARGE,
        isKeyboardMode = isKeyboardMode,
        onClick = onClick,
    )
}

@Composable
fun DuckSmallButton(
    text: String,
    buttonColor: ButtonColor = DuckButtonColor.DefaultColor,
    enabled: Boolean = true,
    rippleEnabled: Boolean = true,
    isKeyboardMode: Boolean = false,
    onClick: () -> Unit,
) {
    DuckBasicButton(
        modifier = Modifier
            .wrapContentWidth()
            .height(32.dp),
        text = text,
        shapeSize = 8.dp,
        buttonColor = if (enabled) buttonColor else DuckButtonColor.DisabledColor,
        enabled = enabled,
        rippleEnabled = rippleEnabled,
        isKeyboardShowed = isKeyboardShowed.value,
        type = ButtonType.MEDIUM,
        isKeyboardMode = isKeyboardMode,
        onClick = onClick,
    )
}
