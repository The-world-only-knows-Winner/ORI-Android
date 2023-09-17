package com.onlywin.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.clickable.duckClickable

@Composable
fun DuckLayout(
    horizontal: Dp = 0.dp,
    content: @Composable ColumnScope.() -> Unit,
) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .duckClickable { focusManager.clearFocus() }
            .background(DuckTheme.colors.background)
            .padding(horizontal = horizontal),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        content()
    }
}