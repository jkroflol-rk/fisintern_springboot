package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Product;
import com.example.fisintern_spring.repositories.ProductRepository;
import com.example.fisintern_spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController extends GenericController<Product, Integer>{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        super(productService, productRepository, "Product");
    }
}
