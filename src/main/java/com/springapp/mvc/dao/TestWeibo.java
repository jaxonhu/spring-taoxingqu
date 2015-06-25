package com.springapp.mvc.dao;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.WeiboServiceImpl;
import com.springapp.mvc.util.DuplicateException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class TestWeibo {
    public static void main(String[] args){
        String content="啊啊啊啊啊啊啊啊啊啊啊啊啊啊";
        Map<String,Object> modelMap = new HashMap<String, Object>(7);
        modelMap.put("tao_id","IAMyours1995");
        modelMap.put("content", content);
        modelMap.put("thumb_on",3);
        modelMap.put("time","");
        modelMap.put("user_id",132456);
        modelMap.put("interest_id",978978);
        modelMap.put("picture_id","C:/");
       /*
       此处调用service层
        */

        new WeiboServiceImpl().WeiboPublish(modelMap);
    }
}
