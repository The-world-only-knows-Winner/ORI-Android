package com.onlywin.ori_android.feature.all

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.clickable.duckClickable
import com.onlywin.designsystem.fondation.typography.Body3
import com.onlywin.designsystem.fondation.typography.Body4
import com.onlywin.ori_android.R

@Composable
internal fun All() {

    var folded by remember { mutableStateOf(false) }
    var favorite by remember { mutableStateOf(false) }
    var notification by remember { mutableStateOf(false) }

    Column {
        Route(
            folded = folded,
            start = "예미지 7단지",
            end = "대덕대학",
            favorite = favorite,
            notification = notification,
            onFavoriteClick = { favorite = it },
            onNotificationClick = { notification = it },
        )
    }
}

@Composable
private fun Routes() {

}

@Composable
private fun Route(
    folded: Boolean,
    start: String,
    end: String,
    favorite: Boolean,
    notification: Boolean,
    onFavoriteClick: (Boolean) -> Unit,
    onNotificationClick: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            RouteText(
                text = stringResource(id = R.string.start),
                destination = start,
            )
            RouteText(
                text = stringResource(id = R.string.end),
                destination = end,
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Image(
                modifier = Modifier.duckClickable(onClick = { onFavoriteClick(!favorite) }),
                painter = painterResource(
                    id = if (favorite) R.drawable.ic_favorite_enabled
                    else R.drawable.ic_favorite_disabled,
                ),
                contentDescription = stringResource(id = R.string.content_description_favorite),
            )
            Image(
                modifier = Modifier.duckClickable(onClick = { onNotificationClick(!notification) }),
                painter = painterResource(
                    id = if (notification) R.drawable.ic_notification_enabled
                    else R.drawable.ic_notification_disabled,
                ),
                contentDescription = stringResource(id = R.string.content_description_notification),
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    AnimatedVisibility(visible = folded) {

    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
        color = DuckTheme.colors.inverseSurface,
    )
}

@Composable
private fun RouteText(
    text: String,
    destination: String,
) {
    Row {
        Body4(
            text = text,
            color = DuckTheme.colors.surfaceTint,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Body3(text = destination)
    }
}
