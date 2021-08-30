package com.mycompany.mavenproject2.LoginProcess;


import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.User;
import java.sql.ResultSet;
import com.mycompany.mavenproject2.Enums.UserType;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public class LoginProcess {
    @Inject private DBConnector dbConnector;
            public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static User user;
    private static boolean userType;
    
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
            String q = "select * from app.\"user\"  where \"name\" = '"+user.getName()+"' and \"password\" = '"+user.getPassword()+"'";
            ResultSet rs = statement.executeQuery(q);// todo write query
//            ResultSet rs = statement.executeQuery("select id from user");// todo write query

            while(rs.next()){
                isUserAllowed = true;
                String email = rs.getString("email");
                this.userType = rs.getBoolean("userType");
                int id = rs.getInt("id");
                this.user = new User(id,user.getName(),email,user.getPassword(),this.userType);
            }
            
            
            
            /*                shows.add(new Show(rs.getInt("id"),
                        rs.getString("show_name"),
                         rs.getString("address"),
                         rs.getString("date"),
                         rs.getInt("owner"),
                         rs.getString("description"),
                         rs.getInt("rows_num"),
                        rs.getInt("columns"),
                        rs.getInt("price")
*/
            
        }
        catch (SQLException e){
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }


    public boolean signUp(User user){
        //validate email address
        boolean isSignUpSuccedded = false;
        try {
               if(dbConnector == null){
                dbConnector = new DBConnector();
            }
            Statement statement = dbConnector.getStatement();
            String queryString = "insert into  App.\"user\" (\"name\",\"email\",\"password\",\"userType\") VALUES ('" 
                    + user.getName()+"','"
                    + user.getEmail()+"','"
                    + user.getPassword()+"', false)";

            statement.executeUpdate(queryString);// todo write query
            queryString = "select * from app.\"user\"  where \"name\" = '"+user.getName()+"' and \"email\" = '"+user.getEmail()+"'";
            ResultSet res = statement.executeQuery(queryString);// todo write query
            if(res.next()){
                this.user = new User(res.getInt("id"),res.getString("name"),user.getEmail(),user.getPassword(),res.getBoolean("userType"));
            }

            isSignUpSuccedded = true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        this.user=user;
        return isSignUpSuccedded;
    }
    
    public boolean isUserNameExist(String userName){
        Statement statement = null;
        boolean userNameExist = false;

        try{ if(dbConnector == null){
                dbConnector = new DBConnector();
            }
            statement = dbConnector.getStatement();
            String q = "select * from app.\"user\"  where \"name\" = '"+userName+"'";
            ResultSet rs = statement.executeQuery(q);
            while(rs.next()){
                return true;
            }
            int size = rs.getRow();
            if(size>0){
                userNameExist= true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return userNameExist;
    }

        public boolean isEmailAddressExist(String email){
        Statement statement = null;
        boolean emailExist = false;

        try{
             if(dbConnector == null){
                dbConnector = new DBConnector();
            }
            statement = dbConnector.getStatement();
            String q = "select * from app.\"user\"  where \"email\" = '"+email+"'";
            ResultSet rs = statement.executeQuery(q);
            while(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return emailExist;
    }
    
        public boolean isEmailValid(String email){


        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();

        }
    
        
    public int addAdmin(String name,String email){
        //Query search for user
        
        //Query update user
        Statement statement = null;
        try {
            if(dbConnector == null){
                dbConnector = new DBConnector();
            }
            statement = dbConnector.getStatement();

            String q = "select * from app.\"user\"  where \"name\" = '"+name+"' and \"email\" = '"+email+"'";
            ResultSet rs = statement.executeQuery(q);// todo write query
            while(rs.next()){
                try{
                    String q2 = "update app.\"user\" set \"userType\"=true where \"name\" ='"+name+"'and \"email\"='"+email+"'";
                    statement.executeUpdate(q2);// todo write query
                    return 1;//code for succeess
                }
                catch(SQLException e){
                    System.out.println(e);
                    return 3;
                }
            }
            return 2;
            

        }
        catch(Exception e){
            System.out.println(e);
        }
        return 3;//code for exception

    }

}
