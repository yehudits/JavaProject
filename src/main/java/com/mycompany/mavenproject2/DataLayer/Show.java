package com.mycompany.mavenproject2.DataLayer; 

public class Show {
    
    public Show(){
        
    }

    public Show(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Show(int id, String name, String adress, String date, int ownerId, String description, int rows, int columns, int price) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.date = date;
        this.ownerId = ownerId;
        this.description = description;
        this.rows = rows;
        this.columns = columns;
        this.price = price;
    }
    
    
    
    private int id;
    private String name;
    private String adress;
    private String date;
    private int ownerId;
    private String description;
    private int rows;
    private int columns;
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
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
    
    
    
    
}
