package com.crudoperation.Crud;

public class ProductNotFound extends RuntimeException{

    ProductNotFound(String message){
        super(message);
    }

}
