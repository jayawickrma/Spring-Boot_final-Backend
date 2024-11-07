package com.example.demo.utill;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.EquipmentEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.MonitoringLogEntity;
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






    public EquipmentEntity toEquipmentEntity(EquipmentDTO equipmentDTO){
        return modelMapper.map(equipmentDTO, EquipmentEntity.class);
    }
    public EquipmentDTO toEquipmentDTO(EquipmentEntity equipmentEntity){
        return modelMapper.map(equipmentEntity, EquipmentDTO.class);
    }
    public List<EquipmentDTO> asEquipmentDtoList(List<EquipmentEntity>equipmentEntities){
        return modelMapper.map(equipmentEntities,new TypeToken<List<EquipmentDTO>>(){}.getType());
    }




    public MonitoringLogEntity toMonitoringLogEntity(MonitoringLogDTO monitoringLogDTO){
        return modelMapper.map(monitoringLogDTO, MonitoringLogEntity.class);
    }

    public MonitoringLogDTO toMonitoringLogDto(MonitoringLogEntity monitoringLog){
       return modelMapper.map(monitoringLog, MonitoringLogDTO.class);
    }
    public List<MonitoringLogDTO>asMonitoringDtoList(List<MonitoringLogEntity>monitoringLogEntities){
        return modelMapper.map(monitoringLogEntities,new TypeToken<List<MonitoringLogDTO>>(){}.getType());
    }
}
