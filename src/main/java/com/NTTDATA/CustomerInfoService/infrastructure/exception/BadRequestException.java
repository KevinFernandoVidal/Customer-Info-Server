package com.NTTDATA.CustomerInfoService.infrastructure.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException{
    private String code;

    public BadRequestException(String code, String message){
        super(message);
        this.code = code;
    }
}
