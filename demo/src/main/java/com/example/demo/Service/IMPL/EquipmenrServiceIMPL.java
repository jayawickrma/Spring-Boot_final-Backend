package com.example.demo.Service.IMPL;

import com.example.demo.DAO.EquipmentDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.Entity.IMPL.EquipmentEntity;
import com.example.demo.Service.EquipmentService;
import com.example.demo.util.Mapping;
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
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private FieldDao fieldDao;


    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {


    }

    @Override
    public List<EquipmentDTO> getAllEquipments() {
        return mapping.asEquipmentDtoList(equipmentDao.findAll());
    }

    @Override
    public EquipmentDTO getEquipment(String equipmentId) {
            EquipmentEntity equipmentEntity =equipmentDao.getReferenceById(equipmentId);
            return mapping.toEquipmentDTO(equipmentEntity);
    }

    @Override
    public void deleteEquipment(String equipmentId) {
            equipmentDao.deleteById(equipmentId);
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO) {

    }
}
