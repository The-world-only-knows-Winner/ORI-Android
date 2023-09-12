package com.onlywin.ori_android.feature

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.onlywin.designsystem.R

@Composable
internal fun Splash() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(0.6f),
            painter = painterResource(id = R.drawable.bg_splash),
            contentDescription = stringResource(R.string.content_description_image_splash),
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

