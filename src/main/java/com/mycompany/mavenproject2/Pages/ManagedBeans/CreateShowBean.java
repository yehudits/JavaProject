/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DataLayer.Show;
import com.mycompany.mavenproject2.Services.ShowDetailsService;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.text.ParseException;  
import com.mycompany.mavenproject2.Services.CreateShowService;
import java.time.Instant;
/**
 *
 * @author HP
 */
@Named(value = "CreateShowBean")
@Dependent
public class CreateShowBean {

    private String showName;
    private String description;
    private int owner;
    private String address;
    private int row_num;
    private int columns;
    private int price;//maybe should be double
    private String date;
    private String isShowAdded;
    private CreateShowService cs;

   

    /**
     * Creates a new instance of CreateShow
     */
    
    public CreateShowBean() {
        isShowAdded="";
    }
    
    public String getCreateShowSucceeded(){
        return isShowAdded;
    }

    public void onSubmit(){
        //validation checks

        Show show=new Show(4,this.showName,this.address,this.date,
                            this.owner,this.description,this.row_num,this.columns,this.price);
        this.cs = new CreateShowService();
        boolean ShowAdded;
        ShowAdded = this.cs.addShowService(show);
        this.isShowAdded = ShowAdded?"Show is saved":"oops, an error accured";
    }
    
    
    //getters and setters

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRow_num() {
        return row_num;
    }

    public void setRow_num(int row_num) {
        this.row_num = row_num;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsShowAdded() {
        return isShowAdded;
    }

    public void setIsShowAdded(String isShowAdded) {
        this.isShowAdded = isShowAdded;
    }

    public CreateShowService getCs() {
        return cs;
    }

    public void setCs(CreateShowService cs) {
        this.cs = cs;
    }


}
