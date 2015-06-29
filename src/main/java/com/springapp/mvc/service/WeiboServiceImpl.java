package com.springapp.mvc.service;

import com.springapp.mvc.dao.WeiboDao;
import com.springapp.mvc.dao.WeiboDaoImpl;
import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;
import com.springapp.mvc.util.IdWorker;
import com.springapp.mvc.util.PageModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class WeiboServiceImpl  implements WeiboService{

    public WeiboDao weiboDao = new WeiboDaoImpl();
    public Date date;
    public SimpleDateFormat dateFormat;
    public long time_num;
    public int isNextPageExist;
    //发表微博
    @Override
    public boolean WeiboPublish(Map<String,Object> map) {

        String tao_id;
        String content = (String)map.get("content");
        int thumb_on = (Integer)map.get("thumb_on");
        String time = (String)map.get("time");
        String user_id = (String)map.get("user_id");
        String interest_id = (String)map.get("interest_id");
        String picture_id = (String)map.get("picture_id");
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(date);
        time_num = date.getTime();
        tao_id = user_id + time_num;
        Weibo wb = new Weibo(tao_id,content,picture_id,thumb_on,currentTime,user_id,interest_id);
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

    @Override
    public List<Weibo> GetPageByIndex(int index, String tag,String user_id) {

        List<Weibo> results;
        List<Weibo> records = new WeiboDaoImpl().getWeiboRecords(tag,user_id);
        PageModel<Weibo> pageModel= new PageModel<Weibo>(index,records,5);
        results = pageModel.getPageList();
        isNextPageExist = pageModel.isNextPageExist();
        return results;
    }

    @Override
    public int IsNextPageExist() {
        return isNextPageExist;
    }


    @Override
    public List<Weibo> GetPageByUser(int index, String tag, String user_id) {


        List<Weibo> results;
        List<Weibo> records = new WeiboDaoImpl().getWeiboRecords(tag,user_id);
        PageModel<Weibo> pageModel= new PageModel<Weibo>(index,records,5);
        results = pageModel.getPageList();
        isNextPageExist = pageModel.isNextPageExist();
        return results;
    }
}
