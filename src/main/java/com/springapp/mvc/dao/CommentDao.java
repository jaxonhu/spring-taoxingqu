package com.springapp.mvc.dao;

import com.springapp.mvc.model.Comment;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/30.
 */
public interface CommentDao {
    public Boolean comment_insert(Comment comment);
    public List<Comment> getCommentByTaoid(String tao_id);
    public Boolean comment_delete(String tao_id);
}
