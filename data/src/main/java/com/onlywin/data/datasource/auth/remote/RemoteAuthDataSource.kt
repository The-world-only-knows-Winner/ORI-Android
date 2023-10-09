package com.onlywin.data.datasource.auth.remote

import com.onlywin.data.model.auth.sendauthcode.SendAuthCodeRequest
import com.onlywin.data.model.auth.signin.SignInRequest
import com.onlywin.data.model.auth.signin.SignInResponse

interface RemoteAuthDataSource {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse

    suspend fun sendAuthCode(sendAuthCodeRequest: SendAuthCodeRequest)
}
