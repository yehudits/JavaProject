/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.Show;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;

/**
 *
 * @author HP
 */
@Named(value = "showsManagementBean")
@Dependent
public class ShowsManagementBean implements Serializable{

    /**
     * Creates a new instance of ShowsManagementBean
     */
    public ShowsManagementBean() {
    }
    
}
