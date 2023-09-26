package com.onlywin.data.datasource

import com.onlywin.data.ORIExceptionHandler
import com.onlywin.data.api.AuthApi
import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.data.model.signin.SignInResponse

class AuthDataSource(
    private val authApi: AuthApi,
) {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return ORIExceptionHandler<SignInResponse>().httpRequest {
            authApi.signIn(signInRequest = signInRequest)
        }.sendRequest()
    }
}