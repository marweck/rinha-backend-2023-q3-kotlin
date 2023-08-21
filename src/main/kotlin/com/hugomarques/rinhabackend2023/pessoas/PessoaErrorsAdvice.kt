package com.hugomarques.rinhabackend2023.pessoas

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class PessoaErrorsAdvice {
    @ResponseBody
    @ExceptionHandler(
        PessoaNotFoundException::class
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun pessoaNotFoundHandler(ex: PessoaNotFoundException): String? =
        ex.message

    @ResponseBody
    @ExceptionHandler(
        DataIntegrityViolationException::class
    )
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun apelidoDuplicadoHandler(ex: DataIntegrityViolationException): String =
        "Apelido já em uso"
}
