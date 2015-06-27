package com.springapp.mvc.dao;

import com.springapp.mvc.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/27.
 */
public class TestLoginandRegister {
    public static void main(String[] args){
        String user_name = "胡家煊";
        String user_pwd = "vensli";
        String email = "370403444@qq.com";
        Map<String,Object> map = new HashMap<String, Object>(3);
        map.put("user_name",user_name);
        map.put("user_pwd",user_pwd);
        map.put("email",email);
        boolean result = new UserServiceImpl().UserLogin(user_name,user_pwd);
        //boolean result = new UserServiceImpl().UserRegister(map);

        if(result){
            System.out.println("用户注册成功");
        }else{
            System.out.println("用户注册失败");
        }
    }
}
