package com.example.demo.Service.IMPL;

import com.example.demo.DAO.*;
import com.example.demo.DTO.IMPL.*;
import com.example.demo.DTO.StaffStatus;
import com.example.demo.Entity.IMPL.*;
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
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private StaffDetailsDao staffDetailsDao;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        int number =0;
        StaffEntity staff =staffDao.findLastRowNative();
        if (staff!=null){
            String [] parts=staff.getMemberCode().split("-");
            number=Integer.parseInt(parts[1]);
        }
        staffDTO.setMemberCode("MEMBER-"+ ++number);
        List<FieldEntity>fieldEntities =new ArrayList<>();
            for (String fieldCode : staffDTO.getFieldList()){
                fieldEntities.add(fieldDao.getReferenceById(fieldCode));
            }
        List<VehicleEntity>vehicleEntities=new ArrayList<>();
            for (String id :staffDTO.getVehicleList()){
                vehicleEntities.add(vehicleDao.getReferenceById(id));
            }
        List<LogEntity>logEntities=new ArrayList<>();
            for (String lid :staffDTO.getLogList()){
                logEntities.add(monitoringLogDao.getReferenceById(lid));
            }
        StaffEntity staffEntity=mapping.toStaffEntity(staffDTO);
        staffEntity.setFieldList(fieldEntities);
        staffEntity.setVehicleList(vehicleEntities);
        staffEntity.setLogList(logEntities);

        for (FieldEntity field:fieldEntities){
            field.getStaffList().add(staffEntity);
        }
            StaffEntity staffEntity1 =staffDao.save(staffEntity);
            if (staffEntity1==null){
                throw new DataPersistException("Something went wrong");
            }

    }

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
