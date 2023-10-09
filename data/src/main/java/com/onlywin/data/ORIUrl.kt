package com.onlywin.data

object ORIUrl {

    private const val auth = "/auth"
    private const val user = "/user"

    object Auth {
        const val token = "$auth/token"
        const val code = "$auth/code"
    }

    object User {
        const val signUp = "$user/signup"
    }
}
