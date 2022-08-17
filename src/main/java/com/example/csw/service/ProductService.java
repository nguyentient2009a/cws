package com.example.csw.service;

import com.example.csw.entity.ProductEntity;
import com.example.csw.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity addProduct(ProductEntity p) {
        return productRepository.save(p);
    }

    public ProductEntity sellProduct(ProductEntity product) {
        return productRepository.save(product);
    }
}
