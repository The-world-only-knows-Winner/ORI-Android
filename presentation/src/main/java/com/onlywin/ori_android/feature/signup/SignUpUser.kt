package com.onlywin.ori_android.feature.signup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.header.DuckAuthHeader
import com.onlywin.designsystem.textfield.DuckTextField
import com.onlywin.ori_android.R
import com.onlywin.ori_android.viewmodel.user.SignUpViewModel
import org.koin.androidx.compose.koinViewModel

private val pageTitles = listOf(
    R.string.sign_up_account_please_enter_name,
    R.string.sign_up_account_please_enter_birth,
)

@Composable
internal fun SignUpUser(
    moveToSignUpAccount: () -> Unit,
    moveToComplete: () -> Unit,
    signUpViewModel: SignUpViewModel,
) {
    val state by signUpViewModel.state.collectAsStateWithLifecycle()

    val currentStep = state.currentStep

    val buttonText = when (currentStep) {
        3 -> stringResource(id = R.string.next)
        else -> stringResource(id = R.string.complete)
    }

    LaunchedEffect(Unit) {
        signUpViewModel.sideEffect.collect {
            when (it) {
                is SignUpSideEffect.Success -> {
                    moveToComplete()
                }

                else -> {}
            }
        }
    }

    DuckLayout {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            DuckAuthHeader(
                pageTitle = stringResource(id = pageTitles[currentStep - 3]),
                leadingOnClick = moveToSignUpAccount,
            )
            SignUpUserInputs(
                birth = state.birthDay,
                onBirthChange = signUpViewModel::setBirth,
                name = state.name,
                onNameChange = signUpViewModel::setName,
                currentStep = currentStep,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.imePadding()) {
            DuckLargeButton(
                text = buttonText,
                onClick = signUpViewModel::onButtonClick,
                isKeyboardMode = true,
            )
        }
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
        AnimatedVisibility(currentStep >= 4) {
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
        SignUpUser(
            moveToSignUpAccount = { /*TODO*/ },
            moveToComplete = { /*TODO*/ },
            signUpViewModel = koinViewModel(),
        )
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
        SignUpUser(
            moveToSignUpAccount = { /*TODO*/ },
            moveToComplete = { /*TODO*/ },
            signUpViewModel = koinViewModel(),
        )
    }
}