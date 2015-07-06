package com.springapp.mvc.service;

import com.springapp.mvc.dao.WeiboDao;
import com.springapp.mvc.dao.WeiboDaoImpl;
import com.springapp.mvc.model.Union;
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
    public List<Union> GetPageByIndex(int index, String tag,String user_id) {

        List<Union> res;
        List<Weibo> results;
        List<Weibo> records = new WeiboDaoImpl().getWeiboRecords(tag,user_id);

        PageModel<Weibo> pageModel= new PageModel<Weibo>(index,records,5);
        results = pageModel.getPageList();
        res = new UserServiceImpl().GetUsersByWeibo(results);
        isNextPageExist = pageModel.isNextPageExist();
        return res;
    }

    @Override
    public int IsNextPageExist() {
        return isNextPageExist;
    }


    @Override
    public List<Union> GetPageByUser(int index, String tag, String user_id) {


        List<Weibo> results;
        List<Union> res;
        List<Weibo> records = new WeiboDaoImpl().getWeiboRecordsByUser(tag,user_id);

        PageModel<Weibo> pageModel= new PageModel<Weibo>(index,records,5);

        results = pageModel.getPageList();



        res = new UserServiceImpl().GetUsersByWeibo(results);
        isNextPageExist = pageModel.isNextPageExist();
        return res;
    }

    @Override
    public int GetWeiboNum(String user_id) {
        int num = 0;
        num = weiboDao.getWeiboNum(user_id);
        return num;
    }

    @Override
    public boolean GivePraise(String tao_id) {

        int thumb_on = weiboDao.getThumbon(tao_id);
        thumb_on +=1;
        int res = weiboDao.setThumbon(tao_id,thumb_on);
        return true;
    }

    @Override
    public boolean GiveDown(String tao_id) {

        int thumb_down = weiboDao.getThumbdown(tao_id);
        thumb_down +=1;
        int res = weiboDao.setThumbdown(tao_id,thumb_down);
        return true;
    }

    @Override
    public List<Union> GetSearchRes(String keywords){
        String[] arry;
        List<Union> res;
        arry = keywords.split("\\s+");
        for(String temp:arry){
            System.out.println(temp);
        }
        List<Weibo> records= weiboDao.getSearchRes(arry);
        res = new UserServiceImpl().GetUsersByWeibo(records);
        return res;
    }
}
