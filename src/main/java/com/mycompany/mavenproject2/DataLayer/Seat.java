package com.mycompany.mavenproject2.DataLayer;



public class Seat {

    private int showId;
    private int column;
    private int row;
    private int userId;

    public Seat(int seatId, int showId, int row, int column, int userId) {
        this.showId = showId;
        this.column = column;
        this.row = row;
        this.userId = userId;
    }

    
    
    
    
    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    
}
