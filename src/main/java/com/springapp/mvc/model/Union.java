package com.springapp.mvc.model;

/**
 * Created by hujiaxuan on 2015/7/3.
 */
public class Union {
    public UserPD user;
    public Weibo weibo;

    public UserPD getUser() {
        return user;
    }

    public void setUser(UserPD user) {
        this.user = user;
    }

    public Weibo getWeibo() {
        return weibo;
    }

    public void setWeibo(Weibo weibo) {
        this.weibo = weibo;
    }
}
