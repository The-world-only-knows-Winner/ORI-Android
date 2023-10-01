package com.onlywin.ori_android.feature.selectposition

import android.Manifest
import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.location.Geocoder
import android.view.LayoutInflater
import android.view.View
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.MapView
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.button.DuckLargeButton
import com.onlywin.designsystem.component.DuckLayout
import com.onlywin.designsystem.fondation.color.DuckButtonColor
import com.onlywin.designsystem.fondation.typography.Body1
import com.onlywin.designsystem.fondation.typography.Body3
import com.onlywin.designsystem.fondation.typography.Heading2
import com.onlywin.designsystem.header.DuckHeader
import com.onlywin.ori_android.R
import com.onlywin.ori_android.util.setUserLocation

enum class PositionType {
    START,
    END,
}

private val onRequestPermissionResult: (Boolean) -> Unit = {

}

@Composable
internal fun SelectPosition() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val activityLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = onRequestPermissionResult,
        )

        LaunchedEffect(Unit) {
            activityLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        val start by remember { mutableStateOf("") }
        val end by remember { mutableStateOf("") }

        var position by remember { mutableStateOf("대덕소프트웨어마이스터고등학교") }
        var positionDetail by remember { mutableStateOf("") }

        val onPositionChange: (String) -> Unit = { value: String ->
            position = value
        }

        val onPositionDetailChange: (String) -> Unit = { value: String ->
            positionDetail = value
        }

        val onStartClick: () -> Unit = {

        }

        val onEndClick: () -> Unit = {

        }

        DuckLayout() {
            Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                DuckHeader(
                    leadingIcon = com.onlywin.designsystem.R.drawable.ic_arrow_back,
                    trailingIcon = com.onlywin.designsystem.R.drawable.ic_search,
                )
            }
            Destinations(
                start = start,
                end = end,
            )
            AndroidView(
                modifier = Modifier.weight(1f),
                factory = {
                    initMapView(
                        context = it,
                        onPositionChange = onPositionChange,
                        onPositionDetailChange = onPositionDetailChange,
                    )
                },
            )
            Position(
                position = position,
                positionDetail = positionDetail,
                onStartClick = onStartClick,
                onEndClick = onEndClick,
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


private fun initMapView(
    context: Context,
    onPositionChange: (String) -> Unit,
    onPositionDetailChange: (String) -> Unit,
): View {
    val view = LayoutInflater.from(context).inflate(
        /* resource = */ R.layout.select_position,
        /* root = */ null,
        /* attachToRoot = */ false,
    )

    val fab = view.findViewById<FloatingActionButton>(R.id.fab_gps)

    val mapView = view.findViewById<MapView>(R.id.map_view)
    mapView.start(object : KakaoMapReadyCallback() {
        override fun onMapReady(kakaoMap: KakaoMap) {
            setUserLocation(
                context = context,
                kakaoMap = kakaoMap,
            )
            kakaoMap.setOnCameraMoveEndListener { _, cameraPosition, _ ->
                with(cameraPosition.position) {
                    val geoCoder = Geocoder(context)
                    val location = geoCoder.getFromLocation(
                        this.latitude,
                        this.longitude,
                        1,
                    )?.first()

                    val subAddress = location?.getAddressLine(0)
                    onPositionDetailChange(subAddress!!)
                }
            }
            fab.setOnClickListener {
                setUserLocation(
                    context = context,
                    kakaoMap = kakaoMap,
                )
            }
        }
    })

    return view
}

@Composable
private fun Position(
    position: String,
    positionDetail: String,
    onStartClick: () -> Unit,
    onEndClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Heading2(text = position)
        Body1(
            text = positionDetail,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
    ) {
        Box(modifier = Modifier.weight(1f)) {
            DuckLargeButton(
                text = stringResource(id = R.string.select_position_select_start),
                onClick = onStartClick,
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            DuckLargeButton(
                text = stringResource(id = R.string.select_position_select_end),
                onClick = onEndClick,
                buttonColor = DuckButtonColor.SubColor,
            )
        }
    }
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