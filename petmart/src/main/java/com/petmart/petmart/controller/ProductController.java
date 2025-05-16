package com.petmart.petmart.controller;

import com.petmart.petmart.dto.ProductDTO;
import com.petmart.petmart.entity.Product;
import com.petmart.petmart.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/products")
 // Cho phép gọi từ frontend
public class ProductController {
    @Autowired
    private ProductServices productServices;

    //Tao 1 san pham
    @PostMapping
    Product createProduct(@RequestBody ProductCreationRequest request){
        return productServices.createProduct(request);
    }

    //Lay 1 product
    @GetMapping("/{productId}")
    ProductDTO getProduct(@PathVariable("productId") Integer productId){
        return productServices.getProduct(productId);
    }

    //Lay tat ca san pham
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productServices.getAllProduct();
    }

    //Update product
    @PutMapping("/{productId}")
    ProductDTO updateProduct(@PathVariable Integer productId, @RequestBody ProductUpdateRequest request){
        return productServices.updateProduct(productId, request);
    }

    //Delete user
    @DeleteMapping("/{productId}")
    String deleteUser(@PathVariable Integer productId){
        productServices.deleteProduct(productId);
        return "Product has been deleted";
    }

}
