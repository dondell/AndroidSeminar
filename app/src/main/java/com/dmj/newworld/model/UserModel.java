package com.dmj.newworld.model;

public class UserModel {
    public String firstname;
    public String lastname;
    public String email;

    public UserModel(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public UserModel(String firstname) {
        this.firstname = firstname;
    }
}
