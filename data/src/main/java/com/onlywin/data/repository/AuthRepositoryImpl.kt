package com.onlywin.data.repository

import com.onlywin.data.datasource.auth.local.LocalAuthDataSource
import com.onlywin.data.datasource.auth.remote.RemoteAuthDataSource
import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val remoteAuthDataSource: RemoteAuthDataSource,
    private val localAuthDataSource: LocalAuthDataSource,
) : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String,
    ) {
        remoteAuthDataSource.signIn(
            SignInRequest(
                email = email,
                password = password,
            )
        ).also {
            localAuthDataSource.saveTokens(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken,
                accessExpiresAt = it.accessExpiresAt,
                refreshExpiresAt = it.refreshExpiresAt,
            )
        }
    }
}