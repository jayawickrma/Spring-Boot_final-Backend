package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.FieldService;

import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private MonitoringLogDao monitoringLogDao;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        int number = 0;
        FieldEntity field = fieldDao.findLastRowNative();
        if (field != null) {
            String[] parts = field.getFieldCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
        fieldDTO.setFieldCode("FIELD-" + ++number);
        FieldEntity fieldEntity = mapping.toFieldEntity(fieldDTO);

        List<StaffEntity> staffEntities = new ArrayList<>();
        for (String memberCode : fieldDTO.getStaffList()) {
            if (staffDao.existsById(memberCode)) {
                staffEntities.add(staffDao.getReferenceById(memberCode));
            }
        }
        List<CropEntity>cropEntities=new ArrayList<>();
        for (String cropCode :fieldDTO.getCropsList()){
            if (cropDao.existsById(cropCode)){
                cropEntities.add(cropDao.getReferenceById(cropCode));
            }
        }
        List<LogEntity>logEntities =new ArrayList<>();
        for (String logCode : fieldDTO.getLogsList()){
            if (monitoringLogDao.existsById(logCode)){
                logEntities.add(monitoringLogDao.getReferenceById(logCode));
            }
        }

        fieldEntity.setStaffList(staffEntities);
        fieldEntity.setCropList(cropEntities);
        fieldEntity.setLogList(logEntities);

        FieldEntity field1 = fieldDao.save(fieldEntity);
        if (field1 == null) {
            throw new DataPersistException("Something went wrong");
        }


    }


    @Override
    public List<FieldDTO> getAllFields() {
        return mapping.asFieldDtoList(fieldDao.findAll());
    }

    @Override
    public FieldDTO getField(String fieldCode) {
        FieldEntity fieldEntity = fieldDao.getReferenceById(fieldCode);
        return mapping.toFieldDto(fieldEntity);
    }

    @Override
    public void deleteFields(String fieldCode) {
        if (fieldDao.existsById(fieldCode)){
            FieldEntity field =fieldDao.getReferenceById(fieldCode);
            List<CropEntity>cropEntities=field.getCropList();
            List<StaffEntity>staffEntities=field.getStaffList();
            List<LogEntity>logEntities=field.getLogList();

            for (CropEntity crop :cropEntities){
                List<FieldEntity>fieldEntities=crop.getFieldList();
                fieldEntities.remove(field);
            }
            for (LogEntity logEntity:logEntities){
                List<FieldEntity>fieldEntities=logEntity.getFieldList();
                fieldEntities.remove(field);
            }
            for (StaffEntity staffEntity:staffEntities){
                List<FieldEntity>fieldEntities=staffEntity.getFieldList();
                fieldEntities.remove(field);
            }
            field.getLogList().clear();
            field.getStaffList().clear();
            field.getCropList().clear();
            fieldDao.delete(field);
        }else {
            throw new NotFoundException("You entered Field ID not found");
        }
    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
