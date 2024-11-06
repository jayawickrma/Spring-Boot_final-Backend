package com.example.demo.Entity.IMPL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vahicle")
public class VehicleEntity {
    @Id
    private String vNumber;
}
