package com.example.demo.Service;

import com.example.demo.DTO.IMPL.fieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(fieldDTO field);
    List<fieldDTO>getAllFields();
    void getField(String fieldId);
    void deleteFields(String fieldId);
    void updateField(String fieldId,fieldDTO field);

}
