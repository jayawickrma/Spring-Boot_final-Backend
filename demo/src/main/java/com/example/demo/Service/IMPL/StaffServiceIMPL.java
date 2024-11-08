package com.example.demo.Service.IMPL;

import com.example.demo.DAO.StaffDao;
import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.StaffStatus;
import com.example.demo.Entity.IMPL.StaffEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Service.StaffService;
import com.example.demo.util.IdGenerate;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
            staffDTO.setId(IdGenerate.generateStaffId());
        StaffEntity saveStaff =staffDao.save(mapping.toStaffEntity(staffDTO));
            if (saveStaff==null){
                throw new DataPersistException("Couldn't Find");
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
