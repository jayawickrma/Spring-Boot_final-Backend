package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.StaffService;
import com.example.demo.util.IdGenerater;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER","ADMINISTRATIVE"})
    public ResponseEntity<Void>saveStaff(@RequestBody StaffDTO staffDTO){
        try{
            System.out.println(staffDTO);
            staffService.saveStaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value = "/{memberCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER","ADMINISTRATIVE"})
    public ResponseEntity<Void>deleteStaffMember(@PathVariable("memberCode")String member){
        try {
            staffService.deleteStaff(member);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{memberCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER","ADMINISTRATIVE"})
    public ResponseEntity<Void>updateMember(@PathVariable("memberCode")String memberCode,@RequestBody StaffDTO staffDTO){
        try {
            staffService.UpdateStaff(memberCode,staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
        @RolesAllowed({"MANAGER","ADMINISTRATIVE","SCIENTIST"})

    public List<StaffDTO>getAll(){
        return staffService.getAllStaff();
    }
}
