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


    public boolean signIn(User user){
        //validate user name and password
        boolean isUserAllowed = false;
        Statement statement = null;
        try {
            if(dbConnector == null){
                dbConnector = new DBConnector();
            }
            statement = dbConnector.getStatement();
            ResultSet rs = statement.executeQuery("select * from USER where name = '"+user.getName()+"' and password = '"+user.getPassword()+"'");// todo write query

//            ResultSet rs = statement.executeQuery("select id from user");// todo write query

            while(rs.next()){
                isUserAllowed = true;
            }
            
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally{
            if(statement!= null){
                try{
                    statement.close(); 
                }
               catch(SQLException E){
                   
               }
            }
        }
        return isUserAllowed;
    }


    public boolean signUp(User user){
        //validate email address
        boolean isSignUpSuccedded = false;
        try {
               if(dbConnector == null){
                dbConnector = new DBConnector();
            }
            Statement statement = dbConnector.getStatement();
            String queryString = "insert into  app.\"USER\"  (NAME, EMAIL, PASSWORD, USERTYPE) VALUES ('" 
                    + user.getName()+"','"
                    + user.getEmail()+"','"
                    + user.getPassword()+"', false)";

            statement.executeUpdate(queryString);// todo write query
            isSignUpSuccedded = true;
        }
        catch (Exception e){
            System.out.println(e);
        }

        return isSignUpSuccedded;
    }


}
