package com.vedruna.CrudProducts.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.CrudProducts.persistance.models.Product;

public interface ProductRepositoryI extends JpaRepository<Product,Long> {

    Product findByProductName(String name);
    List<Product> findByProductPrice(Double price);
    Product findByProductId(Long id);
    
}
