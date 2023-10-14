package com.onlywin.data.utils

import com.onlywin.data.api.AuthApi
import com.onlywin.data.api.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    fun getOkHttpClient(
        httpLoginInterceptor: HttpLoggingInterceptor,
        interceptor: ORIInterceptor,
    ) = OkHttpClient.Builder().addInterceptor(httpLoginInterceptor).addInterceptor(interceptor)
        .build()

    private fun getRetrofit(
        interceptor: ORIInterceptor,
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://jeongho.dev")
        .client(
            getOkHttpClient(
                httpLoginInterceptor = getHttpLoggingInterceptor(),
                interceptor = interceptor,
            )
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAuthApi(interceptor: ORIInterceptor): AuthApi =
        getRetrofit(interceptor).create(AuthApi::class.java)

    fun getUserApi(interceptor: ORIInterceptor): UserApi =
        getRetrofit(interceptor).create(UserApi::class.java)
}