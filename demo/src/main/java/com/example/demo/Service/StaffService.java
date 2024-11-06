package com.example.demo.Service;

import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.DTO.StaffStatus;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO>getAllStaff();
    StaffStatus getStaff(String id);
    void deleteStaff(String id);
    void UpdateStaff(String id, StaffDTO staffDTO);
}
