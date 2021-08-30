/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Services;

import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.Show;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ShowsListService {
    
    private DBConnector dbConnector;
    public ShowsListService(){
        dbConnector = new DBConnector();
    }
    
    public List<Show> getAllShows(){
         List<Show> shows = new ArrayList();
        try{
           
            Statement s = this.dbConnector.getStatement();
            ResultSet rs = s.executeQuery("select * from show where CURRENT_DATE <= date ");
            while (rs.next()){
                shows.add(new Show(rs.getInt("id"),
                        rs.getString("show_name"),
                         rs.getString("address"),
                         rs.getString("date"),
                         rs.getInt("owner"),
                         rs.getString("description"),
                         rs.getInt("rows_num"),
                        rs.getInt("columns"),
                        rs.getInt("price"),
                        rs.getString("IMAGE_URL"),
                        rs.getString("HOUR")
                ));
            }
    
        } catch(SQLException e){
            System.out.println("e");
        }

        return shows;
    }
    
}
