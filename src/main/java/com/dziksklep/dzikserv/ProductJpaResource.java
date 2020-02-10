package com.dziksklep.dzikserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
public class ProductJpaResource {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("jpa/products")
    public List<Product> getAllProducts(){
        return productJpaRepository.findAll();
    }

    @GetMapping("jpa/products/{id}")
    public Product getProduct(@PathVariable long id){
        return productJpaRepository.findById(id).get();
        //     return productService.findById(id);
    }

    //UPDATE PRODUCT
    @PutMapping("jpa/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable long id, @RequestBody Product product){
        //Product productUpdated = productService.save(product);
        Product productUpdated = productJpaRepository.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    //CREATE NEW PRODUCT
    @PostMapping("jpa/products")
    public Product createProduct(@RequestBody Product product){
        Product createdProduct = productJpaRepository.save(product);
        return createdProduct;
    }

    @DeleteMapping("jpa/products/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){
        productJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
