package com.example.demo.Service;

import com.example.demo.DTO.EquipmentStatus;
import com.example.demo.DTO.IMPL.EquipmentDTO;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    List<EquipmentDTO>getAllEquipments();
    EquipmentStatus getEquipment(String equipmentId);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId,EquipmentDTO equipmentDTO);
}
