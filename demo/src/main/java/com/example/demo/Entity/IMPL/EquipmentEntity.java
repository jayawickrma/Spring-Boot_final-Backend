package com.example.demo.Entity.IMPL;

import com.example.demo.Entity.EquipmentStatus;
import com.example.demo.Entity.EquipmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    private String equipmentId;

    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private StaffEntity assignedStaffDetails;

    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private FieldEntity assignedFieldDetails;
}
