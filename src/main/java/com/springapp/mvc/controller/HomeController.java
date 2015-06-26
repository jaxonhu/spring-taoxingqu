package com.springapp.mvc.controller;
import com.springapp.mvc.dao.WeiboDaoImpl;
import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.WeiboServiceImpl;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/23.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public ModelAndView setView(){
        ModelAndView mv = new ModelAndView();
        int index;
        List<Weibo> weiboList = new ArrayList<Weibo>();//微博list  分页处理结果返回 List<Weibo>

//        Weibo wb1 = new Weibo("aaaaaaaaa","bbbbbbbbbb","ccccccccc",10,"ddddddd",
//                "eeeeeeee","fffffffffff");
//        Weibo wb2 = new Weibo("aaaaaaaaa","bbbbbbbbbb","ccccccccc",10,"ddddddd",
//                "eeeeeeee","fffffffffff");
//        weiboList.add(wb1);
//        weiboList.add(wb2);

       // List<Weibo> records = new WeiboDaoImpl().getWeiboRecords("basketball","kkk");

        index = 1;

        WeiboServiceImpl wbService = new WeiboServiceImpl();
        List<Weibo> records2 = wbService.GetPageByIndex(index,"basketball","kkk");
        int isNext = wbService.IsNextPageExist();

        mv.addObject("weiboList",records2);
        mv.addObject("isNextPage",isNext);
        mv.addObject("index",index);
        mv.setViewName("home");

        return mv;
    }
}
