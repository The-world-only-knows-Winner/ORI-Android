package com.onlywin.data.utils

import com.onlywin.domain.exception.BadRequestException
import com.onlywin.domain.exception.ConflictException
import com.onlywin.domain.exception.InternalServerException
import com.onlywin.domain.exception.NotFoundException
import com.onlywin.domain.exception.TooManyRequestException
import com.onlywin.domain.exception.UnAuthorized
import com.onlywin.domain.exception.UnknownException
import retrofit2.HttpException

class ORIExceptionHandler<T> {

    private lateinit var httpRequest: suspend () -> T

    fun httpRequest(httpRequest: suspend () -> T) = this.apply {
        this.httpRequest = httpRequest
    }

    suspend fun sendRequest(): T = try {
        httpRequest()
    } catch (e: HttpException) {
        throw when (e.code()) {
            400 -> BadRequestException()
            401 -> UnAuthorized()
            404 -> NotFoundException()
            409 -> ConflictException()
            429 -> TooManyRequestException()
            in 500..599 -> InternalServerException()
            else -> UnknownException()
        }
    }
}