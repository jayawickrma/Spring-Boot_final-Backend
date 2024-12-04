package com.example.demo.Service;

import com.example.demo.DTO.IMPL.MonitoringLogDTO;

import java.util.List;

public interface MonitoringLogService {
    void saveLog(MonitoringLogDTO monitoringLogDTO);
    List<MonitoringLogDTO> getAllLogs();
    MonitoringLogDTO getLog(String logCode);
    void deleteLog(String logCode);
    void updateLog(String logCode,MonitoringLogDTO monitoringLogDTO);
}
