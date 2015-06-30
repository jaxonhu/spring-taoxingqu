package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserPD;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public interface FollowDao {
    public boolean follow_insert(String user_id1,String user_id2);
    public boolean follow_delete(String user_id1,String user_id2);//
    public boolean follow_select(String user_id1,String user_id2);//查看user_id2所关注的人中是否有user_id1
    public List<UserPD> GetFollowList(String user_id2);//获得关注列表
    public List<UserPD> GetFansList(String user_id1);//获得粉丝列表
    public int GetFollowNum(String user_id2);//获取关注人数
    public int GetFansNum(String user_id1);//获取粉丝人数

}
