package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestPart("code") String vehicleCode,
                                            @RequestPart("number") String vehicleNumber,
                                            @RequestPart("category") String vehicleCategory,
                                            @RequestPart("FuelType") String fuelType,
                                            @RequestPart("status") String vehicleStatus,
                                            @RequestPart("staff") String staff,
                                            @RequestPart("remarks") String remark) {
        try {
            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setVehicleCode(vehicleCode);
            vehicleDTO.setLicensePlateNumber(vehicleNumber);
            vehicleDTO.setVehicleCategory(vehicleCategory);
            vehicleDTO.setFuelType(fuelType);
            vehicleDTO.setStatus(vehicleStatus);
            vehicleDTO.setAllocatedStaffMemberDetails(staff);
            vehicleDTO.setRemarks(remark);

            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (
                DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
