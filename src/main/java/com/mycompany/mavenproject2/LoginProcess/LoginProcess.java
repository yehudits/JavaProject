    package com.mycompany.mavenproject2.LoginProcess;


import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.User;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Inject;

public class LoginProcess {
    @Inject private DBConnector dbConnector;


    public LoginProcess(){
    }


    public void signIn(User user){
        //validate user name and password
//        Statement statement = null;
//        try {
//            if(dbConnector == null){
//                dbConnector = new DBConnector();
//            }
//            statement = dbConnector.getStatement();
////            int i = statement.executeUpdate("insert into USERS (id, name, email, password, userType) values( 2, 'r', 'r', 'r', true)");// todo write query
//
//            ResultSet rs = statement.executeQuery("select id from users");// todo write query
//
//            while(rs.next()){
//                int id = rs.getInt("id");
//            }
//            
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//        finally{
//            if(statement!= null){
//                try{
//                    statement.close(); 
//                }
//               catch(SQLException E){
//                   
//               }
//            }
//        }

    }


    public void signUp(User user){
        //validate email address
        try {
            Statement statement = dbConnector.getStatement();
            statement.executeQuery("insert into");// todo write query
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


}
