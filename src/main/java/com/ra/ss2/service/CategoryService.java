package com.ra.ss2.service;

import com.ra.ss2.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void delete(Long id);
}
