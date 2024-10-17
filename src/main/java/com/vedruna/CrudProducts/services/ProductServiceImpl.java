package com.vedruna.CrudProducts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.CrudProducts.persistance.models.Product;
import com.vedruna.CrudProducts.persistance.repository.ProductRepositoryI;

@Service
public class ProductServiceImpl implements ProductServiceI {

    @Autowired
    ProductRepositoryI productRepo;

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();    
    }

    @Override
    public Product findByProductId(Long id) {
        return productRepo.findByProductId(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);    
    }

    @Override
    public void updateProduct(Long id, Product product) {
        product.setProductId(id);
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findByProductName(String name) {
        return productRepo.findByProductName(name);
    }

    @Override
    public List<Product> findByProductPrice(Double price) {
        return productRepo.findByProductPrice(price);
    }
    
}
