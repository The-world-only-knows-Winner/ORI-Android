package com.onlywin.data.api

import com.onlywin.data.ORIUrl
import com.onlywin.data.model.auth.sendauthcode.SendAuthCodeRequest
import com.onlywin.data.model.auth.signin.SignInRequest
import com.onlywin.data.model.auth.signin.SignInResponse
import com.onlywin.data.model.auth.verifyauthcode.VerifyAuthCodeRequest
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthApi {
    @POST(ORIUrl.Auth.token)
    suspend fun signIn(
        @Body signInRequest: SignInRequest,
    ): SignInResponse

    @POST(ORIUrl.Auth.code)
    suspend fun sendAuthCode(@Body sendAuthCodeRequest: SendAuthCodeRequest)

    @PATCH(ORIUrl.Auth.code)
    suspend fun verifyCodeAuthCode(@Body verifyAuthCodeRequest: VerifyAuthCodeRequest)
}
