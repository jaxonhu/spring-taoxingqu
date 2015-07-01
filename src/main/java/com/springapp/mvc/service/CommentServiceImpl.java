package com.springapp.mvc.service;

import com.springapp.mvc.dao.CommentDao;
import com.springapp.mvc.dao.CommentDaoImpl;
import com.springapp.mvc.model.Comment;
import com.springapp.mvc.util.PageModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/7/1.
 */
public class CommentServiceImpl implements CommentService {
    public CommentDao commentDao = new CommentDaoImpl();
    public int isNextPageExists;
    public Date date;
    public long time_num;
    public SimpleDateFormat dateFormat;
    @Override
    public boolean CommentPublish(Map<String, Object> map) {
        String comment_id="";
        String comment =(String)map.get("content");
        String tao_id = (String)map.get("tao_id");
        String user_id = (String)map.get("user_id");
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(date);
        time_num = date.getTime();
        comment_id = user_id +"_c_" +time_num;
        Comment com = new Comment(comment_id,comment,currentTime,user_id,tao_id);
        boolean res = commentDao.comment_insert(com);
        return res;
    }

    @Override
    public List<Comment> GetCommentByTaoid(int index, String tao_id) {
        List<Comment> results;
        List<Comment> records = commentDao.getCommentByTaoid(tao_id);
        PageModel<Comment> pageModel = new PageModel<Comment>(index,records,4);
        results = pageModel.getPageList();
        isNextPageExists = pageModel.isNextPageExist();
        return results;
    }

    @Override
    public int isNextPageExists() {
        return isNextPageExists;
    }
}
