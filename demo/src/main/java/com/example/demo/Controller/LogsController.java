package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.MonitoringLogService;
import com.example.demo.util.PicEncorder;
import com.example.demo.util.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/logs")
public class LogsController {
    @Autowired
    private MonitoringLogService monitoringLogService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog(@RequestPart("logDate") String date,
                                        @RequestPart("logDetails") String details,
                                        @RequestPart("logImg") MultipartFile img,
                                       @RequestPart("field") String field,
                                       @RequestPart("crop")String crop,
                                       @RequestPart("staff")String staff)
    {
        try {
            List<String> field_codes =new ArrayList<>();

            if (field!= null) {
                field_codes = SplitString.spiltLists(field);
            }

            List<String> crop_codes =new ArrayList<>();

            if (crop !=null){
                crop_codes=SplitString.spiltLists(crop);
            }

            List<String>straff_codes =new ArrayList<>();

            if (staff !=null){
                straff_codes =SplitString.spiltLists(staff);
            }

            String image = PicEncorder.generatePicture(img);
            MonitoringLogDTO logDto = new MonitoringLogDTO();
                logDto.setLogDate(date);
                logDto.setLogDetails(details);
                logDto.setObservedImage(image);
                logDto.setFieldList(field_codes);
                logDto.setCropList(crop_codes);
                logDto.setStaffList(straff_codes);

            System.out.println(logDto);

            monitoringLogService.saveLog(logDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

