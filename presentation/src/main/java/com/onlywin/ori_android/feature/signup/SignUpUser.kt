package com.onlywin.ori_android.feature.signup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.header.DuckAuthHeader
import com.onlywin.designsystem.textfield.DuckTextField
import com.onlywin.ori_android.R

private val pageTitles = listOf(
    R.string.sign_up_account_please_enter_name,
    R.string.sign_up_account_please_enter_birth,
)

@Composable
internal fun SignUpUser(
    moveToSignUpAccount: () -> Unit,
    moveToComplete: () -> Unit,
) {

    var birth by remember { mutableStateOf("") }
    val onBirthChange = { value: String ->
        birth = value
    }

    var name by remember { mutableStateOf("") }
    val onNameChange = { value: String ->
        name = value
    }

    var currentStep by rememberSaveable { mutableIntStateOf(0) }

    val moveToNextStep = {
        when (currentStep) {
            0 -> currentStep += 1
            else -> moveToComplete()
        }
    }

    val buttonText = when (currentStep) {
        0 -> stringResource(id = R.string.next)
        else -> stringResource(id = R.string.complete)
    }

    DuckLayout(horizontal = 20.dp) {
        DuckAuthHeader(
            pageTitle = stringResource(id = pageTitles[currentStep]),
            leadingOnClick = moveToSignUpAccount,
        )
        SignUpUserInputs(
            birth = birth,
            onBirthChange = onBirthChange,
            name = name,
            onNameChange = onNameChange,
            currentStep = currentStep,
        )
        Spacer(modifier = Modifier.weight(1f))
        DuckLargeButton(
            text = buttonText,
            onClick = moveToNextStep,
        )
    }
}

@Composable
private fun SignUpUserInputs(
    birth: String,
    onBirthChange: (String) -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    currentStep: Int,
) {
    Column {
        AnimatedVisibility(currentStep >= 1) {
            DuckTextField(
                value = birth,
                onValueChange = onBirthChange,
                title = stringResource(id = R.string.birth),
            )
        }
        DuckTextField(
            value = name,
            onValueChange = onNameChange,
            title = stringResource(id = R.string.name),
        )
    }
}

@Preview(
    name = "SignUpUser Light Preview",
    showBackground = true,
)
@Composable
private fun SignUpUserLightPreview() {
    DuckTheme {
        SignUpUser(moveToSignUpAccount = { /*TODO*/ }) {

        }
    }
}

@Preview(
    name = "SignUpUser Dark Preview",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun SignUpUserDarkPreview() {
    DuckTheme {
        SignUpUser(moveToSignUpAccount = { /*TODO*/ }) {

        }
    }
}