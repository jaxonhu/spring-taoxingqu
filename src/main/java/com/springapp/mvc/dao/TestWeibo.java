package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.WeiboServiceImpl;
import com.springapp.mvc.util.DuplicateException;

import java.util.*;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class TestWeibo {
    public static void main(String[] args){
        String content="啊啊啊啊啊啊啊啊啊啊啊啊啊啊";
        Map<String,Object> modelMap = new HashMap<String, Object>(7);
        modelMap.put("tao_id","");
        modelMap.put("content", "呵呵");
        modelMap.put("thumb_on",3);
        modelMap.put("time","");
        modelMap.put("user_id","Iamyours1995");
        modelMap.put("interest_id","12312311");
        modelMap.put("picture_id","C:/");
        String user_id = "kkk";
        String tag = "basketball";
       /*
       此处调用service层
        */
        //new WeiboServiceImpl().WeiboPublish(modelMap);
//        String sql = "select tao_id,picture_id,thumb_on,time,user_id,interest_id,content from weibo " +
//                "where user_id in ( select user_id1 from following where user_id2 = '"+user_id+"') " +
//                "and interest_id = '"+tag+"'";
//        System.out.println(sql);
        List<Weibo> records = new WeiboDaoImpl().getWeiboRecords("basketball","kkk");
        Iterator it = records.iterator();
        while(it.hasNext()){
            Weibo wb = (Weibo)it.next();
            System.out.println(wb.user_id);
        }

    }
}
