package com.onlywin.domain.repository

import com.onlywin.domain.entity.TokenEntity

interface AuthRepository {
    suspend fun signIn(
        email: String,
        password: String,
    ): TokenEntity
}