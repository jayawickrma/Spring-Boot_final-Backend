package com.example.demo.Service.IMPL;

import com.example.demo.DAO.FieldDao;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.FieldService;

import com.example.demo.util.IdGenerate;
import com.example.demo.util.Mapping;
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
            fieldDTO.setFieldCode(IdGenerate.generateFieldId());
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
    public FieldDTO getField(String fieldCode) {
        FieldEntity fieldEntity =fieldDao.getReferenceById(fieldCode);
            return mapping.toFieldDto(fieldEntity);
    }

    @Override
    public void deleteFields(String fieldCode) {
        fieldDao.deleteById(fieldCode);
    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
