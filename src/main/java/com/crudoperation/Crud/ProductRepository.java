package com.crudoperation.Crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository{
    List<Product> prod=new ArrayList<>();

    public List<Product> findAll(){
        return prod;
    }

    public Product findById(int id){
        Product prod1=prod.stream().filter(x->x.getId()==id).findFirst().orElse(null);
        if(prod1==null){
            throw new ProductNotFound("product with id: "+id+" not found");
        }
        return prod1;
    }

    public void addProduct(Product product){
        prod.add(product);
    }

    public void updateProduct(int id,Product product){
        Product prod1=findById(id);

        if(prod1==null){
            throw new ProductNotFound("product with id: "+id+" not found");
        }
        prod1.setName(product.getName());
        prod1.setPrice(product.getPrice());

    }
    public void deleteProduct(int id){
        Product prod2=findById(id);
        prod.remove(prod2);
    }

    public void deleteAll(){
        prod.clear();
    }
}
