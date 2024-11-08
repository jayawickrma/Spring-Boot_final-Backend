package com.example.demo.Service.IMPL;

import com.example.demo.DAO.VehicleDao;
import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.DTO.VehicleStatus;
import com.example.demo.Entity.IMPL.VehicleEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.VehicleService;
import com.example.demo.util.Mapping;
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
        VehicleEntity saveVehicle =vehicleDao.save(mapping.toVehicleEntity(vehicleDTO));
            if (saveVehicle==null){
                throw new DataPersistException("Couldn't Find");
            }

    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapping.asVehicleDto(vehicleDao.findAll());
    }

    @Override
    public VehicleStatus getVehicle(String vehicleCode) {
        VehicleEntity searchVehicle =vehicleDao.getReferenceById(vehicleCode);
            return mapping.toVehicleDto(searchVehicle);
    }

    @Override
    public void deleteVehicle(String vehicleCode) {
            vehicleDao.deleteById(vehicleCode);
    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO) {

    }
}
