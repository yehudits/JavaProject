package com.mycompany.mavenproject2.DataLayer;



public class User {

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    
    public User(int id, String name, String password, String email,boolean userType ) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.id=id;
        this.userType = userType;
    }


    
    private String name;
    private boolean userType;
    private String password;
    private String email;
    private int id;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
