package com.springapp.mvc.model;

import java.io.Serializable;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class Weibo implements Serializable {

    public String tao_id; //微博id
    public String wb_content;//微博内容
    public String picture_id;//图片url
    public int thumb_on;//点赞个数

    public Weibo(String tao_id, String wb_content, String picture_id, int thumb_on) {
        this.tao_id = tao_id;
        this.wb_content = wb_content;
        this.picture_id = picture_id;
        this.thumb_on = thumb_on;
    }

    public String getTao_id() {
        return tao_id;
    }

    public void setTao_id(String tao_id) {
        this.tao_id = tao_id;
    }

    public String getWb_content() {
        return wb_content;
    }

    public void setWb_content(String wb_content) {
        this.wb_content = wb_content;
    }

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public int getThumb_on() {
        return thumb_on;
    }

    public void setThumb_on(int thumb_on) {
        this.thumb_on = thumb_on;
    }
}
