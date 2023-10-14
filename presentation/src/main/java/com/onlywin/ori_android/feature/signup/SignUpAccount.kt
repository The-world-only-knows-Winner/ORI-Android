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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.button.DuckSmallButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.fondation.color.DuckButtonColor
import com.onlywin.designsystem.header.DuckAuthHeader
import com.onlywin.designsystem.textfield.DuckTextField
import com.onlywin.ori_android.R
import com.onlywin.ori_android.viewmodel.user.SignUpViewModel

private val pageTitles = listOf(
    R.string.sign_up_account_please_enter_email,
    R.string.sign_up_account_please_enter_email,
    R.string.sign_up_account_please_enter_password,
)

@Composable
internal fun SignUpAccount(
    moveToOnboarding: () -> Unit,
    moveToSignUpUser: () -> Unit,
    signUpViewModel: SignUpViewModel,
) {

    val state by signUpViewModel.state.collectAsStateWithLifecycle()

    val currentStep = state.currentStep

    LaunchedEffect(Unit) {
        signUpViewModel.sideEffect.collect {
            if (it is SignUpSideEffect.MoveToSignUpUser) moveToSignUpUser()
        }
    }

    DuckLayout {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            DuckAuthHeader(
                pageTitle = stringResource(id = pageTitles[currentStep]),
                leadingOnClick = moveToOnboarding,
            )
            SignUpAccountInput(
                email = { state.email },
                emailError = { state.emailError },
                onEmailChange = signUpViewModel::setEmail,
                sendAuthCode = signUpViewModel::sendAuthCode,
                code = { state.code },
                codeError = { state.codeError },
                onCodeChange = signUpViewModel::setCode,
                password = { state.password },
                passwordError = { state.passwordError },
                onPasswordChange = signUpViewModel::setPassword,
                currentStep = { state.currentStep },
                codeButtonEnabled = { state.codeButtonEnabled },
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.imePadding()) {
            DuckLargeButton(
                text = stringResource(id = R.string.next),
                onClick = signUpViewModel::onButtonClick,
                isKeyboardMode = true,
                enabled = state.buttonEnabled,
            )
        }
    }
}

@Composable
private fun SignUpAccountInput(
    email: () -> String,
    emailError: () -> Boolean?,
    onEmailChange: (String) -> Unit,
    sendAuthCode: () -> Unit,
    code: () -> String,
    codeError: () -> Boolean?,
    onCodeChange: (String) -> Unit,
    password: () -> String,
    passwordError: () -> Boolean?,
    onPasswordChange: (String) -> Unit,
    currentStep: () -> Int,
    codeButtonEnabled: () -> Boolean,
) {
    Column {
        AnimatedVisibility(currentStep() >= 2) {
            DuckTextField(
                value = password(),
                onValueChange = onPasswordChange,
                title = stringResource(id = R.string.password),
                isPassword = true,
                description = stringResource(id = R.string.password_format_mismatch),
                isError = passwordError(),
            )
        }
        AnimatedVisibility(currentStep() >= 1) {
            DuckTextField(
                value = code(),
                onValueChange = onCodeChange,
                title = stringResource(id = R.string.verify_code),
                isError = codeError(),
                description = stringResource(id = R.string.code_mismatch),
            )
        }
        DuckTextField(
            value = email(),
            onValueChange = onEmailChange,
            title = stringResource(id = R.string.email),
            description = stringResource(id = R.string.email_sent),
            isError = emailError(),
        ) {
            DuckSmallButton(
                text = stringResource(id = R.string.resend),
                onClick = sendAuthCode,
                buttonColor = DuckButtonColor.SubColor,
                enabled = codeButtonEnabled(),
            )
        }
    }
}

@Preview(
    name = "SignAccountUp Light Preview",
    showBackground = true,
)
@Composable
private fun SignUpAccountLightPreview() {
    DuckTheme {
        SignUpAccount(
            moveToOnboarding = { /*TODO*/ },
            moveToSignUpUser = { /*TODO*/ },
            signUpViewModel = viewModel(),
        )
    }
}

@Preview(
    name = "SignAccountUp Dark Preview",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun SignUpAccountDarkPreview() {
    DuckTheme {
        SignUpAccount(
            moveToOnboarding = { /*TODO*/ },
            moveToSignUpUser = { /*TODO*/ },
            signUpViewModel = viewModel(),
        )
    }
}
