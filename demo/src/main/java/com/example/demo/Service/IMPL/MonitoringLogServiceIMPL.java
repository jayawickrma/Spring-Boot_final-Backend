package com.example.demo.Service.IMPL;

import com.example.demo.DAO.CropDao;
import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.DTO.MonitoringLogStatus;
import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.MonitoringLogService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
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
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private CropDao cropDao;
    @Override
    public void saveLog(MonitoringLogDTO monitoringLogDTO) {
        int number=0;
        LogEntity log =monitoringLogDao.findLastRowNative();
        if (log!=null){
            String [] parts=monitoringLogDTO.getLogCode().split("-");
            number=Integer.parseInt(parts[1]);
        }
        monitoringLogDTO.setLogCode("LOG-"+ ++number);
        LogEntity logEntity=mapping.toMonitoringLogEntity(monitoringLogDTO);

        List<StaffEntity>staffEntities =new ArrayList<>();
            for (String staffId : monitoringLogDTO.getStaffList()){
                if (staffDao.existsById(staffId)){
                    staffEntities.add(staffDao.getReferenceById(staffId));
                }
            }

        List<CropEntity>cropEntities =new ArrayList<>();
            for (String cropCode: monitoringLogDTO.getCropList()){
                if (cropDao.existsById(cropCode)){
                    cropEntities.add(cropDao.getReferenceById(cropCode));
                }
            }

        List<FieldEntity>fieldEntities =new ArrayList<>();
            for (String firldCode :monitoringLogDTO.getFieldList()){
                if (fieldDao.existsById(firldCode)){
                    fieldEntities.add(fieldDao.getReferenceById(firldCode));
                }
            }

            logEntity.setStaffList(staffEntities);
            logEntity.setCropList(cropEntities);
            logEntity.setFieldList(fieldEntities);

            for (FieldEntity field:fieldEntities){
                field.getLogList().add(logEntity);
            }

            LogEntity log1 =monitoringLogDao.save(logEntity);
        System.out.println(logEntity);
            if (log1==null){
                throw new DataPersistException("Something went wrong");
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
