package com.example.csw.entity;

import lombok.*;
import javax.persistence.*;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Builder
    @Table(name = "product")
    public class ProductEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private double price;
        private int quantity;

    }

