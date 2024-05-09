package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Product;
import com.example.fisintern_spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, Integer>{

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }
}
