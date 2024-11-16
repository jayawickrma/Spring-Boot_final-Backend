package com.example.demo.Service.IMPL;

import com.example.demo.DAO.EquipmentDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.Entity.IMPL.EquipmentEntity;
import com.example.demo.Exception.DataPersistException;
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
        int number =0;
        EquipmentEntity equipmentEntity =equipmentDao.findLastRowNative();
        if (equipmentEntity!=null){
            String [] psrts =equipmentEntity.getEquipmentCode().split("-");
            number =Integer.parseInt(psrts[1]);
        }
    equipmentDTO.setEquipmentCode("E00"+ ++number);
        EquipmentEntity equipmentEntity1 =equipmentDao.save(mapping.toEquipmentEntity(equipmentDTO));
            if (equipmentEntity1==null){
                throw new DataPersistException("Something Went Wrong");
            }
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
