package com.example.Pravara1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Pravara1.Model.Product;
import com.example.Pravara1.Repository.ProductRepo;



@Service

public class ProductService {
    @Autowired
    private ProductRepo repo ;
@Transactional
    public List<Product> saveUser(List<Product> productList){
        return repo.saveAll(productList);
    }


public List<Product> getAllProducts(){
   return repo.findAll();
}

public Product getById(Integer id){
    return  repo.findById(id).orElseThrow(() -> new RuntimeException("student of id  : " + id + "not find"));
}


public Product deleteById(Integer id){
    Product productobj= repo.findById(id).orElseThrow(() -> new RuntimeException("student of id  : " + id +"not find"));
    repo.deleteById(id);
  return productobj;
} 


public Product updateById(Integer id, Product updatedProduct) {
    Product existingProduct = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

    existingProduct.setName(updatedProduct.getName());
    existingProduct.setRollColl(updatedProduct.getRollColl());

    return repo.save(existingProduct);
}

}

