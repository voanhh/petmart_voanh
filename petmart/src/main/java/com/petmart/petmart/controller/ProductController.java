package com.petmart.petmart.controller;

import com.petmart.petmart.dto.ProductDTO;
import com.petmart.petmart.entity.Product;
import com.petmart.petmart.reposistory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Cho phép gọi từ frontend
public class ProductController {
    @Autowired
    private ProductRepository productRepo;
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}

