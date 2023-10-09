package com.onlywin.domain.repository

interface AuthRepository {
    suspend fun signIn(
        email: String,
        password: String,
    )

    suspend fun sendAuthCode(email: String)
}
