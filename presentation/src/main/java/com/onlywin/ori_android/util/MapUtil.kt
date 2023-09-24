package com.onlywin.ori_android.util

import android.content.Context
import android.location.LocationManager
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraPosition
import com.kakao.vectormap.camera.CameraUpdateFactory

private fun getCurrentLocation(context: Context): Pair<Double, Double> {

    val permissionManager = PermissionManager()

    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        ?: throw NullPointerException()

    // TODO RuntimeException -> RevokePermissionException() 으로 변경
    return if (permissionManager.checkPermission(context)) {
        location.latitude to location.longitude
    } else throw RuntimeException()
}

internal fun setUserLocation(
    context: Context,
    kakaoMap: KakaoMap,
) {
    runCatching {
        getCurrentLocation(context)
    }.onSuccess { currentPosition ->
        kakaoMap.moveCamera(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.from(
                    currentPosition.first,
                    currentPosition.second,
                    0,
                    0.0,
                    10.0,
                    3000.0,
                ),
            ),
            CameraAnimation.from(500),
        )
    }.onFailure {
        when (it) {
            is NullPointerException -> {

            }
            // TODO RuntimeException -> RevokePermissionException() 으로 변경
            is RuntimeException -> {

            }
        }
    }
}