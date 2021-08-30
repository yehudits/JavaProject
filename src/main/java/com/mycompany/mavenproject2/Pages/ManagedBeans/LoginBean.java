package com.mycompany.mavenproject2.Pages.ManagedBeans;



import com.mycompany.mavenproject2.Enums.LoginType;

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
    private String name;
    private UserType userType;
    private String password;
    private String confirmPassword;
    private String email;
    private String errorPage="";

    private String errorMessage="";
    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
    private LoginType loginType = LoginType.SIGNIN;

    public String onSubmit(){
        this.errorMessage ="";
        if (loginType ==LoginType.SIGNIN){
            boolean isSignInSuccsedded = loginProcess.signIn(new User(name, password, email));
            if(isSignInSuccsedded==false){
                errorMessage="user name or password invalid";
                return "";
            }
        }
        else {
            if (loginType == LoginType.SIGNUP){
                if(!loginProcess.isEmailValid(email)){
                      this.errorMessage="email address is invalid";
                        return "";
                }
                if(this.password.equals(this.confirmPassword)){
                    if(loginProcess.isUserNameExist(this.name)){
                          this.errorMessage="user name already exist. Please try another name";
                        return "";
                    }
                    if(loginProcess.isEmailAddressExist(this.email)){
                          this.errorMessage="email address already exist. Please try to sign in or use another email.";
                        return "";
                    }
                    
                    
                    boolean isSignUpSuccsedded = loginProcess.signUp(new User( name, password, email));
                    if(isSignUpSuccsedded==false){
                        this.errorMessage="sign up failed";
                        return "";
                    }
                }
                else{
                    this.errorMessage="passwords are not match";
                    return "";
                }
            }
        }
        return "showsList.xhtml";
    }


    public String getEmail(){
        return this.email;
    }
    

    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getConfirmPassword(){
        return this.confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }


    public LoginProcess getLoginProcess() {
        return loginProcess;
    }

    public void setLoginProcess(LoginProcess loginProcess) {
        this.loginProcess = loginProcess;
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

    public boolean isEnabled() {
        return enabled;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }
    
    public void changeLoginType(){
        this.errorMessage ="";
        System.out.println("hello hellllllllllllllllllllll");
        if(loginType==LoginType.SIGNIN){
            loginType=LoginType.SIGNUP;
        }
        else{
            loginType=LoginType.SIGNIN;
        }
        enabled = !enabled;

    }


}
