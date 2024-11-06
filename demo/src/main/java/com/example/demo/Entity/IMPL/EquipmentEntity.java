package com.example.demo.Entity.IMPL;

import com.example.demo.Entity.EquipmentStatus;
import com.example.demo.Entity.EquipmentType;
import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    private String equipmentId;

    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;

    @ManyToOne
    @JoinColumn(name = "equipment_assigned_staff_details")
    private StaffEntity assignedStaffDetails;

    @ManyToOne
    @JoinColumn(name = "equipment_assigned_field_details")
    private FieldEntity assignedFieldDetails;
}
