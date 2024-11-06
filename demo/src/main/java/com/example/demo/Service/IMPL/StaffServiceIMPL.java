package com.example.demo.Service.IMPL;

import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.StaffStatus;
import com.example.demo.Service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceIMPL implements StaffService {
    @Override
    public void saveStaff(StaffDTO staffDTO) {

    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return null;
    }

    @Override
    public StaffStatus getStaff(String id) {
        return null;
    }

    @Override
    public void deleteStaff(String id) {

    }

    @Override
    public void UpdateStaff(String id, StaffDTO staffDTO) {

    }
}
