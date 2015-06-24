package com.springapp.mvc.model;

/**
 * Created by hujiaxuan on 2015/6/17.
 */
public class UserPD {
    private int id;
    private String name;
    private String pwd;

    public UserPD(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public UserPD(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
    public UserPD(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
