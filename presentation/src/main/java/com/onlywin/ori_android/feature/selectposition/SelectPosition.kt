package com.onlywin.ori_android.feature.selectposition

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.fondation.typography.Body3
import com.onlywin.designsystem.header.DuckHeader
import com.onlywin.ori_android.R

@Composable
internal fun SelectPosition() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val start by remember { mutableStateOf("") }
        val end by remember { mutableStateOf("") }

        DuckLayout {
            DuckHeader(
                leadingIcon = com.onlywin.designsystem.R.drawable.ic_arrow_back,
                trailingIcon = com.onlywin.designsystem.R.drawable.ic_search,
            )
            Destinations(
                start = start,
                end = end,
            )
        }
    }
}

@Composable
private fun Destinations(
    start: String,
    end: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Destination(
                destination = start,
                positionType = PositionType.START,
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = com.onlywin.designsystem.R.drawable.ic_direction_right),
            contentDescription = stringResource(com.onlywin.designsystem.R.string.icon_direction_right),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Box(modifier = Modifier.weight(1f)) {
            Destination(
                destination = end,
                positionType = PositionType.END,
            )
        }
    }
}

enum class PositionType {
    START,
    END,
}

@Composable
private fun Destination(
    destination: String,
    positionType: PositionType,
) {
    Row(
        modifier = Modifier.padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Image(
            painter = painterResource(
                id = if (destination.isEmpty()) com.onlywin.designsystem.R.drawable.ic_pin
                else com.onlywin.designsystem.R.drawable.ic_pin_primary,
            ),
            contentDescription = stringResource(id = com.onlywin.designsystem.R.string.icon_pin),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Body3(
            text = destination.ifEmpty {
                when (positionType) {
                    PositionType.START -> stringResource(R.string.select_position_start_null)
                    PositionType.END -> stringResource(R.string.select_position_end_null)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectPositionLightPreview() {
    SelectPosition()
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun SelectPositionDarkPreview() {
    DuckTheme {
        SelectPosition()
    }
}