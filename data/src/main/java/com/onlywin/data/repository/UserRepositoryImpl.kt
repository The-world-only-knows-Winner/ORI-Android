package com.onlywin.data.repository

import com.onlywin.data.datasource.user.RemoteUserDataSource
import com.onlywin.data.model.signup.SignUpRequest
import com.onlywin.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteUserDataSource: RemoteUserDataSource,
) : UserRepository {
    override suspend fun signUp(
        email: String,
        password: String,
        name: String,
        birthday: String,
    ) {
        remoteUserDataSource.signUp(
            SignUpRequest(
                email = email,
                password = password,
                name = name,
                birthday = birthday,
            )
        )
    }
}