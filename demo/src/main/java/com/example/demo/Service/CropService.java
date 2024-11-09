package com.example.demo.Service;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.FieldDTO;

import java.util.List;

public interface CropService {
    CropDTO saveCrop(CropDTO cropDTO);
    List<CropDTO>getAllCrops();
    CropDTO getCrop(String cropCode);
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode, CropDTO cropDTO);
}
