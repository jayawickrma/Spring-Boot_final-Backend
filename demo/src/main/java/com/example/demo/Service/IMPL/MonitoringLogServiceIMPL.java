package com.example.demo.Service.IMPL;

import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.DTO.MonitoringLogStatus;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.MonitoringLogService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional

public class MonitoringLogServiceIMPL implements MonitoringLogService {
    @Autowired
    private MonitoringLogDao monitoringLogDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private FieldDao fieldDao;
    @Override
    public void saveLog(MonitoringLogDTO monitoringLogDTO) {
        int number=0;
        LogEntity log =monitoringLogDao.findLastRowNative();
        if (log!=null){
            String [] parts=monitoringLogDTO.getLogCode().split("-");
            number=Integer.parseInt(parts[1]);
        }
        monitoringLogDTO.setLogCode("L00"+ ++number);
        LogEntity logEntity=mapping.toMonitoringLogEntity(monitoringLogDTO);
        List<FieldEntity>fieldEntities=new ArrayList<>();
        for (FieldDTO fieldDTO :monitoringLogDTO.getFieldList()){
            if (fieldDao.existsById(fieldDTO.getFieldCode())){
                fieldEntities.add(fieldDao.getReferenceById(fieldDTO.getFieldCode()));
            }
        }
        logEntity.setFieldList(fieldEntities);
        for (FieldEntity fieldEntity :fieldEntities){
            fieldEntity.getLogList().add(logEntity);
        }


    }

    @Override
    public List<MonitoringLogDTO> getAllLogs() {
        return mapping.asMonitoringDtoList(monitoringLogDao.findAll());
    }

    @Override
    public MonitoringLogStatus getLog(String logCode) {
        LogEntity findLog =monitoringLogDao.getReferenceById(logCode);
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
