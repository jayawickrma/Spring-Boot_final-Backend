package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Exception.DataPersistException;
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
    private MonitoringLogDao monitoringLogDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveField(FieldDTO fieldDTO) {
            int number=0;
            FieldEntity field=fieldDao.findLastRowNative();
             FieldEntity fieldEntity =mapping.toFieldEntity(fieldDTO);
                if(field!=null){
                    String [] parts=field.getFieldCode().split("-");
                    number=Integer.parseInt(parts[1]);
                }
                fieldDTO.setFieldCode("F00-"+ ++number);

                     List<StaffEntity>staffEntities =new ArrayList<>();
                         for (String memberCode :fieldDTO.getStaffList()){
                             if (staffDao.existsById(memberCode)){
                            staffEntities.add(staffDao.getReferenceById(memberCode));
                        }
                    }
                    List<LogEntity>logEntities=new ArrayList<>();
                        for (String logCode : fieldDTO.getLogsList()){
                            if (monitoringLogDao.existsById(logCode)){
                                logEntities.add(monitoringLogDao.getReferenceById(logCode));
                            }
                        }


                    fieldEntity.setStaffList(staffEntities);
                    fieldEntity.setLogList(logEntities);
                        FieldEntity field1 =fieldDao.save(fieldEntity);
                            if (field1==null){
                                throw new DataPersistException("Something went wrong");
                            }


    }


    @Override
    public List<FieldDTO> getAllFields() {
        return mapping.asFieldDtoList(fieldDao.findAll());
    }

    @Override
    public FieldDTO getField(String fieldCode) {
        FieldEntity fieldEntity =fieldDao.getReferenceById(fieldCode);
            return mapping.toFieldDto(fieldEntity);
    }

    @Override
    public void deleteFields(String fieldCode) {
        fieldDao.deleteById(fieldCode);
    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
