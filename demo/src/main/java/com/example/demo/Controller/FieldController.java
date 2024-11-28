package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.FieldService;
import com.example.demo.util.IdGenerater;
import com.example.demo.util.PicEncorder;
import com.example.demo.util.SplitString;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/fields")
@CrossOrigin
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER"})
    public ResponseEntity<Void> saveField(@RequestPart("fieldName") String fieldName,
                                          @RequestPart("fieldLocation") String fieldLocation,
                                          @RequestPart("fieldSize") String fieldSize,
                                          @RequestPart("fieldImg1") MultipartFile fieldImg1,
                                          @RequestPart("fieldImg2") MultipartFile fieldImg2,
                                          @RequestPart("cropId")String cropList,
                                          @RequestPart("staffId")String staffList ){
        try {

            String img1 = PicEncorder.generatePicture(fieldImg1);
            String img2 = PicEncorder.generatePicture(fieldImg2);
            List<String>cropEntities=new ArrayList<>();
            List<String>staffEntities=new ArrayList<>();


            if (cropList!= null) {
                cropEntities = SplitString.spiltLists(cropList);
            }
            if (staffList!=null){
                staffEntities=SplitString.spiltLists(staffList);
            }


            FieldDTO fieldDTO = new FieldDTO();
                fieldDTO.setFieldCode(IdGenerater.generateId("FIELD-"));
                fieldDTO.setName(fieldName);
                fieldDTO.setLocation(fieldLocation);
                fieldDTO.setExtentSize(Double.parseDouble(fieldSize));
                fieldDTO.setFieldImage1(img1);
                fieldDTO.setFieldImage2(img2);
                fieldDTO.setCropsList(cropEntities);
                fieldDTO.setStaffList(staffEntities);

//            System.out.println(fieldDTO);

            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{fieldCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"MANAGER"})
    public ResponseEntity<Void>deleteField(@PathVariable("fieldCode")String fieldCode){
        try{
            fieldService.deleteFields(fieldCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value = "/{fieldCode}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @RolesAllowed({"MANAGER"})
    public ResponseEntity<Void> updateField(@PathVariable("fieldCode")String fieldCode,
                            @RequestPart("fieldName") String fieldName,
                            @RequestPart("fieldLocation") String fieldLocation,
                            @RequestPart("fieldSize") String fieldSize,
                            @RequestPart("fieldImg1") MultipartFile fieldImg1,
                            @RequestPart("fieldImg2") MultipartFile fieldImg2,
                            @RequestPart("cropId")String cropList,
                            @RequestPart("staffId")String staffList){
        try {

            String fieldImage1 = PicEncorder.generatePicture(fieldImg1);
            String fieldImage2 = PicEncorder.generatePicture(fieldImg2);

            List<String> crop_codes = new ArrayList<>();
            List<String> staff_codes = new ArrayList<>();
            if (cropList != null) {
                crop_codes = SplitString.spiltLists(cropList);
            }
            if (staffList != null) {
                staff_codes = SplitString.spiltLists(staffList);
            }
            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(fieldCode);
            fieldDTO.setName(fieldName);
            fieldDTO.setLocation(fieldLocation);
            fieldDTO.setExtentSize(Double.parseDouble(fieldSize));
            fieldDTO.setFieldImage1(fieldImage1);
            fieldDTO.setFieldImage2(fieldImage2);
            fieldDTO.setCropsList(crop_codes);
            fieldDTO.setStaffList(staff_codes);

                fieldService.updateField(fieldCode,fieldDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
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
    public List<FieldDTO>getall(){
        try {
          return   fieldService.getAllFields();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

