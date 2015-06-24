package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.WeiboServiceImpl;
import com.springapp.mvc.util.DuplicateException;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class TestWeibo {
    public static void main(String[] args){
        Weibo wb = new Weibo("13245678","hello world!","C:/",13);
        new WeiboServiceImpl().WeiboPublish(wb);
    }
}
