package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public interface WeiboDao {
    public Boolean saveWeibo(Weibo wb) throws DuplicateException;
    public Boolean getWeiboList(int index);
}
