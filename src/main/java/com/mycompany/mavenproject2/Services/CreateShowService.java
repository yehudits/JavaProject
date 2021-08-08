/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Services;

import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.Show;
import java.sql.*;
import java.sql.Date;


public class CreateShowService {
    private DBConnector dbConnector;

    public CreateShowService(){
        dbConnector = new DBConnector();
    }
    
    public boolean addShowService(Show s){
        
        String str = s.getDate();
        Date date;//converting string into sql date  
        date = Date.valueOf(str);


        try{
       
            //Statement st = this.dbConnector.getStatement();
            Connection conn = this.dbConnector.getConnection();
            String query = " insert into show (owner, description, address, rows_num, columns,price,date,show_name)"
            + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, s.getOwnerId());
            preparedStmt.setString(2,s.getDescription());
            preparedStmt.setString(2,s.getAdress());
            preparedStmt.setInt (1, s.getRows());
            preparedStmt.setInt (1, s.getColumns());
            preparedStmt.setInt (1, s.getPrice());
            preparedStmt.setDate (1, date);
            preparedStmt.setString (1, s.getName());
            preparedStmt.execute();
            
            conn.close();
           
            return true;
        }
        catch(SQLException e){
            System.out.println("e");
        }    
        return false;
    }
    
}
