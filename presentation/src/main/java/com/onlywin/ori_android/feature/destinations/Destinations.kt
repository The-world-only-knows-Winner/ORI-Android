package com.onlywin.ori_android.feature.destinations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.clickable.duckClickable
import com.onlywin.designsystem.fondation.typography.Body1
import com.onlywin.designsystem.fondation.typography.Body3
import com.onlywin.designsystem.fondation.typography.Body4
import com.onlywin.designsystem.fondation.typography.Heading2
import com.onlywin.ori_android.R

@Composable
internal fun Destinations(
    screenType: ScreenType,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Empty(screenType = screenType)
    }
}


enum class ScreenType {
    ALL,
    FAVORITE,
}

@Composable
private fun Empty(
    screenType: ScreenType,
) {

    val onClick = { }

    val title = when (screenType) {
        ScreenType.ALL -> stringResource(id = R.string.home_all_empty_title)
        else -> stringResource(id = R.string.home_favorite_empty_title)
    }

    val description = when (screenType) {
        ScreenType.ALL -> stringResource(id = R.string.home_favorite_empty_title)
        else -> stringResource(id = R.string.home_favorite_empty_description)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Heading2(text = title)
            Body1(
                text = description,
                color = DuckTheme.colors.surfaceTint,
            )
            if (screenType == ScreenType.ALL) {
                Spacer(modifier = Modifier.height(16.dp))
                DuckLargeButton(
                    text = stringResource(id = R.string.home_add_favorite),
                    onClick = onClick,
                )
            }
        }
    }
}

@Composable
private fun Routes() {

    var folded by remember { mutableStateOf(false) }
    var favorite by remember { mutableStateOf(false) }
    var notification by remember { mutableStateOf(false) }

    LazyColumn {
        items(3) {
            Route(
                folded = folded,
                start = "예미지 7단지",
                end = "대덕대학",
                favorite = favorite,
                notification = notification,
                onFavoriteClick = { favorite = it },
                onNotificationClick = { notification = it },
                onClick = { folded = !folded }
            )
        }
    }
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
    onClick: () -> Unit
) {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
        color = DuckTheme.colors.inverseSurface,
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .duckClickable(onClick = onClick)
            .padding(vertical = 20.dp),
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
        Spacer(modifier = Modifier.width(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Image(
                modifier = Modifier.duckClickable(onClick = { onFavoriteClick(!favorite) }),
                painter = painterResource(
                    id = if (favorite) com.onlywin.designsystem.R.drawable.ic_favorite_enabled
                    else com.onlywin.designsystem.R.drawable.ic_favorite_disabled,
                ),
                contentDescription = stringResource(id = com.onlywin.designsystem.R.string.icon_favorite),
            )
            Image(
                modifier = Modifier.duckClickable(onClick = { onNotificationClick(!notification) }),
                painter = painterResource(
                    id = if (notification) com.onlywin.designsystem.R.drawable.ic_notification_enabled
                    else com.onlywin.designsystem.R.drawable.ic_notification_disabled,
                ),
                contentDescription = stringResource(id = com.onlywin.designsystem.R.string.icon_destination),
            )
        }
    }
    Column {
        AnimatedVisibility(visible = folded) {
            Column {
                Stations()
            }
        }
    }
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

@Composable
private fun Stations() {
    repeat(2) {
        Station(
            title = "봉명중학교",
            description = "114",
            stationType = if (it == 1) StationType.DESTINATION
            else StationType.STATION,
            timelineType = if (it == 0) TimelineType.START
            else if (it == 1) TimelineType.END
            else TimelineType.MIDDLE,
        )
    }
}

@Composable
private fun Station(
    title: String,
    description: String,
    stationType: StationType,
    timelineType: TimelineType,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Timeline(
            type = timelineType,
        )
        Image(
            painterResource(
                id = when (stationType) {
                    StationType.STATION -> com.onlywin.designsystem.R.drawable.ic_bus
                    StationType.DESTINATION -> com.onlywin.designsystem.R.drawable.ic_destination
                }
            ),
            contentDescription = stringResource(id = com.onlywin.designsystem.R.string.icon_bus),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Body1(text = title)
            Body3(text = description)
        }
    }
}

private enum class StationType {
    STATION, DESTINATION,
}

private enum class TimelineType {
    START,
    MIDDLE,
    END,
}

@Composable
private fun TimelineIndicator() {
    Divider(
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = DuckTheme.colors.primary,
                shape = CircleShape,
            ),
        color = DuckTheme.colors.background,
    )
}

@Composable
private fun Timeline(
    type: TimelineType,
) {
    Box(
        modifier = Modifier.padding(
            start = 8.dp,
            end = 8.dp,
            top = if (type == TimelineType.START) 20.dp
            else 0.dp,
            bottom = if (type == TimelineType.END) 20.dp
            else 0.dp,
        ),
        contentAlignment = when (type) {
            TimelineType.START -> Alignment.TopCenter
            TimelineType.END -> Alignment.BottomCenter
            else -> Alignment.Center
        }
    ) {
        Divider(
            modifier = Modifier
                .height(88.dp)
                .width(2.dp),
            color = DuckTheme.colors.primary,
        )
        TimelineIndicator()
    }
}
