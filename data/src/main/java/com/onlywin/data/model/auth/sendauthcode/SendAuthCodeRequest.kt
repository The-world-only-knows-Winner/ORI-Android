package com.onlywin.data.model.auth.sendauthcode

import com.google.gson.annotations.SerializedName

data class SendAuthCodeRequest(
    @SerializedName("email") val email: String,
)
