package com.example.demo.Service;

import com.example.demo.DTO.EquipmentStatus;
import com.example.demo.DTO.IMPL.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    List<EquipmentDTO> getAllEquipments();
    EquipmentDTO getEquipment(String equipmentId);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId,EquipmentDTO equipmentDTO);
}
