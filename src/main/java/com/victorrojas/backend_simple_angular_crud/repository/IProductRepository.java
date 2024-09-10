package com.victorrojas.backend_simple_angular_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victorrojas.backend_simple_angular_crud.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
