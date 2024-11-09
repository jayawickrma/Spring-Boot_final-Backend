package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;


import com.example.demo.util.IdGenerate;
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
        FieldEntity fieldEntity = fieldDao.findByFieldCode(cropDTO.getField());

        // Create CropEntity from CropDTO
        CropEntity cropEntity = new CropEntity();
        cropEntity.setCropCode(cropDTO.getCropCode());
        cropEntity.setCropCommonName(cropDTO.getCropCommonName());
        cropEntity.setCropScientificName(cropDTO.getCropScientificName());
        cropEntity.setCropImage(cropDTO.getCropImage()); // Base64 encoded image
        cropEntity.setCategory(cropDTO.getCategory());
        cropEntity.setCropSeason(cropDTO.getCropSeason());
        cropEntity.setField(fieldEntity);


        cropDao.save(cropEntity);
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
