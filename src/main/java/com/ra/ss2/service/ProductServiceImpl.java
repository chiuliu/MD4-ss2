package com.ra.ss2.service;

import com.ra.ss2.model.dto.ProductDTO;
import com.ra.ss2.model.entity.Category;
import com.ra.ss2.model.entity.Product;
import com.ra.ss2.repository.CategoryRepository;
import com.ra.ss2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {
   private final ProductRepository productRepository;
   private final UploadService uploadService;
   private final CategoryRepository categoryRepository;
   @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UploadService uploadService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.uploadService = uploadService;
       this.categoryRepository = categoryRepository;
   }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(ProductDTO productDTO, Long id) {
       String img = uploadService.uploadFile(productDTO.getImg());
       Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
       Product product = new Product();
       product.setId(id);
       product.setName(productDTO.getName());
       product.setDescription(productDTO.getDescription());
       product.setPrice(productDTO.getPrice());
       product.setImg(img);
       product.setStatus(productDTO.isStatus());
       product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
    productRepository.deleteById(id);
    }
}
