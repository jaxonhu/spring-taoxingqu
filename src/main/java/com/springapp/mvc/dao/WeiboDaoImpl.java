package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
/*
6-25 16:39 生成时间
            mysql 存入汉字
 */
public class WeiboDaoImpl extends BaseDao implements WeiboDao  {

    public String currentTime;
    public SimpleDateFormat dateFormat;
    public String tao_id; //微博id
    public String wb_content;//微博内容
    public String picture_id;//图片url
    public int thumb_on;//点赞个数
    public String user_id;
    public String interest_id;


    @Override
    public Boolean saveWeibo(Weibo wb)throws DuplicateException{

        this.getaConnection();
        tao_id = wb.tao_id;
        wb_content = wb.wb_content;
        picture_id = wb.picture_id;
        thumb_on = wb.thumb_on;
        currentTime = wb.time;
        user_id = wb.user_id;
        interest_id = wb.interest_id;

        String sql = "insert into weibo(tao_id,content,picture_id,thumb_on,time,user_id,interest_id)" +
                " values('"+tao_id+"','"+wb_content+"','"+picture_id+"',"+thumb_on+",'"+currentTime+"','"+user_id+"','"+interest_id+"')";
        try{
            int result = aStatement.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
        this.terminate();
        return null;
    }

    @Override
    public List<Weibo> getWeiboRecords(String tag, String user_id) {
        List<Weibo> records = new ArrayList<Weibo>();

        String tao_id;
        String picture_id;
        int thumb_on;
        String time;
        String userid;
        String content;
        String interest_id;

        String sql = null;
        if(tag.equals("")){
            sql = "select tao_id,picture_id,thumb_on,time,user_id,interest_id,content from weibo " +
                    "where user_id in ( select user_id1 from following where user_id2 = '"+user_id+"') " +
                    "ORDER BY time DESC";
        }else{
            sql = "select tao_id,picture_id,thumb_on,time,user_id,interest_id,content from weibo " +
                    "where interest_id='"+tag+"' ORDER BY time DESC";
        }
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            while(rs.next()){
                tao_id = rs.getString(1);
                picture_id = rs.getString(2);
                thumb_on = rs.getInt(3);
                time = rs.getString(4);
                user_id = rs.getString(5);
                interest_id = rs.getString(6);
                content = rs.getString(7);
                Weibo wb = new Weibo(tao_id,content,picture_id,thumb_on,time,user_id,interest_id);
                records.add(wb);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return records;
    }

    @Override
    public Boolean getWeiboList(int index) {

        return null;
    }

    @Override
    public List<Weibo> getWeiboRecordsByUser(String tag, String user_id){
        List<Weibo> records = new ArrayList<Weibo>();

        String tao_id;
        String picture_id;
        int thumb_on;
        String time;
        String userid;
        String content;
        String interest_id;

        String sql = "select tao_id,picture_id,thumb_on,time,user_id,interest_id,content from weibo " +
                "where user_id ='"+user_id+"'";
//        if(tag.equals("")){
//            sql = "select tao_id,picture_id,thumb_on,time,user_id,interest_id,content from weibo " +
//                    "where user_id in ( select user_id1 from following where user_id2 = '"+user_id+"') " +
//                    "ORDER BY time DESC";
//        }
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            while(rs.next()){
                tao_id = rs.getString(1);
                picture_id = rs.getString(2);
                thumb_on = rs.getInt(3);
                time = rs.getString(4);
                user_id = rs.getString(5);
                interest_id = rs.getString(6);
                content = rs.getString(7);
                Weibo wb = new Weibo(tao_id,content,picture_id,thumb_on,time,user_id,interest_id);
                records.add(wb);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return records;
    }

    @Override
    public int getWeiboNum(String user_id) {
        int num=0;
        String sql = "select count(1) from weibo where user_id ='"+user_id+"'";
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
        return num;
    }
}
