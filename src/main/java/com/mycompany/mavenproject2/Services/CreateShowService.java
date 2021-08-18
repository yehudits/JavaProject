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
        
        //boolean isCreateShowSuccedded = false;

        try {
         /*      if(dbConnector == null){
                dbConnector = new DBConnector();
            }/*try
            Statement statement = dbConnector.getStatement();
            String queryString = "insert into  app.\"SHOW\"  (ID,OWNER, DESCRIPTION, ADDRESS, ROWS_NUM, COLUMNS, PRICE, SHOW_NAME, DATE) VALUES (3,'" 
                    + s.getOwnerId()+",'"
                    + s.getDescription()+"','"
                    + s.getAdress()+"',"
                    + s.getRows()+","
                    + s.getColumns()+","
                    + s.getPrice()+",'"
                    + s.getName()+"',"
                    + Date.valueOf(s.getDate())+")";

            statement.executeUpdate(queryString);// todo write query
            isCreateShowSuccedded = true;
        }
        catch (Exception e){
            System.out.println(e);
        }*/
         
            Connection conn = this.dbConnector.getConnection();
            String query = " insert into  app.\"SHOW\"   (OWNER, DESCRIPTION, ADDRESS, ROWS_NUM, COLUMNS ,PRICE ,DATE ,SHOW_NAME)"
            + " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, s.getOwnerId());
            preparedStmt.setString(2,s.getDescription());
            preparedStmt.setString(3,s.getAdress());
            preparedStmt.setInt (4, s.getRows());
            preparedStmt.setInt (5, s.getColumns());
            preparedStmt.setInt (6, s.getPrice());
            preparedStmt.setDate (7, Date.valueOf(s.getDate()));
            preparedStmt.setString (8, s.getName());
            preparedStmt.execute();
            
            conn.close();
           
            return true;
        }
        catch(SQLException e){
            System.out.println(e);
        }    
        return false;
    }
    
}
