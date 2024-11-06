package com.example.demo.Entity.IMPL;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "monitoringLogServices")
public class MonitoringLogEntity {
    @Id
    private String logCode;

    private Date logDate;
    private String logDetails;

    @Lob
    private String observedImage;

    @OneToMany(mappedBy = "fieldCode")
    private List<FieldEntity> field;

    @OneToMany(mappedBy = "cropCode")
    private List<CropEntity> crop;

    @OneToMany(mappedBy = "staffId")
    private List<StaffEntity> staff;
}
