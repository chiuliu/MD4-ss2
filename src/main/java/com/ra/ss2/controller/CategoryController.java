package com.ra.ss2.controller;

import com.ra.ss2.model.entity.Category;
import com.ra.ss2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
@Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> index() {
    List<Category> categories = categoryService.findAll();
    return new ResponseEntity<>(categories, HttpStatus.OK);
//    trả về đối tượng ResponseE mới, Httpstatus.ok để báo http200, yêu cầu thành công và dữ liệu đã được trả về
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
    Category categoryNew = categoryService.save(category);
    return new ResponseEntity<>(categoryNew, HttpStatus.CREATED);

//    http201, tạo mới thành công

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        Map<String, String> error = new HashMap<>();
        error.put("message", "Category not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        Category categoryUpdated = categoryService.save(category);
        return new ResponseEntity<>(categoryUpdated, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    categoryService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
    }

