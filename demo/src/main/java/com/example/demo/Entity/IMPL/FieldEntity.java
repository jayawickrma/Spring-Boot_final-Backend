package com.example.demo.Entity.IMPL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String extentSizeOfTheField;

    @OneToMany(mappedBy = "field")
    private List<CropEntity> crops;

    @OneToMany(mappedBy = "field")
    private List<StaffEntity> staff;

    @OneToMany(mappedBy = "assignedFieldDetails")
    private List<EquipmentEntity>equipments;

    @Lob
    private String fieldImage1;
    @Lob
    private String fieldImage2;
}
