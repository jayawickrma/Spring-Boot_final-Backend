package com.example.demo.Entity.IMPL;

import jakarta.persistence.*;

import java.awt.*;
import java.util.List;

@Entity
@Table(name = "field")
public class FieldEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extentSizeOfTheField;

    @OneToMany(mappedBy = "cropCode")
    private java.util.List<CropEntity> crops;

    @OneToMany(mappedBy = "staffId")
    private List<StaffEntity> staff;

    @Lob
    private String fieldImage1;
    @Lob
    private String fieldImage2;
}
