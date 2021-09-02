package com.mycompany.mavenproject2.DataLayer; 

public class Ticket {
    
    public Ticket(){
        
    }
    
    public Ticket(int id, String name,String date,String time,int row, int col) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.col = col;
        this.row = row;
    }

    
    
    
    private int id;
    private String name;
    private String adress,time;
    private String date;
    private int row;
    private int col;
    private int price;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    
    
    
}
