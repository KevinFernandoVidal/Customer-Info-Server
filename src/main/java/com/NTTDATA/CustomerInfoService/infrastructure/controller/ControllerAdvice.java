package com.NTTDATA.CustomerInfoService.infrastructure.controller;

import com.NTTDATA.CustomerInfoService.infrastructure.dto.ErrorDTO;
import com.NTTDATA.CustomerInfoService.infrastructure.exception.BadRequestException;
import com.NTTDATA.CustomerInfoService.infrastructure.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorDTO> badRequestExceptionHandler(BadRequestException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(NotFoundException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
