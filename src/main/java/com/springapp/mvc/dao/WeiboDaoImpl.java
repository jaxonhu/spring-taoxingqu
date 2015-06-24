package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class WeiboDaoImpl extends BaseDao implements WeiboDao  {

    public String tao_id; //微博id
    public String wb_content;//微博内容
    public String picture_id;//图片url
    public int thumb_on;//点赞个数

    @Override
    public Boolean saveWeibo(Weibo wb)throws DuplicateException{
        this.getaConnection();
        tao_id = wb.tao_id;
        wb_content = wb.wb_content;
        picture_id = wb.picture_id;
        thumb_on = wb.thumb_on;
        String sql = "insert into weibo(tao_id,content,picture_id,thumb_on)" +
                " values('"+tao_id+"','"+wb_content+"','"+picture_id+"','"+thumb_on+"')";
        try{
            int result = aStatement.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
        this.terminate();
        return null;
    }

    @Override
    public Boolean getWeiboList(int index) {

        return null;
    }

}
