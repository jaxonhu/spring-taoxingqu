package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserPD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public class FollowDaoImpl extends BaseDao implements FollowDao {



    @Override
    public boolean follow_insert(String user_id1, String user_id2) {

        String sql = "insert into following(user_id1,user_id2) values('"+user_id1+"','"+user_id2+"')";

        Boolean r = follow_select(user_id1,user_id2);

        if(r){
            return false; //插入失败，已经关注
        }else{
            try{
                int result =aStatement.executeUpdate(sql);
                return true;//插入成功
            }catch(SQLException e){
                System.out.println(e);
                return false;
            }
        }
    }

    @Override
    public boolean follow_delete(String user_id1, String user_id2) {

        String sql= "delete  from following where user_id1='"+user_id1+"' and user_id2='"+user_id2+"'";
        this.getaConnection();
        try{
            int result = aStatement.executeUpdate(sql);
            this.terminate();
            return true; //删除成功s
        }catch (SQLException e){
            System.out.println(e);
        }
        this.terminate();
        return false; //删除失败
    }

    @Override
    public boolean follow_select(String user_id1, String user_id2) { //返回true表示已经关注，false表示未关注
        String sql = "select user_id1 from following where user_id2 ='"+user_id2+"'";
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            if(rs.next()){
                if(user_id1.equals(rs.getString(1))){
                    rs.close();
                    return true;
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return false;
    }

    @Override
    public List<UserPD> GetFollowList(String user_id2) {
        List<UserPD> records = new ArrayList<UserPD>();
        String user_name;
        String face_url;
        String sql = "select user_id1,face_url from following where user_id2 ='"+user_id2+"'";

        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            while(rs.next()){
                user_name = rs.getString(1);
                face_url = rs.getString(2);
                UserPD user = new UserPD("",user_name,"","","");
                user.setFace_url(face_url);
                records.add(user);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        return records;
    }

    @Override
    public List<UserPD> GetFansList(String user_id1) {
        List<UserPD> records = new ArrayList<UserPD>();
        String user_name;
        String sql = "select user_id2 from following where user_id1 ='"+user_id1+"'";

        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            while(rs.next()){
                user_name = rs.getString(1);
                UserPD user = new UserPD("",user_name,"","","");
                records.add(user);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        return records;
    }

    @Override
    public int GetFollowNum(String user_id2) {
        String sql = "select count(1) from following where user_id2='"+user_id2+"'";
        int num = 0;
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            if(rs.next()){
                num = rs.getInt(1);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        this.terminate();
        return num-1;
    }

    @Override
    public int GetFansNum(String user_id1) {
        String sql = "select count(1) from following where user_id2='"+user_id1+"'";
        int num = 0;
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            if(rs.next()){
                num = rs.getInt(1);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        this.terminate();
        return num-1;
    }
}
