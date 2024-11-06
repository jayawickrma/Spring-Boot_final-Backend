package com.example.demo.AppUtill;

import java.util.UUID;

public class GenerateIds {
    public static String generateFieldId(){return "Field- "+UUID.randomUUID();}
    public static String generateCropId(){return "Crop -"+UUID.randomUUID();}
}
