package com.wellyntonmartins.wellyntonservices.controllers;

import com.wellyntonmartins.wellyntonservices.entities.Category;
import com.wellyntonmartins.wellyntonservices.entities.Product;
import com.wellyntonmartins.wellyntonservices.services.CategoryService;
import com.wellyntonmartins.wellyntonservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Diz que e um controller
@RequestMapping(value = "/products") // Diz a rota que aciona essa classe
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
