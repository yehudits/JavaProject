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
import java.util.List;

/**
 *
 * @author HP
 */
public class SeatsService {
    
    private DBConnector dbConnector;
    
    public SeatsService(){
        dbConnector = new DBConnector();
       
        
    }
    
    public List<Seat> getAllSeatsForShow(int showId){
        List<Seat> seats = new ArrayList();
         try{
            Connection c = dbConnector.getConnection();
            PreparedStatement s = c.prepareStatement("select * from seats where show_id = ?");
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
    
}
