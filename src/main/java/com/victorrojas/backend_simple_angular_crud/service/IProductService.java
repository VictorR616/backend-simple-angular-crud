package com.victorrojas.backend_simple_angular_crud.service;

import java.util.List;

import com.victorrojas.backend_simple_angular_crud.model.Product;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
