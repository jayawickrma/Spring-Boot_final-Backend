package com.example.demo.DTO.IMPL;

import com.example.demo.Entity.EquipmentStatus;
import com.example.demo.Entity.EquipmentType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO {
   @Id
    private String equipmentCode;
   private String name;
   private String type;
   private String status;
   private int availableCount;
   private List<staffDetailsDto> staffEquipmentDetailsList;
   private List<String> fieldList;
}
