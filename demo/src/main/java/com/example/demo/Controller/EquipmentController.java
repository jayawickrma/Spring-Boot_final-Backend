package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.EquipmentDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.EquipmentService;
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
    public ResponseEntity<Void>saveEquipment(@RequestBody EquipmentDTO equipmentDTO){
        try {
            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{equipmentId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>deleveEquipment(@PathVariable("equipmentId")String equid){
        try{
            equipmentService.deleteEquipment(equid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDTO>getAllEquipments(){
        return equipmentService.getAllEquipments();
    }

    @PutMapping(value = "/{equipmentId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateEquipment(@PathVariable("equipmentId")String equipmentId, @RequestBody EquipmentDTO equipmentDTO){
            try {
                    equipmentService.updateEquipment(equipmentId,equipmentDTO);
                    return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
}
