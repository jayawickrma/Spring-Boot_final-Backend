package com.example.demo.Service.IMPL;

import com.example.demo.DTO.FieldStatus;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Service.FieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {
    @Override
    public void saveField(FieldDTO fieldDTO) {

    }

    @Override
    public List<FieldDTO> getAllFields() {
        return null;
    }

    @Override
    public FieldStatus getField(String fieldCode) {
        return null;
    }

    @Override
    public void deleteFields(String fieldCode) {

    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
