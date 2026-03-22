package com.issq.h2Application.service.impl;

import com.issq.h2Application.model.Product;
import com.issq.h2Application.repo.ProductRepo;
import com.issq.h2Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int productId) {
        return productRepo.findById(productId).orElseThrow(()-> new RuntimeException("Product does not found with ProductId: "+productId));
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

}
