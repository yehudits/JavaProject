/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DataLayer.User;
import com.mycompany.mavenproject2.Enums.UserType;
import com.mycompany.mavenproject2.LoginProcess.LoginProcess;
import javax.enterprise.context.*;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

import javax.inject.Named; 

/**
 *
 * @author HP
 */
@Named(value = "AddAdminBean")
@ViewScoped
public class AddAdminBean implements Serializable{

    private String userName;
    private String email;
    private LoginProcess LoginProcess;
    private String resultMsg;
    /**
     * Creates a new instance of AddAdmin
     */
    public AddAdminBean() {
        this.LoginProcess=new LoginProcess();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void submitAdmin(){
        int resType = this.LoginProcess.addAdmin(userName, email);
        switch(resType){
            case 1:
                this.resultMsg = "new admin added succeesfuly";
                break;
            case 2:
                this.resultMsg = "no record of the user was found, or user added twice. user was not added";
                break;
            case 3:
                this.resultMsg =  "unknown error accoured";
                break;
        }
        
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    
}
