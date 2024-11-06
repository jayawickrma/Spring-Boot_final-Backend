package com.example.demo.Service;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.example.demo.DTO.IMPL.staffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(staffDTO staff);
    List<staffDTO>getAllStaff();
    void getStaff(String staffId);
    void deleteStaff(String staffId);
    void UpdateStaff(String staffId,staffDTO staff);
}
