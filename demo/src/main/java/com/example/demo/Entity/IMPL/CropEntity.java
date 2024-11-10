package com.example.demo.Entity.IMPL;

import com.example.demo.DTO.IMPL.CropDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;
}
