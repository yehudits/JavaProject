package com.mycompany.mavenproject2.Pages.ManagedBeans;



import Enums.LoginType;

import com.mycompany.mavenproject2.DataLayer.User;
import com.mycompany.mavenproject2.Enums.UserType;
import com.mycompany.mavenproject2.LoginProcess.LoginProcess;
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.faces.view.ViewScoped;

import javax.inject.Named; 

@Named("loginBean")
@ViewScoped
public class LoginBean implements Serializable{
    
    public String yyy(){
        System.out.println("dddd");
        return "5";
    }

    public LoginBean(){
        try{
            this.loginProcess = new LoginProcess();

        }
        catch(Exception e){
            
        }
    }

    //services
    LoginProcess loginProcess;


    //properties connected to the ui
    private int id;
    private String name;
    private UserType userType;
    private String password;
    private String email= " hhhhh    ";
    private LoginType loginType = LoginType.SIGNIN;

    public String onSubmit(){
        if (loginType ==LoginType.SIGNIN){
            loginProcess.signIn(new User(id, name, password, email));
        }
        else if (loginType == LoginType.SIGNUP){
            loginProcess.signUp(new User(id, name, password, email));
        }
        return "showsList.xhtml";
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
    
    public boolean isNewUser(){
        
        if(loginType == LoginType.SIGNIN){
            return false;
        }
        return true;
    }
    
        private boolean enabled;

    public void toggle() {
        enabled = !enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
    
    public void changeLoginType(){
        loginType = LoginType.SIGNUP;
        System.out.println("hello hellllllllllllllllllllll");
        if(loginType == LoginType.SIGNIN){
            loginType = LoginType.SIGNUP;
        }
        else if(loginType == LoginType.SIGNUP){
            loginType = LoginType.SIGNIN;
        }
    }


}
