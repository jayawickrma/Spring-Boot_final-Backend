package com.example.demo.utill;

import java.util.UUID;

public class AppUtil {
    public static String generateFieldId(){return "Field- "+UUID.randomUUID();}
    public static String generateCropId(){return "Crop -"+UUID.randomUUID();}
}
