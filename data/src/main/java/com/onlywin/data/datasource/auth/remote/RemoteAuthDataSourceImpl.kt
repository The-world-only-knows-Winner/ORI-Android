package com.onlywin.data.datasource.auth.remote

import com.onlywin.data.api.AuthApi
import com.onlywin.data.model.auth.sendauthcode.SendAuthCodeRequest
import com.onlywin.data.model.auth.signin.SignInRequest
import com.onlywin.data.model.auth.signin.SignInResponse
import com.onlywin.data.model.auth.verifyauthcode.VerifyAuthCodeRequest
import com.onlywin.data.utils.ORIExceptionHandler

class RemoteAuthDataSourceImpl(
    private val authApi: AuthApi,
) : RemoteAuthDataSource {
    override suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return ORIExceptionHandler<SignInResponse>().httpRequest {
            authApi.signIn(signInRequest = signInRequest)
        }.sendRequest()
    }

    override suspend fun sendAuthCode(sendAuthCodeRequest: SendAuthCodeRequest) =
        ORIExceptionHandler<Unit>().httpRequest {
            authApi.sendAuthCode(sendAuthCodeRequest)
        }.sendRequest()

    override suspend fun verifyAuthCode(verifyAuthCodeRequest: VerifyAuthCodeRequest) =
        ORIExceptionHandler<Unit>().httpRequest {
            authApi.verifyCodeAuthCode(verifyAuthCodeRequest)
        }.sendRequest()
}
