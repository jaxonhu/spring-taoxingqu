package com.springapp.mvc.controller;

import com.springapp.mvc.service.FollowServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by hujiaxuan on 2015/6/29.
 * 用户点击关注
 */
@Controller
public class FollowingController {
    @RequestMapping("/following")
    public @ResponseBody String following(HttpServletRequest request,HttpSession session){

        String user_id = request.getParameter("user_name");
        String myname =(String)session.getAttribute("user_name");
        String data = "";
        boolean res = new FollowServiceImpl().follow_do(user_id,myname);
        if(res){
            data="关注成功";
        }else{
            data="关注失败";
        }
        System.out.println(user_id);
        return data;
    }
}
