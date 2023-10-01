package com.onlywin.data.api

import com.onlywin.data.ORIUrl
import com.onlywin.data.model.signin.SignInRequest
import com.onlywin.data.model.signin.SignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST(ORIUrl.Auth.token)
    suspend fun signIn(
        @Body signInRequest: SignInRequest,
    ): SignInResponse
}