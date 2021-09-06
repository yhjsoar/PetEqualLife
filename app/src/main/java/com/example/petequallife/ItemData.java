package com.example.petequallife;

import android.graphics.drawable.Drawable;

public class ItemData {
    public Drawable image;
    public String name;
    public String txt;
    public int dog;

    public ItemData(){

    }

    public ItemData(Drawable image, String name, String txt, int dog){
        this.name = name;
        this.txt = txt;
        this.image = image;
        this.dog = dog;
    }
}
