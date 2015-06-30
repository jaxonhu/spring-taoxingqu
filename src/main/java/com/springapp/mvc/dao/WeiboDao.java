package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public interface WeiboDao {
    public Boolean saveWeibo(Weibo wb) throws DuplicateException;
    public Boolean getWeiboList(int index);
    public List<Weibo> getWeiboRecords(String tag,String user_id);
    public List<Weibo> getWeiboRecordsByUser(String tag,String user_id);
    public int getWeiboNum(String user_id);
}
