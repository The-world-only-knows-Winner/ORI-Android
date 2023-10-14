package com.onlywin.domain.usecase.auth

import com.onlywin.domain.repository.AuthRepository

class VerifyAuthCodeUseCase(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        email: String,
        code: String,
    ) = kotlin.runCatching {
        authRepository.verifyAuthCode(
            email = email,
            code = code,
        )
    }
}