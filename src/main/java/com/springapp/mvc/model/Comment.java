package com.springapp.mvc.model;

import java.util.Date;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public class Comment {
    private String comment_id;
    private String comment;
    private String time;
    private String user_id;
    private String tao_id;

    public Comment(String comment_id, String comment, String time, String user_id, String tao_id) {
        this.comment_id = comment_id;
        this.comment = comment;
        this.time = time;
        this.user_id = user_id;
        this.tao_id = tao_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTao_id() {
        return tao_id;
    }

    public void setTao_id(String tao_id) {
        this.tao_id = tao_id;
    }
}
