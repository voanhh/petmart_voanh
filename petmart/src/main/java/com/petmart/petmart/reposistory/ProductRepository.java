package com.petmart.petmart.reposistory;

import com.petmart.petmart.dto.ProductDTO;
import com.petmart.petmart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
