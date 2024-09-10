package com.victorrojas.backend_simple_angular_crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be greater than 0")
    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

}
