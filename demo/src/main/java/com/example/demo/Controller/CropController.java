package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;
import com.example.demo.util.IdGenerate;
import com.example.demo.util.PicEncorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(@RequestPart("commonName") String cropName,
                                         @RequestPart("scientificName") String scientificName,
                                         @RequestPart("cropImage") MultipartFile cropIMg,
                                         @RequestPart("category") String category,
                                         @RequestPart("season") String season,
                                         @RequestPart("field") String field,
                                         @RequestPart("log")String log){

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
                cropDTO.setField_code(field);


            cropService.saveCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{cropCode}")
    public void deleteCrop(@PathVariable("cropCode")String cropCode){
        cropService.deleteCrop(cropCode);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDTO>getAllCrops(){
        return cropService.getAllCrops();
    }
}
