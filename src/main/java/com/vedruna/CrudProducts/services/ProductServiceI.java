package com.vedruna.CrudProducts.services;

import java.util.List;

import com.vedruna.CrudProducts.persistance.models.Product;

public interface ProductServiceI {
    List<Product> findAllProducts();
    Product findByProductName(String name);
    void saveProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);

// Extra
    Product findByProductId(Long id);
    List<Product> findByProductPrice(Double price);
}
