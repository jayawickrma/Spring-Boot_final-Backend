package com.example.demo.Service;

import com.example.demo.DTO.CropStatus;
import com.example.demo.DTO.IMPL.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO>getAllCrops();
    CropStatus getCrop(String cropCode);
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode, CropDTO cropDTO);
}
