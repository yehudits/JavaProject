package com.mycompany.mavenproject2.Pages.ManagedBeans;


import DataLayer.User;
import Enums.LoginType;
import Enums.UserType;
import LoginProcess.LoginProcess;
import java.io.Serializable;
import javax.enterprise.context.*;

import javax.inject.Named; 

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    public String yyy(){
        System.out.println("dddd");
        return "5";
    }

    public LoginBean(){
        this.loginProcess = new LoginProcess();
    }

    //services
    LoginProcess loginProcess;


    //properties connected to the ui
    private int id;
    private String name;
    private UserType userType;
    private String password;
    private String email= " hhhhh    ";
    private LoginType loginType;

    public void onSubmit(){
        if (loginType ==LoginType.SIGNIN){
            loginProcess.signIn(new User());
        }
        else if (loginType == LoginType.SINGUP){
            loginProcess.signUp(new User());
        }
    }


    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public LoginProcess getLoginProcess() {
        return loginProcess;
    }

    public void setLoginProcess(LoginProcess loginProcess) {
        this.loginProcess = loginProcess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }


}
