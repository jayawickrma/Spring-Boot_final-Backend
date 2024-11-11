package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.MonitoringLogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDTO implements MonitoringLogStatus {
    private String logCode;
    private Date logDate;
    private String logDetails;
    private String observedImage;
//    private String field;
//    private String crop;
//    private String staff;
}
