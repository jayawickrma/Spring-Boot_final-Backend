package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.MonitoringLogService;
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

import java.util.Date;

@RestController
@RequestMapping("api/v1/logs")
public class LogsController {
    @Autowired
    private MonitoringLogService monitoringLogService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog(@RequestPart("logDate") Date date,
                                        @RequestPart("logDetails") String details,
                                        @RequestPart("logImg") MultipartFile img)
//                                       @RequestPart("field")String field,
//                                       @RequestPart("crop")String crop,
//                                       @RequestPart("staff")String staff)
    {
        try {

            String image = PicEncorder.generatePicture(img);
            MonitoringLogDTO monitoringLogDTO = new MonitoringLogDTO();

//                monitoringLogDTO.setField(field);
//                monitoringLogDTO.setCrop(crop);
//                monitoringLogDTO.setStaff(staff);

            monitoringLogService.saveLog(monitoringLogDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

