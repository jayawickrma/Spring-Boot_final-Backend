package com.example.demo.Service.IMPL;

import com.example.demo.DAO.FieldDao;
import com.example.demo.DAO.MonitoringLogDao;
import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.FieldDTO;
import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.StaffStatus;
import com.example.demo.Entity.IMPL.FieldEntity;
import com.example.demo.Entity.IMPL.LogEntity;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.StaffService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private MonitoringLogDao monitoringLogDao;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        int number =0;
        StaffEntity staff =staffDao.findLastRowNative();
        if (staff!=null){
            String [] parts=staff.getMemberCode().split("-");
            number=Integer.parseInt(parts[1]);
        }
        staffDTO.setMemberCode("S00"+ ++number);
        StaffEntity staffEntity=mapping.toStaffEntity(staffDTO);

        List<FieldEntity>fieldEntities=new ArrayList<>();
        for (FieldDTO fieldDTO:staffDTO.getFieldList()){
            if (fieldDao.existsById(fieldDTO.getFieldCode())){
                fieldEntities.add(fieldDao.getReferenceById(fieldDTO.getFieldCode()));
            }
        }
        staffEntity.setFieldList(fieldEntities);
        for (FieldEntity fieldEntity :fieldEntities){
            fieldEntity.getStaffList().add(staffEntity);
        }

        List<LogEntity>logEntities =new ArrayList<>();
        for (MonitoringLogDTO monitoringLogDTO:staffDTO.getLogList()){
            if (monitoringLogDao.existsById(monitoringLogDTO.getLogCode())){
                logEntities.add(monitoringLogDao.getReferenceById(monitoringLogDTO.getLogCode()));
            }

        }
        staffEntity.setLogList(logEntities);
        for (LogEntity logEntity:logEntities){
            logEntity.getStaffList().add(staffEntity);

        }    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return mapping.asStafDtoList(staffDao.findAll());
    }

    @Override
    public StaffStatus getStaff(String id) {
        StaffEntity searchStaff =staffDao.getReferenceById(id);
        return mapping.toStaffDto(searchStaff);
    }

    @Override
    public void deleteStaff(String id) {
            staffDao.deleteById(id);
    }

    @Override
    public void UpdateStaff(String id, StaffDTO staffDTO) {

    }
}
