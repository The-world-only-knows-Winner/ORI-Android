package com.onlywin.data.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: String,
    @SerializedName("birthday") val birthday: String,
)
