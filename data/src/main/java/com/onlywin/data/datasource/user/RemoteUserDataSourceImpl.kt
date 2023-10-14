package com.onlywin.data.datasource.user

import com.onlywin.data.api.UserApi
import com.onlywin.data.model.signup.SignUpRequest
import com.onlywin.data.utils.ORIExceptionHandler

class RemoteUserDataSourceImpl(
    private val userApi: UserApi,
) : RemoteUserDataSource {
    override suspend fun signUp(signUpRequest: SignUpRequest) =
        ORIExceptionHandler<Unit>().httpRequest {
            userApi.signUp(signUpRequest)
        }.sendRequest()
}