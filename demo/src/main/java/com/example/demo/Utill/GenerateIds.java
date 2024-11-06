package com.example.demo.Utill;

import java.util.UUID;

public class GenerateIds {
    public static String generateFieldId(){return "Field- "+UUID.randomUUID();}
    public static String generateCropId(){return "Crop -"+UUID.randomUUID();}
}
