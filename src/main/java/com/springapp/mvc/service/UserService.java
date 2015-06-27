package com.springapp.mvc.service;

import java.util.Date;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/27.
 */
public interface UserService {
    public boolean  UserLogin(String user_name,String user_pwd); //用户登录
    public boolean  UserRegister(Map<String,Object> map); //用户注册
    public String   GetUserRegisterTime();//获得用户注册时间
    public String GetUserId(String user_name);//生成用户注册ID
}
