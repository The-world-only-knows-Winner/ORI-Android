package com.onlywin.designsystem.textfield

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.R
import com.onlywin.designsystem.clickable.duckClickable
import com.onlywin.designsystem.fondation.color.DuckColor
import com.onlywin.designsystem.fondation.typography.Body3
import com.onlywin.designsystem.fondation.typography.Body4
import com.onlywin.designsystem.fondation.typography.DuckTypography

@Composable
fun DuckTextField(
    title: String? = null,
    titleColor: Color = DuckTheme.colors.onBackground,
    description: String? = null,
    descriptionColor: Color = DuckTheme.colors.onBackground,
    value: String,
    @DrawableRes drawableRes: Int? = null,
    isError: Boolean? = null,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit,
    onIconClicked: (() -> Unit)? = null,
    content: (@Composable () -> Unit)? = null,
) {

    var isVisible by remember { mutableStateOf(false) }

    val changePasswordVisible = { isVisible = !isVisible }

    Box {
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            FieldTitle(
                title = title,
                titleColor = titleColor,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight(),
                ) {
                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp),
                        value = value,
                        onValueChange = onValueChange,
                        textStyle = DuckTypography.body1,
                        maxLines = 1,
                        singleLine = true,
                        visualTransformation = if (isVisible || !isPassword) VisualTransformation.None
                        else PasswordVisualTransformation(),
                    ) { innerTextField ->
                        innerTextField()
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp),
                        color = DuckColor.Gray400,
                    )
                }
                if (drawableRes != null || isPassword) {
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        modifier = Modifier.duckClickable(
                            onClick = if (isPassword) changePasswordVisible
                            else onIconClicked!!,
                        ),
                        painter = painterResource(
                            id = if (isPassword) {
                                if (isVisible) R.drawable.ic_visible_on
                                else R.drawable.ic_visible_off
                            } else drawableRes!!,
                        ),
                        contentDescription =
                        stringResource(id = R.string.content_description_icon_text_field),
                    )
                }
                if (content != null) {
                    Spacer(modifier = Modifier.width(12.dp))
                    content()
                }
            }
            FieldDescription(
                description = description,
                descriptionColor = descriptionColor,
                isError = isError,
            )
        }
    }
}

@Composable
private fun FieldTitle(
    title: String?,
    titleColor: Color,
) {
    if (title != null) {
        Body4(
            text = title,
            color = titleColor,
        )
    }
}

@Composable
private fun FieldDescription(
    description: String?,
    descriptionColor: Color,
    isError: Boolean?,
) {
    Column {
        AnimatedVisibility(isError != null) {
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(
                        id = if (isError == true) R.drawable.ic_failure
                        else R.drawable.ic_success,
                    ),
                    contentDescription = stringResource(R.string.content_description_icon_text_field_description),
                )
                Spacer(modifier = Modifier.width(4.dp))
                Body3(
                    text = description!!,
                    color = descriptionColor,
                )
            }
        }
    }
}
