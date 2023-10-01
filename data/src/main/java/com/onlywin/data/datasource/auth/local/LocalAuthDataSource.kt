package com.onlywin.data.datasource.auth.local

import java.time.LocalDateTime

interface LocalAuthDataSource {
    fun saveTokens(
        accessToken: String,
        refreshToken: String,
        accessExpiresAt: LocalDateTime,
        refreshExpiresAt: LocalDateTime,
    )

    fun getAccessToken(): String
    fun getRefreshToken(): String
    fun getExpireAt(): String
}