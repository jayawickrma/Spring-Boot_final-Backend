package com.example.demo.util;

import com.example.demo.DTO.IMPL.*;
import com.example.demo.Entity.IMPL.*;
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
        CropEntity map = modelMapper.map(cropDTO, CropEntity.class);
             return map;
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




    public LogEntity toMonitoringLogEntity(MonitoringLogDTO monitoringLogDTO){
        return modelMapper.map(monitoringLogDTO, LogEntity.class);
    }

    public MonitoringLogDTO toMonitoringLogDto(LogEntity monitoringLog){
       return modelMapper.map(monitoringLog, MonitoringLogDTO.class);
    }
    public List<MonitoringLogDTO>asMonitoringDtoList(List<LogEntity>monitoringLogEntities){
        return modelMapper.map(monitoringLogEntities,new TypeToken<List<MonitoringLogDTO>>(){}.getType());
    }




    public StaffEntity toStaffEntity(StaffDTO staffDTO){
        return modelMapper.map(staffDTO, StaffEntity.class);
    }
    public StaffDTO toStaffDto(StaffEntity staffEntity){
        return modelMapper.map(staffEntity, StaffDTO.class);
    }
    public List<StaffDTO>asStafDtoList(List<StaffEntity>staffEntities){
        return modelMapper.map(staffEntities,new TypeToken<List<StaffDTO>>(){}.getType());
    }




    public VehicleEntity toVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }
    public VehicleDTO toVehicleDto(VehicleEntity vehicleEntity){
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
    public List<VehicleDTO>asVehicleDto(List<VehicleEntity>vehicleEntities){
        return modelMapper.map(vehicleEntities,new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
