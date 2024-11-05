package com.ra.ss2.model.dto;

import com.ra.ss2.model.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductDTO {
   private Long id;
   private String name;
   private MultipartFile img;
   private String description;
   private double price;
   private Long categoryId;
   private boolean status;
}
