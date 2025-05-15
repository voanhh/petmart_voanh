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
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productServices.getAllProduct();
    }
}

