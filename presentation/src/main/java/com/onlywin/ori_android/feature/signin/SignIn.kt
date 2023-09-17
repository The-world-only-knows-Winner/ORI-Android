package com.onlywin.ori_android.feature.signin

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.header.DuckHeader
import com.onlywin.designsystem.textfield.DuckTextField
import com.onlywin.ori_android.R

@Composable
internal fun SignIn() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val onEmailChange = { value: String ->
        email = value
    }

    val onPasswordChange = { value: String ->
        password = value
    }

    val signIn = {}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(DuckTheme.colors.background)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        DuckHeader(
            leadingIcon = com.onlywin.designsystem.R.drawable.ic_arrow_back,
            pageTitle = stringResource(id = R.string.sign_in_welcome),
        )
        Spacer(modifier = Modifier.height(40.dp))
        SignInInput(
            email = email,
            onEmailChange = onEmailChange,
            password = password,
            onPasswordChange = onPasswordChange,
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
) {
    DuckTextField(
        value = email,
        onValueChange = onEmailChange,
        title = stringResource(id = R.string.email),
    )
    Spacer(modifier = Modifier.height(32.dp))
    DuckTextField(
        value = password,
        onValueChange = onPasswordChange,
        title = stringResource(id = R.string.password),
        isPassword = true,
    )
}

@Preview(
    name = "SignIn Light Preview",
    showBackground = true,
)
@Composable
private fun SignInLightPreview() {
    SignIn()
}

@Preview(
    name = "SignIn Dark Preview",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun SignInDarkPreview() {
    SignIn()
}