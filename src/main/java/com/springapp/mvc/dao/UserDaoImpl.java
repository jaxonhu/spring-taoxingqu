package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.util.DuplicateException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/17.
 */
public class UserDaoImpl extends BaseDao implements UserDao{

    public UserPD auser=null;
    public String user_name;
    public String user_pwd;
    public String user_id;
    public String email;
    public String register_time;
    public String face_url;
    @Override
    public UserPD UserSelect(String user_name) {
        String sql = "select user_id,user_name,password,email,register_time,face_url from user" +
                " where user_name='"+user_name+"'";
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            if(rs.next()){
                user_id = rs.getString(1);
                user_name = rs.getString(2);
                user_pwd = rs.getString(3);
                email = rs.getString(4);
                register_time = rs.getString(5);
                face_url = rs.getString(6);
                auser = new UserPD(user_id,user_name,user_pwd,email,register_time);
                auser.setFace_url(face_url);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return auser;
    }

    @Override
    public boolean UserInsert(UserPD user) {

        user_id = user.user_id;
        user_name = user.user_name;
        user_pwd = user.user_pwd;
        email = user.Email;
        register_time = user.register_time;
        face_url = user.face_url;
        String sql = "insert into user(user_id,user_name,password,email,register_time,face_url) " +
                "values('"+user_id+"','"+user_name+"','"+user_pwd+"','"+email+"','"+register_time+"','"+face_url+"')";
        String sql2 = "insert into following(user_id1,user_id2) values('"+user_name+"','"+user_name+"'";
        System.out.println(sql);
        UserPD auser = UserSelect(user_name);
        if(auser == null){
            try{
                int result = aStatement.executeUpdate(sql);
                int result2= aStatement.executeUpdate(sql2);
            }catch(SQLException e){
                System.out.println(e);
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean UserFaceInsert(String user_name,String url) {
        String sql = "update user set face_url='"+url+"' where user_name='"+user_name+"'";
        this.getaConnection();
        try{
            int res = aStatement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e);
            this.terminate();
            return false;
        }
        this.terminate();
        return true;
    }
}
