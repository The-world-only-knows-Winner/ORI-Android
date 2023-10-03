package com.onlywin.ori_android.feature.signup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.fondation.typography.Heading1
import com.onlywin.ori_android.R

@Composable
internal fun SignUpComplete() {

    val name by remember { mutableStateOf("") }

    DuckLayout {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = com.onlywin.designsystem.R.drawable.ic_check_circle),
                    contentDescription = stringResource(id = R.string.content_description_image_complete),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Heading1(text = stringResource(id = R.string.sign_up_complete_welcome))
                Heading1(text = name)
            }
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                DuckLargeButton(
                    text = stringResource(id = R.string.complete),
                    onClick = {},
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(
    name = "Complete Light Preview",
    showBackground = true,
)
@Composable
private fun CompleteLightPreview() {
    DuckTheme {
        SignUpComplete()
    }
}

@Preview(
    name = "Complete Dark Preview",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun CompleteDarkPreview() {
    DuckTheme {
        SignUpComplete()
    }
}