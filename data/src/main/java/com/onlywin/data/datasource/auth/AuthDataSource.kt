package com.onlywin.data.datasource.auth

import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.data.model.signin.SignInResponse

interface AuthDataSource {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse
}