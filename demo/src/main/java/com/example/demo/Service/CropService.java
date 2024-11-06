package com.example.demo.Service;

import com.example.demo.DTO.CropStatus;
import com.example.demo.DTO.IMPL.cropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(cropDTO crop);
    List<cropDTO>getAllCrops();
    CropStatus getCrop(String cropId);
    void deleteCrop(String cropId);
    void updateCrop(String cropId,cropDTO crop);
}
