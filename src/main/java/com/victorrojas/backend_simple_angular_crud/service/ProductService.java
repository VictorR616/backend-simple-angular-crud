package com.victorrojas.backend_simple_angular_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorrojas.backend_simple_angular_crud.exception.ResourceNotFoundException;
import com.victorrojas.backend_simple_angular_crud.model.Product;
import com.victorrojas.backend_simple_angular_crud.repository.IProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found", id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productToUpdate = this.getProductById(id);

        if (productToUpdate == null) {
            throw new ResourceNotFoundException("Product not found", id);
        }

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());

        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }

        return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found", id);
        }

        productRepository.deleteById(id);
    }

}
