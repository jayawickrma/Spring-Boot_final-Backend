package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    public static List<String> spiltLists(String value){
        String[] array = value.split(",");
        List<String> list = new ArrayList<>();
        for (String id : array){
            list.add(id);
        }
        return list;
}
}
