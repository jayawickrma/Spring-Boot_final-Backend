package com.example.demo.Service;

import com.example.demo.DTO.IMPL.vehicleDTO;
import com.example.demo.DTO.VehicleStatus;

import java.util.List;

public interface VehicleService {
    void saveVehicle(vehicleDTO vehicle);
    List<vehicleDTO>getAllVehicles();
    VehicleStatus getVehicle(String vehicleNumber);
    void deleteVehicle(String vehicleNumber);
    void updateVehicle(String vehicleNumber,vehicleDTO vehicle);
}
