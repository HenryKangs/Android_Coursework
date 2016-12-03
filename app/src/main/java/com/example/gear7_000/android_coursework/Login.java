package com.example.gear7_000.android_coursework;

/**
 * Created by gear7_000 on 11/28/2016.
 */

public class Login {

    //login object contains two attributes which are username and password.
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {}

    //sets a password.
    public void setPassword(String password) {
        this.password = password;
    }

    //returns a password.
    public String getPassword() {
        return password;
    }

    //sets a username.
    public void setUsername(String username) {
        this.username = username;
    }

    //returns a username.
    public String getUsername() {
        return username;
    }
}
