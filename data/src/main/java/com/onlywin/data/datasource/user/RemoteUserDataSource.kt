package com.onlywin.data.datasource.user

import com.onlywin.data.model.signup.SignUpRequest

interface RemoteUserDataSource {
    suspend fun signUp(signUpRequest: SignUpRequest)
}