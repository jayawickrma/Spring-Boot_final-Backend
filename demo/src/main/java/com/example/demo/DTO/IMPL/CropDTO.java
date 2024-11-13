package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.CropStatus;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus {
   @Id
   private String cropCode;
   private String cropName;
   private String scientificName;
   private String category;
   private String season;
   private String cropImage;
   @JsonIgnore
    private List<MonitoringLogDTO>logList;
   @JsonIgnore
   private List<FieldDTO> fieldList;
}
