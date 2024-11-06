package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DTO.CropStatus;
import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.Service.CropService;
import com.example.demo.utill.AppUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CropServiceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;
    @Override
    public void saveCrop(CropDTO cropDTO) {
            cropDTO.setCropCode(AppUtill.generateCropId());

    }

    @Override
    public List<CropDTO> getAllCrops() {
        return null;
    }

    @Override
    public CropStatus getCrop(String cropCode) {
        return null;
    }

    @Override
    public void deleteCrop(String cropCode) {

    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {

    }
}
