package com.example.clouddemo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;
}