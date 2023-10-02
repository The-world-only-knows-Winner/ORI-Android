package com.onlywin.ori_android.feature.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.fondation.typography.Body1
import com.onlywin.designsystem.header.DuckHeader
import com.onlywin.ori_android.R
import kotlinx.coroutines.launch

private val tabs = listOf(
    R.string.all,
    R.string.favorite,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun Home() {

    val pagerState = rememberPagerState { tabs.size }

    DuckLayout(horizontal = 20.dp) {
        DuckHeader(
            leadingIcon = R.drawable.ic_ori_header,
            trailingIcon = R.drawable.ic_profile,
        )
        HomeTabMenu(pagerState = pagerState)
        HorizontalPager(state = pagerState) {
            when (it) {
                0 -> All()
                1 -> Favorite()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeTabMenu(
    pagerState: PagerState,
) {

    val coroutineScope = rememberCoroutineScope()

    TabRow(
        containerColor = DuckTheme.colors.background,
        contentColor = DuckTheme.colors.background,
        selectedTabIndex = pagerState.currentPage,
    ) {
        repeat(tabs.size) {
            Tab(
                selected = pagerState.currentPage == it,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(it) } },
            ) {
                Body1(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = stringResource(id = tabs[it]),
                )
            }
        }
    }
}

@Composable
private fun All() {

}

@Composable
private fun Favorite() {

}


@Preview(showBackground = true)
@Composable
private fun HomeLightPreview() {
    DuckTheme {
        Home()
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun HomeDarkPreview() {
    DuckTheme {
        Home()
    }
}

