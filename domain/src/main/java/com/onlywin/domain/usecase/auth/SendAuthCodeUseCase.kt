package com.onlywin.domain.usecase.auth

import com.onlywin.domain.repository.AuthRepository

class SendAuthCodeUseCase(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(email: String) = kotlin.runCatching {
        authRepository.sendAuthCode(email)
    }
}
