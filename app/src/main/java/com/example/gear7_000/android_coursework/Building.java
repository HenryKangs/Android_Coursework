package com.example.gear7_000.android_coursework;

/**
 * Created by kangj10 on 31/10/2016.
 */
public class Building {

    private String name;
    private String detail;
    private int photo;

    public Building(String name, String detail, int photo) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return detail;
    }
}
