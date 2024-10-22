package com.vedruna.CrudProducts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.CrudProducts.persistance.models.Product;
import com.vedruna.CrudProducts.services.ProductServiceI;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductServiceI prodMgmt;

    @GetMapping
    public List<Product> getAllProducts() {
        return prodMgmt.findAllProducts();
    }

    @GetMapping("/name/{productName}")
    public Product  getProductByName(@PathVariable String productName) {
        return prodMgmt.findByProductName(productName);
    }

    @PostMapping("/insert")
    public String postProduct(@RequestBody Product product) {
        prodMgmt.saveProduct(product);

        return "Product added";

    }

    @PutMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @RequestBody Product product) {
        prodMgmt.updateProduct(id, product);

        return "Product updated";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        prodMgmt.deleteProduct(id);

        return "Product deleted";

    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Long id) {
        return prodMgmt.findByProductId(id);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductByPrice(@PathVariable Double price) {
        return prodMgmt.findByProductPrice(price);
    }
    

}
