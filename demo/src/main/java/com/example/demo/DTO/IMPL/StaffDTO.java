package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.StaffStatus;
import com.example.demo.Entity.Gender;
import com.example.demo.Entity.Role;

import java.util.Date;
import java.util.List;

public class StaffDTO implements StaffStatus {
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNumber;
    private String email;
    private Role role;
    private List<FieldDTO> field;
    private List<VehicleDTO> vehicle;
}
