package com.example.Pravara1.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pravara1.Model.Product;
import com.example.Pravara1.Service.ProductService;




@RestController
@RequestMapping("/product")
public class ProductController {
    
ProductService service;
@Autowired

public ProductController(ProductService service){
    this.service=service;
}

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){    
        List<Product> product=service.getAllProducts();
        return ResponseEntity.ok(product);
    }
    
    @PostMapping
    public ResponseEntity<List<Product>> addNewProduct(@RequestBody List<Product> prod){
        List<Product> addNew=service.saveUser(prod);
        return ResponseEntity.ok(addNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        Product products=service.getById(id);
        if (products==null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

 /*   @PutMapping("/{id}")
    public ResponseEntity<Product> updateStudent(
        @PathVariable Integer id, @RequestBody Product updatedProduct){
        Product products=service.getById(id);
            if (products==null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedProduct);
        } */
        @PutMapping("/{id}")
public ResponseEntity<Product> updateStudent(
    @PathVariable Integer id, @RequestBody Product updatedProduct){
    
    Product updated = service.updateById(id, updatedProduct);
    return ResponseEntity.ok(updated);
}

    
}


