package com.example.demo.util;

import java.util.UUID;

public class IdGenerate {
    public static String generateFieldId(){return "Field- "+UUID.randomUUID();}
    public static String generateCropId(){return "Crop -"+UUID.randomUUID();}
    public static String generateEquipmentID(){return "Equipment -"+UUID.randomUUID();}
    public static String generateLogCode(){return "Log- "+UUID.randomUUID();}
    public static String generateStaffId(){return "ID- "+UUID.randomUUID();}
}
