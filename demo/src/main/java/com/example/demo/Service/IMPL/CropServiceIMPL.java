package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;


import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CropServiceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    FieldDao fieldDao;
    @Override
    public CropDTO saveCrop(CropDTO cropDTO) {
        CropEntity cropEntity = mapping.toCropEntity(cropDTO);
        cropEntity.setField(fieldDao.getReferenceById(cropDTO.getField_code()));
        CropEntity saveCrop =cropDao.save(cropEntity);
       if (saveCrop==null){
           throw new DataPersistException("wdfvcxagsdfv");
       }
        return cropDTO;
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
