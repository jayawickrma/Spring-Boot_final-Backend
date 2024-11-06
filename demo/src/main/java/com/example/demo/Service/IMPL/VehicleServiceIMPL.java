package com.example.demo.Service.IMPL;

import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.DTO.VehicleStatus;
import com.example.demo.Service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleService {
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {

    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return null;
    }

    @Override
    public VehicleStatus getVehicle(String vehicleCode) {
        return null;
    }

    @Override
    public void deleteVehicle(String vehicleCode) {

    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO) {

    }
}
