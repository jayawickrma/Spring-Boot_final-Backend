package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.VehicleService;
import com.example.demo.util.IdGenerater;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER"})
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (
                DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{vehicleCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER"})
    public ResponseEntity<Void>deleteVehicle(@PathVariable("vehicleCode")String vehicle){
        try {
            vehicleService.deleteVehicle(vehicle);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    @RolesAllowed({"MANAGER","ADMINISTRATIVE","SCIENTIST"})
    public List<VehicleDTO>getAll(){
        return vehicleService.getAllVehicles();
    }
    @PutMapping(value = "/{vehicleCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER"})
    public ResponseEntity<Void>updateVehicle(@PathVariable("vehicleCode")String vehicleCode,@RequestBody VehicleDTO vehicleDTO){
        try {
            vehicleService.updateVehicle(vehicleCode,vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
