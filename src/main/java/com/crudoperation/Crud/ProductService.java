package com.crudoperation.Crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public Product findByid(int id){
        return repo.findById(id);
    }

    public void add(Product prod){
        repo.addProduct(prod);
    }

    public void update(int id, Product prod){
        repo.updateProduct(id, prod);
    }

    public void delete(int id){
        repo.deleteProduct(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

}
