package com.example.quickworld;


public class dataset {
    private String content;
    private int image;
    private String description;
    public dataset(int img, String ucontent, String udescription){
        content = ucontent;
        image = img;
        description = udescription;
    }

    public int getcolor(){
        return image;
    }

    public String getContent(){
        return content;
    }

    public String getDescription(){
        return description;
    }

}
