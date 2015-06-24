package com.springapp.mvc.service;

import com.springapp.mvc.model.Weibo;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public interface WeiboService {
    public boolean WeiboPublish(Weibo wb);//发表微博
    public List<Weibo> GetWeibo(int index);//获取微博列表
}
