package com.mycompany.app.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ResponeService {
    public HashMap<String, Object> GetServiceList(Boolean Status, String Message, List Data,Long Total){
        HashMap<String, Object> finalMap = new HashMap<>();
        finalMap.put("Status", Status);
        finalMap.put("Message", Message);
        finalMap.put("Data", Data);
        finalMap.put("TotalData", Total);
        return finalMap;
    }
    public HashMap<String, Object> GetServiceObject(Boolean Status, String Message, Object Data){
        HashMap<String, Object> finalMap = new HashMap<>();
        finalMap.put("Status", Status);
        finalMap.put("Message", Message);
        finalMap.put("Data", Data);
        return finalMap;
    }
}
