package com.springapp.mvc.dao;

import com.springapp.mvc.model.Comment;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/7/1.
 */
public class CommentDaoImpl extends BaseDao implements  CommentDao{
    public String comment_id;
    public String comment_content = "";
    public String tao_id2 = "";
    public String time = "";
    public String user_id = "";
    public String face_url="";
    @Override
    public Boolean comment_insert(Comment comment) {
        comment_id = comment.getComment_id();
        comment_content = comment.getComment();
        tao_id2 = comment.getTao_id();
        time = comment.getTime();
        user_id = comment.getUser_id();
        face_url = comment.getUser_face_url();
        String sql = "insert into comment(comment_id,comment,tao_id,time,user_id,face_url) " +
                "values('"+comment_id+"','"+comment_content+"','"+tao_id2+"','"+time+"','"+user_id+"','"+face_url+"')";
        this.getaConnection();
        try{
            int res = aStatement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e);
            this.terminate();
            return  false;
        }
        this.terminate();
        return true;
    }

    @Override
    public List<Comment> getCommentByTaoid(String tao_id){
        List<Comment> records = new ArrayList<Comment>();

        String sql = "select comment_id,comment,tao_id,time,user_id,face_url from comment where tao_id='"+tao_id+"'"+"ORDER BY time ASC ";
        this.getaConnection();
        try{
            ResultSet rs = aStatement.executeQuery(sql);
            while(rs.next()){
                comment_id = rs.getString(1);
                comment_content = rs.getString(2);
                tao_id2 = rs.getString(3);
                time = rs.getString(4);
                user_id = rs.getString(5);
                face_url = rs.getString(6);
                Comment co = new Comment(comment_id,comment_content,time,user_id,tao_id2);
                co.setUser_face_url(face_url);
                records.add(co);
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        this.terminate();
        return records;
    }

    @Override
    public Boolean comment_delete(String tao_id) {
        return null;
    }
}
