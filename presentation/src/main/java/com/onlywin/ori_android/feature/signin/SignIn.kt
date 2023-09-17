package com.onlywin.ori_android.feature.signin

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.header.DuckHeader
import com.onlywin.designsystem.textfield.DuckTextField
import com.onlywin.ori_android.R

@Composable
internal fun SignIn(
    moveToOnboarding: () -> Unit,
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    val onEmailChange = { value: String ->
        email = value
    }

    val onPasswordChange = { value: String ->
        password = value
    }

    val signIn = {}

    DuckLayout(horizontal = 20.dp) {
        Spacer(modifier = Modifier.height(12.dp))
        DuckHeader(
            leadingIcon = com.onlywin.designsystem.R.drawable.ic_arrow_back,
            pageTitle = stringResource(id = R.string.sign_in_welcome),
            leadingOnClick = moveToOnboarding,
        )
        Spacer(modifier = Modifier.height(40.dp))
        SignInInput(
            email = email,
            onEmailChange = onEmailChange,
            password = password,
            onPasswordChange = onPasswordChange,
            emailError = emailError,
            passwordError = passwordError,
        )
        Spacer(modifier = Modifier.weight(1f))
        DuckLargeButton(
            text = stringResource(id = R.string.sign_in_start),
            onClick = signIn,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun SignInInput(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    emailError: Boolean,
    passwordError: Boolean,
) {
    DuckTextField(
        value = email,
        onValueChange = onEmailChange,
        title = stringResource(id = R.string.email),
        isError = emailError,
        description = stringResource(id = R.string.please_enter_content),
    )
    DuckTextField(
        value = password,
        onValueChange = onPasswordChange,
        title = stringResource(id = R.string.password),
        isPassword = true,
        isError = passwordError,
        description = stringResource(id = R.string.password_mismatch),
    )
}

@Preview(
    name = "SignIn Light Preview",
    showBackground = true,
)
@Composable
private fun SignInLightPreview() {
    SignIn {}
}

@Preview(
    name = "SignIn Dark Preview",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun SignInDarkPreview() {
    SignIn {}
}