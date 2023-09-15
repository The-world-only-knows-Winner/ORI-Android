package com.onlywin.ori_android.feature

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.fondation.typography.Heading3
import com.onlywin.ori_android.R

@Composable
internal fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DuckTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier.size(
                width = 92.dp,
                height = 46.dp,
            ),
            painter = painterResource(id = R.drawable.ic_splash_duck),
            contentDescription = stringResource(R.string.content_description_image_splash),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Heading3(
            text = stringResource(id = R.string.splash_image_description),
            color = DuckTheme.colors.surfaceTint,
        )
    }
}

@Preview(
    name = "Light Theme Splash",
    showBackground = true,
)
@Composable
private fun LightThemeSplashPreview() {
    Splash()
}

@Preview(
    name = "Dark Theme Splash",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun DarkThemeSplashPreview() {
    Splash()
}

