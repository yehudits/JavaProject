/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DataLayer.Seat;
import com.mycompany.mavenproject2.DataLayer.Show;
import com.mycompany.mavenproject2.DataLayer.Ticket;
import com.mycompany.mavenproject2.Services.SeatsService;
import com.mycompany.mavenproject2.Services.ShowDetailsService;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.*;
import javax.enterprise.context.*;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import com.mycompany.mavenproject2.LoginProcess.LoginProcess;
import org.apache.commons.lang3.RandomStringUtils;


/**
 *
 * @author HP
 */
@Named(value = "showsChartBean")
@ViewScoped

public class showsChartBean implements Serializable{
    ArrayList<Ticket> showToSeats;
    int id;
    LoginProcess LoginProcess;
    SeatsService SeatsService;
    
    public showsChartBean() {
        this.LoginProcess = new LoginProcess();
        this.SeatsService = new SeatsService();
        this.id = LoginProcess.getUser().getId();
        this.showToSeats = this.SeatsService.getSavedSeatsForUser(this.id);
        printRowCols();
    }

    public ArrayList<Ticket> getShowToSeats() {
        return showToSeats;
    }

    public void setShowToSeats(ArrayList<Ticket> showToSeats) {
        this.showToSeats = showToSeats;
    }
    
    public void printRowCols(){
        for(int i=0;i<this.showToSeats.size();i++){
            System.out.print(this.showToSeats.get(i).getCol()+"  ");
            System.out.println(this.showToSeats.get(i).getRow());
        }
    }

    
    
    

    
    
}
