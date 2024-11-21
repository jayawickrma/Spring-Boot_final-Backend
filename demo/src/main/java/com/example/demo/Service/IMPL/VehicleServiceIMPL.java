package com.example.demo.Service.IMPL;

import com.example.demo.DAO.StaffDao;
import com.example.demo.DAO.VehicleDao;
import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.DTO.VehicleStatus;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Entity.IMPL.VehicleEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.VehicleService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private StaffDao staffDao;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
       int number=0;
       VehicleEntity vehicle =vehicleDao.findLastRowNative();
       if (vehicle!=null){
           String [] parts =vehicle.getVehicleCode().split("-");
           number=Integer.parseInt(parts[1]);
       }
       vehicleDTO.setVehicleCode("VEHICLE-"+ ++number);
       VehicleEntity vehicleEntity =mapping.toVehicleEntity(vehicleDTO);
       StaffEntity staffEntity =staffDao.getReferenceById(vehicleDTO.getMemberCode());
       vehicleEntity.setStaff(staffEntity);
        VehicleEntity save=vehicleDao.save(vehicleEntity);
       if (save==null){
           throw new DataPersistException("Something went wrong");

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
    public void deleteVehicle(String vehicleCode){
        if (vehicleDao.existsById(vehicleCode)){
            vehicleDao.deleteById(vehicleCode);
        }else {
            throw new NotFoundException("You Entered Vehicle Code not found");
        }
    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO) {
        Optional<VehicleEntity>vehicleEntity=vehicleDao.findById(vehicleCode);
            if (vehicleEntity.isPresent()){
                vehicleEntity.get().setLicensePlateNumber(vehicleDTO.getLicensePlateNumber());
                vehicleEntity.get().setName(vehicleDTO.getName());
                vehicleEntity.get().setCategory(vehicleDTO.getCategory());
                vehicleEntity.get().setFuelType(vehicleDTO.getFuelType());
                vehicleEntity.get().setRemark(vehicleDTO.getRemark());
                vehicleEntity.get().setStatus(vehicleDTO.getStatus());

                    String sid =vehicleDTO.getMemberCode();
                    StaffEntity staffEntity =staffDao.getReferenceById(sid);
                    vehicleEntity.get().setStaff(staffEntity);
            }
    }
}
