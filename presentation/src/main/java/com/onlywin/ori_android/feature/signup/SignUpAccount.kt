package com.onlywin.ori_android.feature.signup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.onlywin.designsystem.button.DuckSmallButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.fondation.color.DuckButtonColor
import com.onlywin.designsystem.header.DuckAuthHeader
import com.onlywin.designsystem.textfield.DuckTextField
import com.onlywin.ori_android.R

private val pageTitles = listOf(
    R.string.sign_up_account_please_enter_email,
    R.string.sign_up_account_please_enter_email,
    R.string.sign_up_account_please_enter_password,
)

@Composable
internal fun SignUpAccount(
    moveToOnboarding: () -> Unit,
    moveToSignUpUser: () -> Unit,
) {

    var email by remember { mutableStateOf("") }
    val onEmailChange = { value: String ->
        email = value
    }

    val resendVerifyCode: () -> Unit = {
    }

    var verifyCode by remember { mutableStateOf("") }
    val onVerifyCode = { value: String ->
        verifyCode = value
    }

    var password by remember { mutableStateOf("") }
    val onPasswordChange = { value: String ->
        password = value
    }

    var currentStep by rememberSaveable { mutableIntStateOf(0) }

    val moveToNextStep = { 
        when(currentStep){
            in 0..1 -> currentStep += 1
            else -> moveToSignUpUser()
        }
    }

    DuckLayout(horizontal = 20.dp) {
        Spacer(modifier = Modifier.height(12.dp))
        DuckAuthHeader(
            pageTitle = stringResource(id = pageTitles[currentStep]),
            leadingOnClick = moveToOnboarding,
        )
        SignUpAccountInput(
            email = email,
            onEmailChange = onEmailChange,
            resendVerifyCode = resendVerifyCode,
            verifyCode = verifyCode,
            onVerifyCodeChange = onVerifyCode,
            password = password,
            onPasswordChange = onPasswordChange,
            currentStep = currentStep,
        )
        Spacer(modifier = Modifier.weight(1f))
        DuckLargeButton(
            text = stringResource(id = R.string.next),
            onClick = moveToNextStep,
        )
    }
}

@Composable
private fun SignUpAccountInput(
    email: String,
    onEmailChange: (String) -> Unit,
    resendVerifyCode: () -> Unit,
    verifyCode: String,
    onVerifyCodeChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    currentStep: Int,
) {
    Column {
        AnimatedVisibility(currentStep >= 2) {
            DuckTextField(
                value = password,
                onValueChange = onPasswordChange,
                title = stringResource(id = R.string.password),
                isPassword = true,
            )
        }
        AnimatedVisibility(currentStep >= 1) {
            DuckTextField(
                value = verifyCode,
                onValueChange = onVerifyCodeChange,
                title = stringResource(id = R.string.verify_code),
            )
        }
        DuckTextField(
            value = email,
            onValueChange = onEmailChange,
            title = stringResource(id = R.string.email),
            description = stringResource(id = R.string.email_sent),
        ) {
            DuckSmallButton(
                text = stringResource(id = R.string.resend),
                onClick = resendVerifyCode,
                buttonColor = DuckButtonColor.SubColor,
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
        SignUpAccount(moveToOnboarding = { /*TODO*/ }) {
            
        }
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
        SignUpAccount(moveToOnboarding = { /*TODO*/ }) {
            
        }
    }
}
