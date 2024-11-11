package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.StaffStatus;
import com.example.demo.Entity.Gender;
import com.example.demo.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements StaffStatus {
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private String gender;
    private String joinedDate;
    private String dob;
    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNumber;
    private String email;
    private String role;
    private String equipment;
    private String log;

}
