package com.mycompany.mavenproject2.DataLayer;

import com.mycompany.mavenproject2.Enums.UserType;


public class User {

    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    
    private int id;
    private String name;
    private UserType userType;
    private String password;
    private String email;
}
