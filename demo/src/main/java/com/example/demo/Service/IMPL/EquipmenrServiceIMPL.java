package com.example.demo.Service.IMPL;

import com.example.demo.DAO.EquipmentDao;
import com.example.demo.DTO.EquipmentStatus;
import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.Entity.IMPL.EquipmentEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.EquipmentService;
import com.example.demo.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class EquipmenrServiceIMPL implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        EquipmentEntity saveEqu =equipmentDao.save(mapping.toEquipmentEntity(equipmentDTO));
        if (saveEqu==null){
            throw new DataPersistException("Equipment Not Found");
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipments() {
        return mapping.asEquipmentDtoList(equipmentDao.findAll());
    }

    @Override
    public EquipmentDTO getEquipment(String equipmentId) {
        EquipmentEntity search =equipmentDao.getReferenceById(equipmentId);
        return mapping.toEquipmentDTO(search);
    }

    @Override
    public void deleteEquipment(String equipmentId) {
            equipmentDao.deleteById(equipmentId);
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO) {

    }
}
