package com.springapp.mvc.service;

import com.springapp.mvc.model.UserPD;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public interface FollowService {
    public boolean follow_do(String user_id1,String user_id2);//user_id2关注user_id1
    public boolean follow_cancel(String user_id1,String user_id2);//user_id2取消关注user_id1
    public List<UserPD> GetFollowList(String user_id2);
    public List<UserPD> GetFansList(String user_id1);
    public int GetFollowNum(String user_id2);//获得关注人数
    public int GetFansNum(String user_id1);//获得粉丝人数
    public boolean Check_follow(String user_id2,String user_id1);//检查id2是否已经关注id1
}
