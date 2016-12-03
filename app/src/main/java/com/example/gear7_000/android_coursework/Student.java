package com.example.gear7_000.android_coursework;

/**
 * Created by gear7_000 on 11/8/2016.
 */

public class Student {
    //variables needed to create a student object is declared.
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String phone;
    private String imagepaths;

    public Student(int id, String first_name, String last_name, String address, String email, String phone, String imagepaths) {
        //aforementioned variables are initialized.
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

    //returns id.
    public int getId() {
        return id;
    }

    //sets id.
    public void setId(int id) {
        this.id = id;
    }

    //returns firstname.
    public String getFirstname() {
        return first_name;
    }

    //sets firstname.
    public void setFirstname(String firstname) {
        this.first_name = firstname;
    }

    //returns lastname.
    public String getLastname() {
        return last_name;
    }

    //sets lastname.
    public void setLastname(String lastname) {
        this.last_name = lastname;
    }

    //returns address.
    public String getAddress() {
        return address;
    }

    //sets address.
    public void setAddress(String address) {
        this.address = address;
    }

    //returns email.
    public String getEmail() {
        return email;
    }

    //sets email.
    public void setEmail(String email) {
        this.email = email;
    }

    //returns phone.
    public String getPhone() {
        return phone;
    }

    //sets phone.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //returns image absolutepath
    public String getImagepaths () { return imagepaths; }

    //sets image absolutepath.
    public void setImagepaths(String imagepaths) { this.imagepaths = imagepaths; }
}
