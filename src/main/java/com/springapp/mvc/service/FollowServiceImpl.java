package com.springapp.mvc.service;

import com.springapp.mvc.dao.FollowDao;
import com.springapp.mvc.dao.FollowDaoImpl;
import com.springapp.mvc.dao.UserDaoImpl;
import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.util.PageModel;
import org.hsqldb.rights.User;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public class FollowServiceImpl implements FollowService {
    public FollowDao followDao = new FollowDaoImpl();
    public int isNextPageExists;
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
    public List<UserPD> GetFollowList(int index,String user_id2){
        String face_url="";
        List<UserPD> results;
        List<UserPD> records = followDao.GetFollowList(user_id2);
        PageModel<UserPD> pageModel = new PageModel<UserPD>(index,records,10);
        results = pageModel.getPageList();
        for(UserPD u:results){
            face_url = new UserDaoImpl().GetUserFaceUrl(u.user_name);
            u.setFace_url(face_url);
        }
        isNextPageExists = pageModel.isNextPageExist();
        return results;
    }

    @Override
    public List<UserPD> GetFansList(int index,String user_id1) {
        String face_url="";
        List<UserPD> results;
        List<UserPD> records = followDao.GetFansList(user_id1);
        PageModel<UserPD> pageModel = new PageModel<UserPD>(index,records,10);
        results = pageModel.getPageList();
        for(UserPD u:results){
            face_url = new UserDaoImpl().GetUserFaceUrl(u.user_name);
            u.setFace_url(face_url);
        }
        isNextPageExists = pageModel.isNextPageExist();
        return results;
    }

    @Override
    public int isNextPageExists() {
        return isNextPageExists;
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
