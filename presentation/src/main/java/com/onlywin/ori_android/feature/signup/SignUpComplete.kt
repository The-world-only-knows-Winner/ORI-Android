package com.onlywin.ori_android.feature.signup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun SignUpComplete() {
    DuckLayout(horizontal = 20.dp) {
        Column(
            modifier = Modifier.fillMaxSize(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = com.onlywin.designsystem.R.drawable.ic_check_circle),
                contentDescription = stringResource(id = R.string.content_description_image_complete),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Heading1(text = stringResource(id = R.string.sign_up_complete_welcome))
            Heading1(text = "박시원님!")
        }
        Spacer(modifier = Modifier.weight(1f))
        DuckLargeButton(
            text = stringResource(id = R.string.complete),
            onClick = {},
        )
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