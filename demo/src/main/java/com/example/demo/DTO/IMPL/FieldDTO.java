package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.FieldStatus;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements FieldStatus {
    @Id
    private String fieldCode;
    private String name;
    private String location;
    private Double extentSize;
    private String fieldImage1;
    private String fieldImage2;
    private List<EquipmentDTO> equipmentsList;
    private List<StaffDTO> staffList;
    private List<CropDTO> cropsList;
    private List<MonitoringLogDTO> logsList;

}
