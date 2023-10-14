package com.onlywin.data.api

import com.onlywin.data.ORIUrl
import com.onlywin.data.model.signup.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST(ORIUrl.User.signUp)
    suspend fun signUp(@Body signUpRequest: SignUpRequest)
}