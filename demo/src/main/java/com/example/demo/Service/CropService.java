package com.example.demo.Service;

import com.example.demo.DTO.CropStatus;
import com.example.demo.DTO.IMPL.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO>getAllCrops();
    CropStatus getCrop(String cropId);
    void deleteCrop(String cropId);
    void updateCrop(String cropId, CropDTO cropDTO);
}
