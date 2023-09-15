package com.onlywin.ori_android.feature.onboard

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.onlywin.ori_android.R

const val PAGE_COUNT = 3

private val onboardingDrawables = listOf(
    R.drawable.bg_onboarding_1,
    R.drawable.bg_onboarding_3,
    R.drawable.bg_onboarding_4,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun Onboarding() {

    val pagerState = rememberPagerState(pageCount = { PAGE_COUNT })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            modifier = Modifier
                .aspectRatio(1f),
            state = pagerState,
        ) {
            Image(
                painter = painterResource(id = onboardingDrawables[it]),
                contentDescription = stringResource(id = R.string.content_description_image_onboarding),
            )
        }
    }
}

@Preview(
    name = "Light Theme Onboarding",
    showBackground = true,
)
@Composable
private fun LightThemeOnboardingPreview() {
    Onboarding()
}

@Preview(
    name = "Dark Theme Onboarding",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun DarkThemeOnboardingPreview() {
    Onboarding()
}