package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserPD;

/**
 * Created by hujiaxuan on 2015/6/27.
 */
public interface UserDao {

    public UserPD UserSelect(String user_name);
    public Boolean UserInsert(UserPD user);


}