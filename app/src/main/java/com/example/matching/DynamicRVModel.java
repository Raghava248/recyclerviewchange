package com.example.matching;

public class DynamicRVModel {

    String name;
    private int image;
    public DynamicRVModel(String name, int image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
