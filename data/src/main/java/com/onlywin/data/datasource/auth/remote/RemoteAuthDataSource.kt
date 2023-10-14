package com.onlywin.data.datasource.auth.remote

import com.onlywin.data.model.auth.sendauthcode.SendAuthCodeRequest
import com.onlywin.data.model.auth.signin.SignInRequest
import com.onlywin.data.model.auth.signin.SignInResponse
import com.onlywin.data.model.auth.verifyauthcode.VerifyAuthCodeRequest

interface RemoteAuthDataSource {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse

    suspend fun sendAuthCode(sendAuthCodeRequest: SendAuthCodeRequest)

    suspend fun verifyAuthCode(verifyAuthCodeRequest: VerifyAuthCodeRequest)
}
