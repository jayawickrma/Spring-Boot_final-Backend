package com.example.demo.Service;

import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.DTO.VehicleStatus;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO>getAllVehicles();
    VehicleStatus getVehicle(String vehicleCode);
    void deleteVehicle(String vehicleCode);
    void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO);
}
