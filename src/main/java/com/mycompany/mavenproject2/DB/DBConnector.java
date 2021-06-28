package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
  //it is a singleton
  private Connection conn = null;

    private DBConnector() throws SQLException {
        String url = "jdbc:sqlite:C:/sqlite/db/test.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);
    }





    public Statement getStatement() throws SQLException {
        if (conn== null){
            new DBConnector();
        }
        Statement s =conn.createStatement();
        return s;
    }


}
