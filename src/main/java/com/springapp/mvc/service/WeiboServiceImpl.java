package com.springapp.mvc.service;

import com.springapp.mvc.dao.WeiboDao;
import com.springapp.mvc.dao.WeiboDaoImpl;
import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.util.DuplicateException;

import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/24.
 */
public class WeiboServiceImpl  implements WeiboService{

    public WeiboDao weiboDao = new WeiboDaoImpl();

    //发表微博
    @Override
    public boolean WeiboPublish(Weibo wb) {
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
