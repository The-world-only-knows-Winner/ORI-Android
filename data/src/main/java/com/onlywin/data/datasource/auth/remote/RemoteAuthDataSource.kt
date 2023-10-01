package com.onlywin.data.datasource.auth.remote

import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.data.model.signin.SignInResponse

interface RemoteAuthDataSource {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse
}