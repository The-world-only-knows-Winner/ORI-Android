package com.onlywin.data.model.auth.verifyauthcode

import com.google.gson.annotations.SerializedName

data class VerifyAuthCodeRequest(
    @SerializedName("code") val code: String,
    @SerializedName("email") val email: String
)
