package com.ra.ss2.service;

import com.ra.ss2.model.dto.ProductDTO;
import com.ra.ss2.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(ProductDTO productDTO, Long id);
    void deleteById(Long id);
}
