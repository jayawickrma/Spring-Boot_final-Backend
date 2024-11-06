package com.example.demo.Entity.IMPL;

import jakarta.persistence.*;

@Entity
@Table(name = "crop")
public class CropEntity {
    @Id
    private String cropCode;

    private String cropCommonName;
    private String cropScientificName;

    @Lob
    private String cropImage;

    private String category;
    private String cropSeason;

    @ManyToOne
    @JoinColumn(name = "crop_field")
    private FieldEntity field;
}