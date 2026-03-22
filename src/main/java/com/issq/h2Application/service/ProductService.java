package com.issq.h2Application.service;

import com.issq.h2Application.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(int productId);

    Product createProduct(Product product);

    List<Product> findAll();

    Product updateProduct(Product product);
}
