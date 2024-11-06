package com.example.demo.DTO.IMPL;

import com.example.demo.Entity.EquipmentStatus;
import com.example.demo.Entity.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO {
    private String equipmentId;
    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;
    private String assignedStaffDetails;
    private String assignedFieldDetails;
}
