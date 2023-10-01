package com.onlywin.data.utils

import com.onlywin.data.api.AuthApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    internal fun getRetrofit() = Retrofit.Builder()
        .baseUrl("https://jeongho.dev")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun getAuthApi(): AuthApi? = ApiProvider.getRetrofit().create(AuthApi::class.java)