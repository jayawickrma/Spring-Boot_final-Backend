package com.example.demo.Service.IMPL;

import com.example.demo.DAO.EquipmentDao;
import com.example.demo.DTO.EquipmentStatus;
import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.Entity.IMPL.EquipmentEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.EquipmentService;
import com.example.demo.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EquipmenrServiceIMPL implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        EquipmentEntity saveEquipment =equipmentDao.save(mapping.toEquipmentEntity(equipmentDTO));
            if (saveEquipment==null){
                throw new DataPersistException("Equipment Not Found");
            }
    }

    @Override
    public List<EquipmentDTO> getAllEquipments() {
        return null;
    }

    @Override
    public EquipmentStatus getEquipment(String equipmentId) {
        return null;
    }

    @Override
    public void deleteEquipment(String equipmentId) {

    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO) {

    }
}
