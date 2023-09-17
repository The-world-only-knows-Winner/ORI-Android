package com.onlywin.ori_android.feature.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.component.Indicator
import com.onlywin.designsystem.fondation.typography.Body3
import com.onlywin.designsystem.fondation.typography.Body4
import com.onlywin.designsystem.fondation.typography.Heading2
import com.onlywin.ori_android.R

const val PAGE_COUNT = 3

private val onboardingDrawables = listOf(
    R.drawable.bg_onboarding_1,
    R.drawable.bg_onboarding_3,
    R.drawable.bg_onboarding_4,
)

private val onboardingTitles = listOf(
    R.string.onboarding_description_title_1,
    R.string.onboarding_description_title_2,
    R.string.onboarding_description_title_3,
    R.string.onboarding_description_title_4,
)

private val onboardingDescriptions = listOf(
    R.string.onboarding_description_des_1,
    R.string.onboarding_description_des_2,
    R.string.onboarding_description_des_3,
    R.string.onboarding_description_des_4,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun Onboarding(
    moveToSignUp: () -> Unit,
    moveToSignIn: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { PAGE_COUNT })

    DuckLayout {
        OnboardingPager(pagerState)
        Spacer(modifier = Modifier.height(12.dp))
        PagerIndicator(currentPage = pagerState.currentPage)
        Spacer(modifier = Modifier.height(24.dp))
        Heading2(text = stringResource(onboardingTitles[pagerState.currentPage]))
        Spacer(modifier = Modifier.height(4.dp))
        Body3(text = stringResource(id = onboardingDescriptions[pagerState.currentPage]))
        Spacer(modifier = Modifier.weight(1f))
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            DuckLargeButton(
                text = stringResource(id = R.string.onboarding_start_with_new_account),
                onClick = moveToSignUp,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Body4(
            text = stringResource(id = R.string.onboarding_start_with_original_account),
            decoration = TextDecoration.Underline,
            onClick = moveToSignIn,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OnboardingPager(pagerState: PagerState) {
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

@Composable
private fun PagerIndicator(currentPage: Int) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(PAGE_COUNT) {
            Indicator(it == currentPage)
        }
    }
}

@Preview(
    name = "Light Theme Onboarding",
    showBackground = true,
)
@Composable
private fun LightThemeOnboardingPreview() {
    Onboarding(moveToSignUp = { /*TODO*/ }) {

    }
}

@Preview(
    name = "Dark Theme Onboarding",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun DarkThemeOnboardingPreview() {
    Onboarding(moveToSignUp = { /*TODO*/ }) {

    }
}