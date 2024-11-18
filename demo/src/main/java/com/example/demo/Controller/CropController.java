package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.CropDTO;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.CropService;
import com.example.demo.util.IdGenerater;
import com.example.demo.util.PicEncorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(@RequestPart("commonName") String cropName,
                                         @RequestPart("scientificName") String scientificName,
                                         @RequestPart("category") String category,
                                         @RequestPart("season") String season,
                                         @RequestPart("cropImage") MultipartFile cropIMg,
                                         @RequestPart("field") List<String> field,
                                         @RequestPart("log")List<String>log)
                                         {

        try {
            String cropIMG = PicEncorder.generatePicture(cropIMg);

            CropDTO cropDTO = new CropDTO();
                cropDTO.setCropCode(IdGenerater.generateId("C00"));
                cropDTO.setCropName(cropName);
                cropDTO.setScientificName(scientificName);
                cropDTO.setCategory(category);
                cropDTO.setSeason(season);
                cropDTO.setCropImage(cropIMG);
                cropDTO.setFieldList(field);
                cropDTO.setLogList(log);

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
