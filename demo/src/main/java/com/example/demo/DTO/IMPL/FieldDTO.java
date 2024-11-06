package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.FieldStatus;

import java.awt.*;
import java.util.List;

public class FieldDTO implements FieldStatus {
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extentSizeOfTheField;
    private java.util.List<CropDTO> crops;
    private List<StaffDTO> staff;
    private String fieldImage1;
    private String fieldImage2;
}
