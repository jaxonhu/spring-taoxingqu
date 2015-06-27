package com.springapp.mvc.model;

import java.util.Date;

/**
 * Created by hujiaxuan on 2015/6/17.
 */
public class UserPD {
    public String  user_id;
    public String user_name;
    public String user_pwd;
    public String Email;
    public String register_time;

    public UserPD(String user_id, String user_name, String user_pwd, String email, String register_time) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        Email = email;
        this.register_time = register_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }
}
