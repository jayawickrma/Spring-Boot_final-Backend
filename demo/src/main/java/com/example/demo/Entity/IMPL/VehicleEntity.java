package com.example.demo.Entity.IMPL;

import com.example.demo.Entity.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
