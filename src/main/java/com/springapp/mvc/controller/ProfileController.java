package com.springapp.mvc.controller;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.WeiboServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/28.
 */
@Controller
public class ProfileController {
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView start(HttpServletRequest request)throws  Exception{
        ModelAndView mv = new ModelAndView();
        String user_name = new String(request.getParameter("user_id").getBytes("ISO8859-1"), "UTF-8");
        String page = request.getParameter("page");
        String tag = request.getParameter("tag");
        WeiboServiceImpl wbService = new WeiboServiceImpl();
        int index = Integer.parseInt(page);
        List<Weibo> records = wbService.GetPageByUser(index,tag,user_name);
        int isNext = wbService.IsNextPageExist();
        mv.addObject("weiboList",records);
        mv.addObject("isNextPage",isNext);
        mv.addObject("user_name",user_name);
        mv.addObject("index",index);
        mv.setViewName("profile");
        return mv;
    }
}
