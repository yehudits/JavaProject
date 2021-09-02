/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Services;

import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.Seat;
import com.mycompany.mavenproject2.DataLayer.Ticket;
import com.mycompany.mavenproject2.DataLayer.Show;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;


/**
 *
 * @author HP
 */
public class SeatsService {
    
    private DBConnector dbConnector;
    private static int chosenRow;
    private static int chosenColumn;
    private static int showId;
    private static int userId;
    private static String shortId;
    private static ArrayList<ArrayList<Integer>> chosenSeats = new ArrayList<ArrayList<Integer>> ();

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
            PreparedStatement s = c.prepareStatement("select * from app.SEAT  where SHOW_ID = ?");
            s.setInt(1, showId);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                int row = rs.getInt("row_num");
                int col =  rs.getInt("columns");
                if(!savedSeats.containsKey(row)){
                    savedSeats.put(row, new ArrayList<Integer>());
                }
                savedSeats.get(row).add(col);
            }
        }
        catch(SQLException E){
            System.out.println(E);
        }
         return savedSeats;
    }  
    
    public boolean saveChosenSeats(int sId,int uId,String shId){
        showId=sId;
        userId=uId;
        shortId = shId;
        boolean res = saveChosenSeat(shId);

        /*for(int i=0;i<chosenSeats.size();i++){
            boolean res = saveChosenSeat(chosenSeats.get(i).get(0),chosenSeats.get(i).get(1));
            if(!res){
                return false;
            }
        }*/
        return res;
    }

    
    public boolean saveChosenSeat(String Short_id){
        
        try{
            Connection conn = this.dbConnector.getConnection();
            String query = " insert into  app.\"SEAT\"   (SHOW_ID, USER_ID, ROW_NUM,COLUMNS, ORDER_TOKEN)"
            + " values ( ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            for(int i=0;i<chosenSeats.size();i++){
                preparedStmt.setInt (1,showId);
                preparedStmt.setInt(2,userId);
                preparedStmt.setInt(3,chosenSeats.get(i).get(0));
                preparedStmt.setInt(4,chosenSeats.get(i).get(1));
                preparedStmt.setString(5, Short_id);
                preparedStmt.execute();
                preparedStmt.addBatch();
            }

            conn.close();
            return true;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;

    }
    
    public static void setSeats(ArrayList<ArrayList<Integer>> chosenSeatsList){
        chosenRow=chosenSeatsList.get(0).get(0);
        chosenColumn = chosenSeatsList.get(0).get(1);
        chosenSeats = chosenSeatsList;
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

    public static ArrayList<ArrayList<Integer>> getChosenSeats() {
        return chosenSeats;
    }
    
    public ArrayList<Ticket> getSavedSeatsForUser(int id){
         ArrayList<Ticket> showToSeats = new ArrayList<Ticket> ();

         try{
            Connection c = dbConnector.getConnection();
            PreparedStatement s = c.prepareStatement("select * from app.\"SEAT\" where USER_ID = ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            int cnt=0;
            while (rs.next()){
                cnt++;
                int row = rs.getInt("ROW_NUM");
                int col = rs.getInt("COLUMNS");
                int curShowId = rs.getInt("SHOW_ID");
                try{
                    PreparedStatement s2 = c.prepareStatement("select * from app.\"SHOW\" where ID = ?");
                    s2.setInt(1, curShowId);
                    ResultSet rs2 = s2.executeQuery();
                    if(rs2.next()){
                        Ticket ticket=new Ticket(curShowId,
                                        rs2.getString("SHOW_NAME"),
                                        rs2.getString("DATE"),
                                        rs2.getString("HOUR"),
                                        row,col);
                        showToSeats.add(ticket);
                    }
                    //    public Ticket(int id, String name,String date,String time,int row, int col) {
                }
                catch(SQLException e){
                    System.out.println(e);
                }   

            }
            System.out.print(cnt);
            return showToSeats;
        }
        catch(SQLException e){
            System.out.println(e);
        }
         return null;
    }
    
}
