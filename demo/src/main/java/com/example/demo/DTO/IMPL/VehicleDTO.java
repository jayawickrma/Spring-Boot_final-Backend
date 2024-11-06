package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements VehicleStatus {
    private String vehicleCode;
    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private String allocatedStaffMemberDetails;
    private String remarks;
}
