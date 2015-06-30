package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.service.FollowServiceImpl;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
public class TestFollowService {
    public static void main(String[] args){
        List<UserPD> userlist;
        userlist = new FollowServiceImpl().GetFansList("胡家煊");
        for(UserPD user:userlist){
            System.out.println(user.user_name);
        }
    }
}
