package com.example.quickworld;

import android.graphics.drawable.Drawable;

public class dataset {
    private String content;
    private Drawable image;
    private String description;
    public dataset(Drawable img, String ucontent, String udescription){
        content = ucontent;
        image = img;
        description = udescription;
    }

    public Drawable getImage(){
        return image;
    }

    public String getContent(){
        return content;
    }

    public String getDescription(){
        return description;
    }

}
