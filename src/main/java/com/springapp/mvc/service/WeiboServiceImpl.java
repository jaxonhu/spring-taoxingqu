package com.springapp.mvc.service;

import com.springapp.mvc.dao.WeiboDao;
import com.springapp.mvc.dao.WeiboDaoImpl;
import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;
import com.springapp.mvc.util.IdWorker;

import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class WeiboServiceImpl  implements WeiboService{

    public WeiboDao weiboDao = new WeiboDaoImpl();

    //发表微博
    @Override
    public boolean WeiboPublish(Map<String,Object> map) {

        String tao_id = (String)map.get("tao_id");
        String content = (String)map.get("content");
        int thumb_on = (Integer)map.get("thumb_on");
        String time = (String)map.get("time");
        String user_id = (String)map.get("user_id");
        String interest_id = (String)map.get("interest_id");
        String picture_id = (String)map.get("picture_id");

        IdWorker idWorker = new IdWorker(2);
        //tao_id = idWorker.nextId();
        Weibo wb = new Weibo(tao_id,content,picture_id,thumb_on,time,user_id,interest_id);
        try{
            weiboDao.saveWeibo(wb);
        }catch (DuplicateException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Weibo> GetWeibo(int index) {

        return null;
    }
}
