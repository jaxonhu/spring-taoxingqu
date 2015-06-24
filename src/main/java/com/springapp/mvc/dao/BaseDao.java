package com.springapp.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hujiaxuan on 2015/6/24.
 */

public class BaseDao {
    public Connection aConnection;
    public Statement aStatement;
    public String url = "jdbc:mysql://localhost:3306/tao_interest";
    public  Connection getaConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "";
            aConnection = DriverManager.getConnection(url, username, password);
            aStatement = aConnection.createStatement();
            System.out.println("connect success");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println(e);
        }
        return aConnection;
    }

    public  void terminate(){
        try{
            aStatement.close();
            aConnection.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
