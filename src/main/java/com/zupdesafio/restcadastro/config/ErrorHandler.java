package com.zupdesafio.restcadastro.config;

import com.zupdesafio.restcadastro.controller.dto.ApiErrorReturn;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiErrorReturn handleIllegalArgument(IllegalArgumentException exception) {
        return new ApiErrorReturn(exception.getMessage());
    }

}