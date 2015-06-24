package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.util.DuplicateException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/17.
 */
public class UserDA {

    static Connection aConnection;
    static java.sql.Statement aStatement;
    static UserPD auser;
    static String url = "jdbc:mysql://localhost:3306/tao_interest";
    static String name;
    static String pwd;
    public static Connection getConnection(){
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



    public static int insert(UserPD user)throws DuplicateException {
        name = user.getName();
        pwd = user.getPwd();
        String sql = "insert into user(user_name,password) values('"+name+"','"+pwd+"')";
        System.out.println(sql);
        UserPD c = select(name);
        if(c == null){
            try{
                int result = aStatement.executeUpdate(sql);

            }catch (SQLException e){
                System.out.println(e);
            }
            return 1;
        }else{
            return 0;
        }
    }
    public static void delete(int id) {

    }
    public static void update(UserPD user) {

    }
    public  static UserPD select(String name){
        auser = null;
        String sql = "select user_name,password from user where user_name ='"
                    +name+"'";
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            boolean gotIt = rs.next();
            if(gotIt){
                name = rs.getString(1);
                pwd = rs.getString(2);
                auser = new UserPD(name,pwd);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return auser;
    }
    public List find() {
        return null;
    }
    public UserPD selectByName(String name, String pwd) {
        return null;
    }
    public static void terminate(){
        try{
            aStatement.close();
            aConnection.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

}
