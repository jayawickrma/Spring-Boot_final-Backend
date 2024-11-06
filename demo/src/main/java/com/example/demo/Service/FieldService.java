package com.example.demo.Service;

import com.example.demo.DTO.FieldStatus;
import com.example.demo.DTO.IMPL.fieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(fieldDTO field);
    List<fieldDTO>getAllFields();
    FieldStatus getField(String fieldId);
    void deleteFields(String fieldId);
    void updateField(String fieldId,fieldDTO field);

}
