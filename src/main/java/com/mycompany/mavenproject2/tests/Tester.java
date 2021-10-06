/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.tests;

/**
 *
 * @author HP
 */

import com.mycompany.mavenproject2.DB.DBConnector;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Tester {
    
    private static DBConnector dbConnector;
    public static void main(String[] args) throws SQLException{
        String s = RandomStringUtils.randomAlphanumeric(8);


            Statement statement = dbConnector.getStatement();
            ResultSet rs = statement.executeQuery("select id from users where id = user.id");// todo write query

    }
    
}
