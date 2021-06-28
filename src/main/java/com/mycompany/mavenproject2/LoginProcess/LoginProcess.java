package LoginProcess;

import DB.DBConnector;
import DataLayer.User;

import java.sql.SQLException;
import java.sql.Statement;

public class LoginProcess {

    private DBConnector dbConnector;

    public LoginProcess(){

    }


    public void signIn(User user){
        //validate user name and password
        try {
            Statement statement = dbConnector.getStatement();
            statement.executeQuery("select id from users where id = user.id");// todo write query

        }
        catch (Exception e){
            System.out.println(e);
        }

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
