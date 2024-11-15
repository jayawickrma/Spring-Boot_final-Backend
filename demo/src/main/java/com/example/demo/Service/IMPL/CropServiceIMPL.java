package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;


import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CropServiceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private MonitoringLogDao monitoringLogDao;

    @Override
    public void saveCrop(CropDTO cropDTO) {
        int number =0;
        CropEntity crop =cropDao.findLastRowNative();
            if (crop != null){
                String [] parts =crop.getCropCode().split("-");
                number =Integer.parseInt(parts[1]);
            }
            cropDTO.setCropCode("C00"+ ++number);
            CropEntity cropEntity =mapping.toCropEntity(cropDTO);
            List<FieldEntity>fieldEntities =new ArrayList<>();
                for (FieldDTO fieldDTO: cropDTO.getFieldList()){
                    if (fieldDao.existsById(fieldDTO.getFieldCode())){
                        fieldEntities.add(fieldDao.getReferenceById(fieldDTO.getFieldCode()));
                    }
                }
            cropEntity.setFieldList(fieldEntities);
                for (FieldEntity fieldEntity:fieldEntities){
                    fieldEntity.getCropList().add(cropEntity);
                }

                List<LogEntity>logEntities=new ArrayList<>();
                for(MonitoringLogDTO monitoringLogDTO:cropDTO.getLogList()){
                    if (monitoringLogDao.existsById(monitoringLogDTO.getLogCode())){
                        logEntities.add(monitoringLogDao.getReferenceById(monitoringLogDTO.getLogCode()));
                    }
                }
                cropEntity.setLogList(logEntities);
                for (LogEntity logEntity : logEntities){
                    logEntity.getCropList().add(cropEntity);
                }
                cropDao.save(cropEntity);
                if (cropEntity==null){
                    throw new DataPersistException("Crop ID not found!");
                }
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return mapping.asCropDtolist(cropDao.findAll());
    }

    @Override
    public CropDTO getCrop(String cropCode) {

            CropEntity selectCrop = cropDao.getReferenceById(cropCode);
            return mapping.toCropDto(selectCrop);
        }


    @Override
    public void deleteCrop(String cropCode) {
        cropDao.deleteById(cropCode);


    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {

    }
}
