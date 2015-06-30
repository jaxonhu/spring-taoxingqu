package com.springapp.mvc.service;

import com.springapp.mvc.dao.FollowDao;
import com.springapp.mvc.dao.FollowDaoImpl;
import com.springapp.mvc.model.UserPD;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public class FollowServiceImpl implements FollowService {
    public FollowDao followDao = new FollowDaoImpl();
    @Override
    public boolean follow_do(String user_id1, String user_id2) {

        boolean result = followDao.follow_insert(user_id1,user_id2);
        return result;
    }

    @Override
    public boolean follow_cancel(String user_id1, String user_id2) {


        boolean result = followDao.follow_delete(user_id1,user_id2);
        return result;
    }

    @Override
    public List<UserPD> GetFollowList(String user_id2) {

        List<UserPD> records = followDao.GetFollowList(user_id2);

        return records;
    }

    @Override
    public List<UserPD> GetFansList(String user_id1) {
        List<UserPD> records = followDao.GetFansList(user_id1);
        return records;
    }

    @Override
    public int GetFollowNum(String user_id2) {
        int num = 0;
        num = followDao.GetFollowNum(user_id2);
        return num;
    }

    @Override
    public int GetFansNum(String user_id1) {
        int num = 0;
        num = followDao.GetFansNum(user_id1);
        return num;
    }

    @Override
    public boolean Check_follow(String user_id2, String user_id1) {
        boolean result;
        result = followDao.follow_select(user_id1,user_id2);
        return result;
    }
}
