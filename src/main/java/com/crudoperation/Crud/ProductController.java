package com.crudoperation.Crud;


//import org.apache.logging.log4j.Logger;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    private static final Logger logger=LoggerFactory.getLogger(ProductController.class);


    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public List<Product> getProducts(){
        logger.info("returning all the products");
        return service.getAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getByid(@PathVariable int id){

            Product prod=service.findByid(id);
            if(prod==null){
                logger.error("the product with given id is not available");
                throw new ProductNotFound("product not found with id:"+id);
            }
            logger.info("returning the product with the given id");
            return new ResponseEntity<>(prod, HttpStatus.OK);

//        catch(ProductNotFound e){
//            ExceptionThrower et=new ExceptionThrower(LocalDateTime.now(), "prodcust not found");
//            return new ResponseEntity<>(et, HttpStatus.NOT_FOUND);
//        }

    }

    @PostMapping("/product/add")
    public void add(@Valid  @RequestBody Product prod){
        logger.info("product added succcessfully");
        service.add(prod);
    }

    @PutMapping("/product/update/{id}")
    public void update(@PathVariable int id, @RequestBody Product prod){
        logger.info("product updated successfullly");
        service.update(id, prod);
    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable int id){
        logger.info("product with the given id is deleted");
        service.delete(id);
    }

    @DeleteMapping("/product/delete/all")
    public void deleteAll(){
        logger.info("products deleted");
        service.deleteAll();
    }

//    @ExceptionHandler
//    public ResponseEntity<?> handleProductNotfound(ProductNotFound pnf){
//        ExceptionThrower et=new ExceptionThrower(LocalDateTime.now(), pnf.getMessage());
//        return new ResponseEntity<>(et, HttpStatus.NOT_FOUND);
//    }
}
