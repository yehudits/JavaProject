package com.mycompany.mavenproject2.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.inject.Singleton;


@Named
@Singleton
public class DBConnector {
  //it is a singleton  
    String url = "jdbc:derby://localhost:1527/BuyCardsProject";
        // create a connection to the database
  private static Connection conn;


  private static DBConnector db;



//    public static DBConnector creteDBConnector() throws SQLException {
//         if (db== null){
//            db = new DBConnector();
//        }
//         return db;
//    }

    public Connection getConnection(){
        if(conn==null){
            try{
                conn =  DriverManager.getConnection(url, "App", "App");

            }
            catch(SQLException E){
                System.err.println("E");
            }
        }
        return conn;
    }

    public Statement getStatement() throws SQLException{
        if(conn==null){
            try{
                conn =  DriverManager.getConnection(url, "App", "App");

            }
            catch(SQLException E){
                System.err.println("E");
            }
        }
        Statement s =conn.createStatement();
        return s;
    }


}
