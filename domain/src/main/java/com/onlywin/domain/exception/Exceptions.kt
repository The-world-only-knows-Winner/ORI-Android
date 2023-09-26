package com.onlywin.domain.exception

class UnAuthorized : Throwable() // 401
class NotFoundException : Throwable() // 404
class ConflictException : Throwable() // 409
class TooManyRequestException : Throwable() // 429
class InternalServerException : Throwable() // 500..599
class UnknownException : Throwable()
