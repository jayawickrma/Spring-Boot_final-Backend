package com.example.demo.Entity.IMPL;

import com.example.demo.DTO.IMPL.StaffDTO;
import com.example.demo.Entity.Gender;
import com.example.demo.Entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity  {
    @Id
    private String staffId;

    private String firstName;
    private String lastName;
    private String designation;


    private String gender;

    private Date joinedDate;
    private Date dob;

    @Column(name = "building_no")
    private String addressLine01;

    @Column(name = "Lane")
    private String addressLine02;

    @Column(name = "city")
    private String addressLine03;

    @Column(name = "main_state")
    private String addressLine04;

    @Column(name = "postal_code")
    private String addressLine05;

    private String contactNumber;

    private String email;


    private String role;

    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;

    @OneToMany(mappedBy = "vehicleCode")
    private List<VehicleEntity> vehicle;
}
