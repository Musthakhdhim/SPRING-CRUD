package com.crudoperation.Crud;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
//public class GlobalExceptionHandlers  extends ResponseEntityExceptionHandler {
public class GlobalExceptionHandlers {
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Object> handleProductNotFound(ProductNotFound pnf){
        ExceptionThrower et=new ExceptionThrower(LocalDateTime.now(), pnf.getMessage());
        return new ResponseEntity<>(et, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errorMap=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((err)->{
            String field=((FieldError)err).getField();
            String errorMsg=err.getDefaultMessage();
            errorMap.put(field,errorMsg);
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }




    //if we extend the REsponseEntityException handler then we can use this method
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        Map<String, String> errormap=new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((err)->{
//            String field=((FieldError)err).getField();
//            String errormsg=err.getDefaultMessage();
//
//            errormap.put(field, errormsg);
//        });
//        return new ResponseEntity<>(errormap, HttpStatus.BAD_REQUEST);
//    }
}
