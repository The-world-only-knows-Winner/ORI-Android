package com.onlywin.domain.usecase.user

import com.onlywin.domain.repository.UserRepository

class SignUpUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        name: String,
        birthday: String,
    ) = runCatching {
        userRepository.signUp(
            email = email,
            password = password,
            name = name,
            birthday = birthday,
        )
    }
}