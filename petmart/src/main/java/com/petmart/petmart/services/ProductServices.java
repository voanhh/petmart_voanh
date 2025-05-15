package com.petmart.petmart.services;


import com.petmart.petmart.dto.ProductDTO;
import com.petmart.petmart.entity.Product;
import com.petmart.petmart.reposistory.ProductRepository;
import com.petmart.petmart.services.imp.ProductServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices implements ProductServicesImp {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for(Product product: productList){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getProductId());
            productDTO.setName(product.getProductName());
            productDTO.setPrice(product.getPrice());
            productDTO.setQuantity(product.getQuantity());
            productDTO.setTime(product.getRelease_date());

            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
}
