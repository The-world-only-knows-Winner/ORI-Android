package com.onlywin.domain.repository

interface UserRepository {
    suspend fun signUp(
        email: String,
        password: String,
        name: String,
        birthday: String,
    )
}