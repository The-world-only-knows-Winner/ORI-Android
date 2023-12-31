package com.onlywin.designsystem.header

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.R
import com.onlywin.designsystem.clickable.duckClickable
import com.onlywin.designsystem.fondation.typography.Body1
import com.onlywin.designsystem.fondation.typography.Heading1

@Composable
fun DuckAuthHeader(
    pageTitle: String,
    leadingOnClick: (() -> Unit),
) {
    DuckHeader(
        leadingIcon = R.drawable.ic_arrow_back,
        pageTitle = pageTitle,
        leadingOnClick = leadingOnClick,
    )
}

@Composable
fun DuckHeader(
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    leadingOnClick: (() -> Unit)? = null,
    trailingOnClick: (() -> Unit)? = null,
    headerTitle: String? = null,
    headerTitleColor: Color = DuckTheme.colors.onBackground,
    pageTitle: String? = null,
    pageTitleColor: Color = DuckTheme.colors.onBackground,
) {
    Column {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leadingIcon != null) {
                Image(
                    modifier = Modifier.duckClickable(onClick = { leadingOnClick?.invoke() }),
                    painter = painterResource(id = leadingIcon),
                    contentDescription = stringResource(id = R.string.content_description_icon_header_leading),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (headerTitle != null) {
                Body1(
                    text = headerTitle,
                    color = headerTitleColor,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (trailingIcon != null) {
                Image(
                    modifier = Modifier.duckClickable(onClick = { trailingOnClick?.invoke() }),
                    painter = painterResource(id = trailingIcon),
                    contentDescription = stringResource(id = R.string.content_description_icon_header_trailing),
                )
            }
        }
        if (pageTitle != null) {
            Box(modifier = Modifier.padding(vertical = 24.dp)) {
                Heading1(
                    text = pageTitle,
                    color = pageTitleColor,
                )
            }
        }
    }
}