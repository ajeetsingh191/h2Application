package com.issq.h2Application.controller;

import com.issq.h2Application.model.Product;
import com.issq.h2Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    ResponseEntity<?> getAllProducts()
    {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    ResponseEntity<?> getById(@PathVariable int productId)
    {
        return new ResponseEntity<>(productService.findById(productId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
}
