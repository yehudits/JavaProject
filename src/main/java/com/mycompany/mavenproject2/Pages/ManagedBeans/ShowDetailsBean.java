/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DataLayer.Seat;
import com.mycompany.mavenproject2.DataLayer.Show;
import com.mycompany.mavenproject2.Services.SeatsService;
import com.mycompany.mavenproject2.Services.ShowDetailsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
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
    Map<Integer, List<Integer>> savedSeats;
    
    ArrayList<ArrayList<Integer>> chosenSeats = new ArrayList<ArrayList<Integer>>();

    
    int [][] seats;
    
    private List<List<Float>> _Matrix;

    private int _ColumnNumber;
    
    public int get_ColumnNumber(){
        return _Matrix.size();
    }

    public List<Integer> getRows(){
        List<Integer> y = new ArrayList();
        int i = 0;
        while(i < selectedShow.getRows()){
            y.add(++i);
        }
        return y;
    }
   
    
        public List<Integer> getCols(){
         List<Integer> y = new ArrayList();
        int i = 0;
        while(i < selectedShow.getColumns()){
            y.add(++i);
        }
        return y;
    }
    
    
    public int[] getRowSeats(int[] row){
        int u[] = new int[9];
        return u;
    }
    
        public int[] getRowSeats(){
            seats[0][0] = 8;
            seats[0][1] = 4;
        return seats[0];
    }
    
    
public List<List<Float>> get_Matrix() {
    return this._Matrix;
}
    
    
    public Show getSelectedShow() {
        this._Matrix = new ArrayList<List<Float>>();
    this._Matrix.add(new ArrayList<Float>());
    this._Matrix.add(new ArrayList<Float>());
    this._Matrix.get(0).add(1.0f);
    this._Matrix.get(0).add(2.0f);
    this._Matrix.get(0).add(3.0f);
    this._Matrix.get(1).add(1.0f);
    this._Matrix.get(1).add(2.0f);
    this._Matrix.get(1).add(3.0f);
        
        
        
        
        if(selectedShow== null){
             this.selectedShow = ShowDetailsService.getShow();
        this.seats = new int [selectedShow.getRows()][selectedShow.getColumns()];

        }
        return selectedShow;
    }


    public int[][] fetchSavedSeats() {
        this.savedSeats =  seatsService.getAllSeatsForShow2(this.selectedShow.getId());
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
   
   
   public String isSeatAssigned(int row, int column){
       if(this.savedSeats == null){
           this.fetchSavedSeats();
       }
       if(this.savedSeats.get(row)!= null){
           if(this.savedSeats.get(row).contains(column)){
               return "red";
            }
       }
       else{
            ArrayList<Integer> addedSeat = new ArrayList<Integer>();
            addedSeat.add(row);
            addedSeat.add(column);
            if(chosenSeats.contains(addedSeat)){
                return "#d4cece";
            }
       }
       return "white";
   }
   
   public String chooseSeats(){
       SeatsService.setSeats(this.chosenSeats);
       return "saveCardsInvitation.xhtml";       
    }
   
   public void addSeatToSavedSeats(int row, int column){
       ArrayList<Integer> addedSeat = new ArrayList<Integer>();
       addedSeat.add(row);
       addedSeat.add(column);
       if(chosenSeats.contains(addedSeat)){
           chosenSeats.remove(addedSeat);
           System.out.println("remove "+row+","+column);
        }
       else{
            chosenSeats.add(addedSeat);
            System.out.println("add "+row+","+column);
       }
       
   }

}
