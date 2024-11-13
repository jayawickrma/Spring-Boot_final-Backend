package com.example.demo.Entity.IMPL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staffEquipmentDetails")


public class staffDetailsEntity {
    @Id
    private String id;
    private int useEquipmentCount;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "memberCode",referencedColumnName = "memberCode",nullable = false)
    private StaffEntity staffEntity;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "equipmentCode",referencedColumnName = "equipmentCode",nullable = false)
    private EquipmentEntity equipmentEntity;
}
