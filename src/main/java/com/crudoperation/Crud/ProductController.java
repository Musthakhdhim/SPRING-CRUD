package com.crudoperation.Crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public List<Product> getProducts(){
        return service.getAll();
    }

    @GetMapping("/product/{id}")
    public Product getByid(@PathVariable int id){
        return service.findByid(id);
    }

    @PostMapping("/product/add")
    public void add(@RequestBody Product prod){
        service.add(prod);
    }

    @PutMapping("/product/update/{id}")
    public void update(@PathVariable int id, @RequestBody Product prod){
        service.update(id, prod);
    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @DeleteMapping("/product/delete/all")
    public void deleteAll(){
        service.deleteAll();
    }
}
