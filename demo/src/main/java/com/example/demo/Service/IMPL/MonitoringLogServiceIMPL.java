package com.example.demo.Service.IMPL;

import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.DTO.MonitoringLogStatus;
import com.example.demo.Entity.IMPL.MonitoringLogEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.MonitoringLogService;
import com.example.demo.util.IdGenerate;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class MonitoringLogServiceIMPL implements MonitoringLogService {
    @Autowired
    private MonitoringLogDao monitoringLogDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveLog(MonitoringLogDTO monitoringLogDTO) {
        monitoringLogDTO.setLogCode(IdGenerate.generateLogCode());
        MonitoringLogEntity saveLog = monitoringLogDao.save(mapping.toMonitoringLogEntity(monitoringLogDTO));
            if (saveLog==null){
                throw new DataPersistException("Log Not Found");
            }
    }

    @Override
    public List<MonitoringLogDTO> getAllLogs() {
        return mapping.asMonitoringDtoList(monitoringLogDao.findAll());
    }

    @Override
    public MonitoringLogStatus getLog(String logCode) {
        MonitoringLogEntity findLog =monitoringLogDao.getReferenceById(logCode);
        return mapping.toMonitoringLogDto(findLog);
    }

    @Override
    public void deleteLog(String logCode) {
        monitoringLogDao.deleteById(logCode);

    }

    @Override
    public void updateLog(String logCode, MonitoringLogDTO monitoringLogDTO) {

    }
}
