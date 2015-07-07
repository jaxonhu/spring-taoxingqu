package com.springapp.mvc.controller;

import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.service.FollowService;
import com.springapp.mvc.service.FollowServiceImpl;
import com.springapp.mvc.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/28.
 */
@Controller
public class FansController {
    @RequestMapping(value = "/fans",method = RequestMethod.GET)
    public ModelAndView start(HttpServletRequest request,HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView();
        String face_url="";
        String myname = (String)session.getAttribute("user_name");
        String page = request.getParameter("page");
        String user_name = request.getParameter("user_id");
        user_name=new String(user_name.getBytes("ISO8859-1"),"UTF-8");
        int index = Integer.parseInt(page);
        List<UserPD> records;
        FollowService followService = new FollowServiceImpl();
        records=followService.GetFansList(index, user_name);
        int isNext = followService.isNextPageExists();
        boolean res = new FollowServiceImpl().Check_follow(myname,user_name);
        if(res){
            mv.addObject("focus","yes");
        }else{
            mv.addObject("focus","no");
        }
        face_url = new UserServiceImpl().GetUserFaceUrl(user_name);
        mv.addObject("face_url",face_url);
        mv.addObject("FansList",records);
        mv.addObject("index",index);
        mv.addObject("user_name",user_name);
        mv.addObject("isNextPage",isNext);
        mv.setViewName("fans");
        return mv;
    }

}
