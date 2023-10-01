package com.onlywin.data.utils

import com.onlywin.data.ORIUrl
import com.onlywin.data.datasource.auth.local.LocalAuthDataSource
import okhttp3.Interceptor
import okhttp3.Response

class ORIInterceptor(
    private val localAuthDataSource: LocalAuthDataSource,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath

        val ignorePaths = listOf(
            ORIUrl.Auth.token,
        )

        if (ignorePaths.contains(path)) {
            return chain.proceed(request)
        }

        return chain.proceed(
            request
                .newBuilder()
                .header("Authorization", localAuthDataSource.getAccessToken())
                .build()
        )
    }
}