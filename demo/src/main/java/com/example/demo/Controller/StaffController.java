package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.IMPL.VehicleDTO;
import com.example.demo.Entity.Gender;
import com.example.demo.Entity.Role;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.StaffService;
import com.example.demo.util.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveStaff(@RequestPart("firstName")String firstName,
                                         @RequestPart("lastName")String lastName,
                                         @RequestPart("designation")String designation,
                                         @RequestPart("gender")String gender,
                                         @RequestPart("joinedDate")String joinedDate,
                                         @RequestPart("dob")String dob,
                                         @RequestPart("address1")String address1,
                                         @RequestPart("address2")String address2,
                                         @RequestPart("address3")String address3,
                                         @RequestPart("address4")String address4,
                                         @RequestPart("address5")String address5,
                                         @RequestPart("contact")String contactNumber,
                                         @RequestPart("email")String email,
                                         @RequestPart("role")String role,
                                         @RequestPart("field")String field,
                                         @RequestPart("vehicle")String vehicle){
        try{
            String id= IdGenerate.generateStaffId();
            StaffDTO staffDTO=new StaffDTO();
                staffDTO.setId(id);
                staffDTO.setFirstName(firstName);
                staffDTO.setLastName(lastName);
                staffDTO.setDesignation(designation);
                staffDTO.setGender(gender);
                staffDTO.setJoinedDate(joinedDate);
                staffDTO.setDob(dob);
                staffDTO.setAddressLine01(address1);
                staffDTO.setAddressLine02(address2);
                staffDTO.setAddressLine03(address3);
                staffDTO.setAddressLine04(address4);
                staffDTO.setAddressLine05(address5);
                staffDTO.setContactNumber(contactNumber);
                staffDTO.setEmail(email);
                staffDTO.setRole(role);
                staffDTO.setField(field);
                staffDTO.setVehicle(vehicle);

            staffService.saveStaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
