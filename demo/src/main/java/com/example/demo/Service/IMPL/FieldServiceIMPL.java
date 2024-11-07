package com.example.demo.Service.IMPL;

import com.example.demo.DAO.FieldDao;
import com.example.demo.DTO.FieldStatus;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.FieldService;

import com.example.demo.utill.AppUtil;
import com.example.demo.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveField(FieldDTO fieldDTO) {
            fieldDTO.setFieldCode(AppUtil.generateFieldId());
            FieldEntity saveField =fieldDao.save(mapping.toFieldEntity(fieldDTO));
                if (saveField==null){
                    throw new DataPersistException("Field Not Saved");
                }
    }

    @Override
    public List<FieldDTO> getAllFields() {
        return mapping.asFieldDtoList(fieldDao.findAll());
    }

    @Override
    public FieldStatus getField(String fieldCode) {
        return null;
    }

    @Override
    public void deleteFields(String fieldCode) {
        fieldDao.deleteById(fieldCode);
    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
