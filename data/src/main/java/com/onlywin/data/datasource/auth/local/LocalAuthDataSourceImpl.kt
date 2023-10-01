package com.onlywin.data.datasource.auth.local

import android.content.Context
import android.content.SharedPreferences
import java.time.LocalDateTime

class LocalAuthDataSourceImpl(
    private val context: Context,
) : LocalAuthDataSource {

    override fun saveTokens(
        accessToken: String,
        refreshToken: String,
        accessExpiresAt: LocalDateTime,
        refreshExpiresAt: LocalDateTime,
    ) {
        getSharedPreferenceEditor().also {
            it.putString(Keys.ACCESS_TOKEN, accessToken)
            it.putString(Keys.REFRESH_TOKEN, refreshToken)
            it.putString(Keys.ACCESS_EXPIRES_AT, accessExpiresAt.toString())
            it.putString(Keys.REFRESH_EXPIRES_AT, refreshExpiresAt.toString())
        }.apply()
    }

    override fun getAccessToken(): String {
        return getSharedPreference().getString(Keys.ACCESS_TOKEN, "") ?: ""
    }

    override fun getRefreshToken(): String {
        return getSharedPreference().getString(Keys.REFRESH_TOKEN, "") ?: ""
    }

    override fun getExpireAt(): String {
        return getSharedPreference().getString(Keys.ACCESS_EXPIRES_AT, "") ?: ""
    }

    private fun getSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(Keys.NAME, Context.MODE_PRIVATE)
    }

    private fun getSharedPreferenceEditor(): SharedPreferences.Editor {
        return getSharedPreference().edit()
    }
}

object Keys {
    const val NAME = "signal"
    const val ACCESS_TOKEN = "access_token"
    const val REFRESH_TOKEN = "refresh_token"
    const val ACCESS_EXPIRES_AT = "access_expires_at"
    const val REFRESH_EXPIRES_AT = "refresh_expires_at"
}