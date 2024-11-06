package com.example.demo.Service;

import com.example.demo.DTO.FieldStatus;
import com.example.demo.DTO.IMPL.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    List<FieldDTO>getAllFields();
    FieldStatus getField(String fieldId);
    void deleteFields(String fieldId);
    void updateField(String fieldId, FieldDTO fieldDTO);

}
