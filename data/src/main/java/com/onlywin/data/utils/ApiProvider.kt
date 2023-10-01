package com.onlywin.data.utils

import com.onlywin.data.api.AuthApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    internal fun getRetrofit(
        interceptor: Interceptor,
    ) = Retrofit.Builder()
        .baseUrl("https://jeongho.dev")
        .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun getAuthApi(
    interceptor: Interceptor,
): AuthApi? = ApiProvider.getRetrofit(interceptor).create(AuthApi::class.java)