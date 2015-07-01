package com.springapp.mvc.controller;

import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.service.FollowService;
import com.springapp.mvc.service.FollowServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/28.
 */
@Controller
public class FollowController{
    @RequestMapping(value = "/follow",method = RequestMethod.GET)
    public ModelAndView start(HttpServletRequest request)throws Exception{
        ModelAndView mv = new ModelAndView();

        String page = request.getParameter("page");
        String user_name = request.getParameter("user_id");
        user_name=new String(user_name.getBytes("ISO8859-1"),"UTF-8");
        int index = Integer.parseInt(page);
        List<UserPD> records;
        FollowService followService = new FollowServiceImpl();
        records=followService.GetFollowList(index, user_name);
        int isNext = followService.isNextPageExists();

        mv.addObject("FollowList",records);
        mv.addObject("index",index);
        mv.addObject("user_name",user_name);
        mv.addObject("isNextPage",isNext);
        mv.setViewName("follow");
        return mv;
    }
}
