package com.example.demo.Entity.IMPL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Table(name = "staff")
public class staffEntity {
    @Id
    private String staffID;
}
