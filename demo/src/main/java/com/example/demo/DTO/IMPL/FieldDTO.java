package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements FieldStatus {
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String extentSizeOfTheField;
    private String crops;
    private String staff;
    private String equipment;
    private String fieldImage1;
    private String fieldImage2;
}
