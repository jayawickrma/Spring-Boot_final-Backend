package com.example.demo.Service.IMPL;

import com.example.demo.DAO.VehicleDao;
import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.DTO.VehicleStatus;
import com.example.demo.Service.VehicleService;
import com.example.demo.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private Mapping mapping;
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
