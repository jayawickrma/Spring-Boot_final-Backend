package com.example.demo.Entity.IMPL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crop")
public class cropEntity {
    @Id
    private String cropId;
}
