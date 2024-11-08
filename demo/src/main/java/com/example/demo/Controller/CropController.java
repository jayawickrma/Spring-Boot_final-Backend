package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;
import com.example.demo.utill.IdGenerate;
import com.example.demo.utill.PicEncorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(@RequestPart("cropName") String cropName,
                                         @RequestPart("cropScientificName") String scientificName,
                                         @RequestPart("cropImage") MultipartFile cropIMg,
                                         @RequestPart("category") String category,
                                         @RequestPart("cropSeason") String season,
                                         @RequestPart("field") String field) {

        try {
            String CropId = IdGenerate.generateCropId();
            String cropIMG = PicEncorder.generateProfilePicToBase64(cropIMg);
            CropDTO cropDTO = new CropDTO();
            cropDTO.setCropCode(CropId);
            cropDTO.setCropCommonName(cropName);
            cropDTO.setCropScientificName(scientificName);
            cropDTO.setCropImage(cropIMG);
            cropDTO.setCategory(category);
            cropDTO.setCropSeason(season);
            cropDTO.setField(field);

            cropService.saveCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
