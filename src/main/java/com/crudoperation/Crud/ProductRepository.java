package com.crudoperation.Crud;

import org.springframework.stereotype.Repository;

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
        return prod.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }

    public void addProduct(Product product){
        prod.add(product);
    }

    public void updateProduct(int id,Product product){
        Product prod1=findById(id);
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
