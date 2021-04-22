package com.zupdesafio.restcadastro.controller.dto;

public class ApiErrorReturn {

    private String errorMessage;

    public ApiErrorReturn(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
