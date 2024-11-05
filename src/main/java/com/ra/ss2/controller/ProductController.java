package com.ra.ss2.controller;

import com.ra.ss2.model.dto.ProductDTO;
import com.ra.ss2.model.entity.Category;
import com.ra.ss2.model.entity.Product;
import com.ra.ss2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>>index() {

    List<Product> products = productService.findAll();
    return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@ModelAttribute ProductDTO productDTO) {
        Product productNew = productService.save(productDTO,null);
        return new ResponseEntity<>(productNew, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @ModelAttribute ProductDTO productDTO) {
        Product productUpdate = productService.save(productDTO,id);
        return new ResponseEntity<>(productUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Product> delete(@PathVariable Long id, @ModelAttribute ProductDTO productDTO){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
