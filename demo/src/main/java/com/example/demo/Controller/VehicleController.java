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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PreAuthorize("hasAnyRole('MANAGER','ADMINISTRATIVE')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        System.out.println("vehicleeeeeeeeeee"+vehicleDTO);
        try {
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (
                DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasAnyRole('MANAGER','ADMINISTRATIVE')")
    @DeleteMapping(value = "/{vehicleCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
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
    @PreAuthorize("hasAnyRole('MANAGER','ADMINISTRATIVE','SCIENTIST')")
    @GetMapping("/{vehicleCode}")
    public VehicleDTO getVehicle(@PathVariable("vehicleCode")String vehicleCode){
        return vehicleService.getVehicle(vehicleCode);

    }

    @PreAuthorize("hasAnyRole('MANAGER','ADMINISTRATIVE','SCIENTIST')")
    @GetMapping
    public List<VehicleDTO>getAll(){
        return vehicleService.getAllVehicles();
    }
    @PreAuthorize("hasAnyRole('MANAGER','ADMINISTRATIVE')")
    @PutMapping(value = "/{vehicleCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
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
