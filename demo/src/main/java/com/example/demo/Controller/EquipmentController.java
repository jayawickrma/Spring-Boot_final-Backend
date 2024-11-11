package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.Entity.EquipmentStatus;
import com.example.demo.Entity.EquipmentType;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.EquipmentService;
import com.example.demo.util.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveEquipment(@RequestPart("equipmentName")String equipmentName,
                                             @RequestPart("equipmentType")String equipmentType,
                                             @RequestPart("equipmentStatus")String equipmentStatus,
                                             @RequestPart("staff")String staff,
                                             @RequestPart("field")String field){
        try {
            String equipmentID = IdGenerate.generateEquipmentID();
            EquipmentDTO equipmentDTO =new EquipmentDTO();
                equipmentDTO.setEquipmentId(equipmentID);
                equipmentDTO.setEquipmentName(equipmentName);
                equipmentDTO.setEquipmentType(equipmentType);
                equipmentDTO.setEquipmentStatus(equipmentStatus);
                equipmentDTO.setAssignedStaffDetails(staff);
                equipmentDTO.setAssignedFieldDetails(field);

            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDTO>getAllEquipments(){
        return equipmentService.getAllEquipments();
    }
}
