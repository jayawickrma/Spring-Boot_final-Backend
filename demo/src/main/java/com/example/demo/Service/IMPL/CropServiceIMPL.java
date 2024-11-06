package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Service.CropService;
import com.example.demo.utill.AppUtill;
import com.example.demo.utill.Mapping;
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
    @Override
    public void saveCrop(CropDTO cropDTO) {
            cropDTO.setCropCode(AppUtill.generateCropId());
            CropEntity saveCrop =cropDao.save(mapping.toCropEntity(cropDTO));
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return null;
    }

    @Override
    public void getCrop(String cropCode) {
       cropDao.getReferenceById(cropCode);
    }

    @Override
    public void deleteCrop(String cropCode) {
        cropDao.deleteById(cropCode);

    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {

    }
}
