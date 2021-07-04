/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DataLayer.Seat;
import com.mycompany.mavenproject2.DataLayer.Show;
import com.mycompany.mavenproject2.Services.SeatsService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author HP
 */
@Named
@ViewScoped
public class ShowDetailsBean implements Serializable {
    private SeatsService seatsService;
    private Show selectedShow;

    int [][] seats;
    
    public Show getSelectedShow() {
        return selectedShow;
    }

    public void setSelectedShow(Show selectedShow) {
        this.selectedShow = selectedShow;
        this.seats = new int [selectedShow.getRows()][selectedShow.getColumns()];
        List<Seat> savedSeats =  seatsService.getAllSeatsForShow(this.selectedShow.getId());
    }

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }
    
    
    
   public ShowDetailsBean(){
       this.seatsService = new SeatsService(); 
   }
   
   public int getId(){
       return this.selectedShow.getId();
   }
   
   
    
}
