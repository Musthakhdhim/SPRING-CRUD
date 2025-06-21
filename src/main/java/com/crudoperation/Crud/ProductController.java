package com.crudoperation.Crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<?> getByid(@PathVariable int id){

            Product prod=service.findByid(id);
            if(prod==null){
                throw new ProductNotFound("product not found with id:"+id);
            }
            return new ResponseEntity<>(prod, HttpStatus.OK);

//        catch(ProductNotFound e){
//            ExceptionThrower et=new ExceptionThrower(LocalDateTime.now(), "prodcust not found");
//            return new ResponseEntity<>(et, HttpStatus.NOT_FOUND);
//        }

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

    @ExceptionHandler
    public ResponseEntity<?> handleProductNotfound(ProductNotFound pnf){
        ExceptionThrower et=new ExceptionThrower(LocalDateTime.now(), pnf.getMessage());
        return new ResponseEntity<>(et, HttpStatus.NOT_FOUND);
    }
}
