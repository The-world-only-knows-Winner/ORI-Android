package com.onlywin.data.model.auth.signin

import com.google.gson.annotations.SerializedName
import com.onlywin.domain.entity.TokenEntity
import java.time.LocalDateTime

data class SignInResponse(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("accessExpiresAt") val accessExpiresAt: LocalDateTime,
    @SerializedName("refreshToken") val refreshToken: String,
    @SerializedName("refreshExpiresAt") val refreshExpiresAt: LocalDateTime,
)

fun SignInResponse.toEntity() = TokenEntity(
    accessToken = this.accessToken,
    accessExpiresAt = this.accessExpiresAt,
    refreshToken = this.refreshToken,
    refreshExpiresAt = this.refreshExpiresAt,
)
