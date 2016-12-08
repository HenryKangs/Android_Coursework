package com.example.gear7_000.android_coursework;

import android.content.Context;

/**
 * Created by kangj10 on 31/10/2016.
 */
public class Building {

    //variables needed to create a building object is initialized.
    private String name;
    private String detail;
    private int photo;
    private Context context;


    //constructor receives three parameters building name, building detail and building photo to create a building object.
    public Building(String name, String detail, int photo) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public Building(String name, String detail, int photo, Context context) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    //returns a building name.
    public String getName() {
        return name;
    }

    //returns a building detail.
    public String getDetail() {
        return detail;
    }

    //returns a building photo.
    public int getPhoto() {
        return photo;
    }

    //returns a building detail.
    @Override
    public String toString() {
        return detail;
    }
}
