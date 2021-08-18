/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Services;

import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.Seat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class SeatsService {
    
    private DBConnector dbConnector;
    private static int chosenRow;
    private static int chosenColumn;

    public SeatsService(){
        dbConnector = new DBConnector();
       
        
    }
    
    public List<Seat> getAllSeatsForShow(int showId){
        List<Seat> seats = new ArrayList();
         try{
            Connection c = dbConnector.getConnection();
            PreparedStatement s = c.prepareStatement("select * from app.\"SEAT\" where SHOW_ID = ?");
            s.setInt(1, showId);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                seats.add(new Seat(rs.getInt("seat_id"),
                        rs.getInt("show_id"),
                        rs.getInt("row_num"),
                        rs.getInt("column_num"),
                        rs.getInt("user_id")
                ));
            }
        }
        catch(SQLException E){
            
        }
         return seats;
    }
    
    
      
    public Map<Integer, List<Integer>> getAllSeatsForShow2(int showId){
        Map<Integer, List<Integer>> savedSeats = new HashMap<>();
         try{
            Connection c = dbConnector.getConnection();
            PreparedStatement s = c.prepareStatement("select * from app.\"SEAT\"  where \"SHOW_ID\" = ?");
            s.setInt(1, showId);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                int row = rs.getInt("row_num");
                int col =  rs.getInt("column_num");
                if(!savedSeats.containsKey(row)){
                    savedSeats.put(row, new ArrayList<Integer>());
                }
                savedSeats.get(row).add(col);
            }
        }
        catch(SQLException E){
            
        }
         return savedSeats;
    }  
    
    public boolean saveChosenSeat(int showId,int userId){
        
        try{
            Connection conn = this.dbConnector.getConnection();
            String query = " insert into  app.\"SEAT\"   (SHOW_ID, USER_ID, ROW_NUM,COLUMNS)"
            + " values ( ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1,showId);
            preparedStmt.setInt(2,userId);
            preparedStmt.setInt(3,chosenRow);
            preparedStmt.setInt(4,chosenColumn);
            preparedStmt.execute();
            
            conn.close();
            return true;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;

    }
    
    public static void setSeat(int row, int column){
        chosenRow=row;
        chosenColumn = column;
    }

    public static int getChosenRow() {
        return chosenRow;
    }

    public static int getChosenColumn() {
        return chosenColumn;
    }

    public static void setChosenRow(int chosenRow) {
        SeatsService.chosenRow = chosenRow;
    }

    public static void setChosenColumn(int chosenColumn) {
        SeatsService.chosenColumn = chosenColumn;
    }
    
    
    
}
