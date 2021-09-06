package com.example.petequallife;

import java.util.HashMap;
import java.util.Map;

public class FirebasePost {
    public String name;
    public int dog;
    public String txt;

    public FirebasePost(){

    }

    public FirebasePost(String name, int dog, String txt){
        this.name = name;
        this.dog = dog;
        this.txt = txt;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("dog", dog);
        result.put("txt", txt);
        return result;
    }
}
