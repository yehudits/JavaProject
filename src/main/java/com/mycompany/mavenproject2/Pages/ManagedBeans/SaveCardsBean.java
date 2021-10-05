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
@Named(value = "saveCardsBean")
@ViewScoped

public class SaveCardsBean implements Serializable{

    private String cardNum,ticketNotSaved="";
    private int row,column,showId,userId,price;
    private Integer cvv,cardMonth,cardYear;
    private String showName, date, time,shortId;
    private static String approval;
    private SeatsService SeatsService;
    private LoginProcess LoginProcess;
    private ArrayList<ArrayList<Integer>> chosenSeats;


    public SaveCardsBean() {
        this.SeatsService=new SeatsService();
        this.ShowDetailsService = new ShowDetailsService();
        this.LoginProcess = new LoginProcess();
        this.row = this.SeatsService.getChosenRow();
        this.column = this.SeatsService.getChosenColumn();
        this.showName = ShowDetailsService.getShow().getName();
        this.date = ShowDetailsService.getShow().getDate();
        this.showId = ShowDetailsService.getShow().getId();
        this.userId = LoginProcess.getUser().getId();
        this.chosenSeats = SeatsService.getChosenSeats();
        this.time = ShowDetailsService.getShow().getTime();
        this.shortId = RandomStringUtils.randomAlphanumeric(8); 
        this.price = ShowDetailsService.getShow().getPrice();
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    
    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    private ShowDetailsService ShowDetailsService;


    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    /**
     * Creates a new instance of SaveCardsBean
     */
    
    public String submitInvitation(){//needs mach more checking
        if(this.cardNum.length()==16){
            if(this.cvv>=100 && this.cvv<1000){
                if(this.cardMonth>0&&this.cardMonth<13 && this.cardYear>2020){//replace it to cur date
                    String shid = SeatsService.saveChosenSeats(this.showId,this.userId,this.shortId);
                    approval = shid;
                    return "paymentSucceeded.xhtml";
                }
                else{
                    this.ticketNotSaved += " date is invalid ";
                }
            }
            else{
                this.ticketNotSaved += " cvv is invalid ";
            }
                    }
        else{
            this.ticketNotSaved += " card num is invalid ";
        }
        return "payment faild";
        
    }



    public String getCardNum() {
        return cardNum;
    }


    public Integer getCvv() {
        return cvv;
    }

    public Integer getCardMonth() {
        return cardMonth;
    }

    public Integer getCardYear() {
        return cardYear;
    }



    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public void setCardMonth(Integer cardMonth) {
        this.cardMonth = cardMonth;
    }

    public void setCardYear(Integer cardYear) {
        this.cardYear = cardYear;
    }

    public ArrayList<ArrayList<Integer>> getChosenSeats() {
        return chosenSeats;
    }

    public void setChosenSeats(ArrayList<ArrayList<Integer>> chosenSeats) {
        this.chosenSeats = chosenSeats;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static String getApproval() {
        return approval;
    }

    public static void setApproval(String approval) {
        SaveCardsBean.approval = approval;
    }
    
    
}
