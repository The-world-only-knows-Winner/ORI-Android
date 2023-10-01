package com.onlywin.data.datasource.auth

import com.onlywin.data.api.AuthApi
import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.data.model.signin.SignInResponse
import com.onlywin.data.utils.ORIExceptionHandler

class AuthDataSourceImpl(
    private val authApi: AuthApi,
) : AuthDataSource {
    override suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return ORIExceptionHandler<SignInResponse>().httpRequest {
            authApi.signIn(signInRequest = signInRequest)
        }.sendRequest()
    }
}