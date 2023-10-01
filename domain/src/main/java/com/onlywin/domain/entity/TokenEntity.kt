package com.onlywin.domain.entity

import java.time.LocalDateTime

data class TokenEntity(
    val accessToken: String,
    val accessExpiresAt: LocalDateTime,
    val refreshToken: String,
    val refreshExpiresAt: LocalDateTime,
)