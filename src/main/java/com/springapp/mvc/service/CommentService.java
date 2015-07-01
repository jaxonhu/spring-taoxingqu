package com.springapp.mvc.service;

import com.springapp.mvc.model.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public interface CommentService {

    public boolean CommentPublish(Map<String,Object> map);//发表评论
    /*
    Map<String,Object>：
        String comment_id
        String comment
        String tao_id
        String time
        String user_id
     */
    public List<Comment> GetCommentByTaoid(int index,String tao_id);
    public int isNextPageExists();

}
