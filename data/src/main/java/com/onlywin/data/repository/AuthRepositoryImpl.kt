package com.onlywin.data.repository

import com.onlywin.data.datasource.AuthDataSource
import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.data.model.signin.toEntity
import com.onlywin.domain.entity.TokenEntity
import com.onlywin.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
) : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String,
    ): TokenEntity = authDataSource.signIn(
        SignInRequest(
            email = email,
            password = password,
        )
    ).toEntity()
}