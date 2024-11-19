package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.VehicleStatus;
import com.example.demo.Entity.FuelType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements VehicleStatus {
    @Id
    private String vehicleCode;
    private String licensePlateNumber;
    private String name;
    private String category;
    private FuelType fuelType;
    private String remark;
    private String status;
    private String memberCode;
}
