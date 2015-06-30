package com.springapp.mvc.service;

import com.springapp.mvc.model.Weibo;

import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public interface WeiboService {
    public boolean WeiboPublish(Map<String,Object> map);//发表微博
    public List<Weibo> GetWeibo(int index);//获取微博列表
    public List<Weibo> GetPageByIndex(int index,String tag,String user_id);//获取全部微博
    public List<Weibo> GetPageByUser(int index,String tag,String user_id);//获取自己的微博
    public int IsNextPageExist();
    public int GetWeiboNum(String user_id);//获取用户微博数量

}
