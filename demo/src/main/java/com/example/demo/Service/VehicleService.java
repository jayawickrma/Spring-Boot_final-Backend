package com.example.demo.Service;

import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.DTO.VehicleStatus;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicle);
    List<VehicleDTO>getAllVehicles();
    VehicleStatus getVehicle(String vehicleNumber);
    void deleteVehicle(String vehicleNumber);
    void updateVehicle(String vehicleNumber, VehicleDTO vehicle);
}
