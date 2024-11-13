package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.FieldService;
import com.example.demo.util.PicEncorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
    @RequestMapping("api/v1/fields")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(@RequestPart("fieldName") String fieldName,
                                          @RequestPart("fieldLocation") String fieldLocation,
                                          @RequestPart("fieldSize") String fieldSize,
                                          @RequestPart("cropId") String cropId,
                                          @RequestPart("staffId") String staffId,
                                          @RequestPart("equipment")String euqipment,
                                          @RequestPart("fieldImg1") MultipartFile fieldImg1,
                                          @RequestPart("fieldImg2") MultipartFile fieldImg2) {
        try {

            String img1 = PicEncorder.generatePicture(fieldImg1);
            String img2 = PicEncorder.generatePicture(fieldImg2);

            FieldDTO fieldDTO = new FieldDTO();


            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

