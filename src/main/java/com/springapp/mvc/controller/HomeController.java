package com.springapp.mvc.controller;
import com.springapp.mvc.dao.WeiboDaoImpl;
import com.springapp.mvc.model.Union;
import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/23.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public ModelAndView setView(HttpServletRequest request){

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
        List<Union> records2 = wbService.GetPageByIndex(index,"basketball","kkk");
        int isNext = wbService.IsNextPageExist();

        mv.addObject("weiboList",records2);
        mv.addObject("isNextPage",isNext);
        mv.addObject("index",index);
        mv.setViewName("home");

        return mv;
    }

    @RequestMapping(value = "/homes",method=RequestMethod.GET)
    public ModelAndView setPage(HttpServletRequest httpServletRequest,Model model,HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView();
//        String user_name = new String(httpServletRequest.getParameter("user_name").getBytes("ISO8859-1"), "UTF-8");
        String user_name;
        String face_url="";
        UserService userService = new UserServiceImpl();
        String page = httpServletRequest.getParameter("page");
        String tag  = httpServletRequest.getParameter("tag");
        String name = (String)session.getAttribute("user_name");
        face_url = userService.GetUserFaceUrl(name);
        if(tag.equals("")){
            user_name = (String)session.getAttribute("user_name");
        }else{
            tag =new String(tag.getBytes("ISO8859-1"),"UTF-8");
            user_name = "";
        }
        int index = Integer.parseInt(page);
        WeiboServiceImpl wbService = new WeiboServiceImpl();
        FollowService followService = new FollowServiceImpl();
        List<Union> records2 = wbService.GetPageByIndex(index,tag,user_name);
        int isNext = wbService.IsNextPageExist();
        int weibo_num = wbService.GetWeiboNum(name);
        int follow_num = followService.GetFollowNum(name);
        int fans_num = followService.GetFansNum(name);
        user_name =  (String)session.getAttribute("user_name");
        mv.addObject("UnionList",records2);
        mv.addObject("isNextPage",isNext);
        mv.addObject("user_name",user_name);
        mv.addObject("index",index);
        mv.addObject("tag",tag);
        mv.addObject("weibo_num",weibo_num);
        mv.addObject("follow_num",follow_num);
        mv.addObject("fans_num",fans_num);
        mv.addObject("face_url",face_url);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping(value = "/homes/{tag}")
    public ModelAndView setPageByTag(@PathVariable String tag){
        ModelAndView mv = new ModelAndView();
        return mv;
    }


}
