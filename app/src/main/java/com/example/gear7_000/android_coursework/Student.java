package com.example.gear7_000.android_coursework;

/**
 * Created by gear7_000 on 11/8/2016.
 */

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String phone;
    private String imagepaths;

    public Student(int id, String first_name, String last_name, String address, String email, String phone, String imagepaths) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.imagepaths = imagepaths;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return first_name;
    }

    public void setFirstname(String firstname) {
        this.first_name = firstname;
    }

    public String getLastname() {
        return last_name;
    }

    public void setLastname(String lastname) {
        this.last_name = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImagepaths () { return imagepaths; }

    public void setImagepaths(String imagepaths) { this.imagepaths = imagepaths; }
}
