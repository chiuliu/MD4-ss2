package com.ra.ss2.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name", length = 100, nullable = false, unique = true)
    private String name;
    @Column(name = "product_img")
    private String img;
    @Column(name = "price")
    private double price;
    @Column(name="description")
    private String description;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;
}
