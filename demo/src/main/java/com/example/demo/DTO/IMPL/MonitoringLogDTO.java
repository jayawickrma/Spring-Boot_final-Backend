package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.MonitoringLogStatus;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDTO implements MonitoringLogStatus {
   @Id
    private String logCode;
    private String logDate;
    private String logDetails;
    private String observedImage;
    private List<StaffDTO>staffList;
    private List<CropDTO> cropList;
    private List<FieldDTO> fieldList;
}
