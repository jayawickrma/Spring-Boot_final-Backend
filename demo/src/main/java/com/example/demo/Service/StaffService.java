package com.example.demo.Service;

import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.StaffStatus;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO>getAllStaff();
    StaffStatus getStaff(String staffId);
    void deleteStaff(String staffId);
    void UpdateStaff(String staffId, StaffDTO staffDTO);
}
