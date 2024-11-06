package com.example.demo.Entity.IMPL;

import com.example.demo.Entity.FuelType;
import jakarta.persistence.*;

@Entity
@Table(name = "vahicle")
public class VehicleEntity {
    @Id
    private String vehicleCode;

    private String licensePlateNumber;
    private String vehicleCategory;
    private FuelType fuelType;
    private String status;

    @OneToOne
    @JoinColumn(name = "allocatedStaffMemberDetail")
    private StaffEntity allocatedStaffMemberDetails;

    private String remarks;
}
