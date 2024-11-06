package com.example.demo.utill;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CropEntity toCropEntity(CropDTO cropDTO) {

        return modelMapper.map(cropDTO, CropEntity.class);
    }
    public CropDTO toCropDto(CropEntity cropEntity) {

        return modelMapper.map(cropEntity, CropDTO.class);
    }
    public List<CropDTO>asCropDtolist(List<CropEntity> cropEntity){
        return modelMapper.map(cropEntity,new TypeToken<List<CropDTO>>(){}.getType());
    }
    public FieldEntity toFieldEntity(FieldDTO fieldDTO){
        return modelMapper.map(fieldDTO, FieldEntity.class);
    }
    public FieldDTO toFieldDto(FieldEntity fieldEntity){
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public List<FieldDTO> asFieldDtoList(List<FieldEntity>fieldEntities){
        return modelMapper.map(fieldEntities,new TypeToken<List<FieldDTO>>(){}.getType());
    }
}