package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.StaffStatus;
import com.example.demo.Entity.Gender;
import com.example.demo.Entity.Role;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements StaffStatus {
    @Id
    private String memberCode;
    private String firstName;
    private String lastName;
    private LocalDate joinedDate;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String designation;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;
    private List<staffDetailsDto> staffEquipmentDetailsList;
    private List<String> vehicleList;
    private List<String> fieldList;
    private List<String> logList;

}
