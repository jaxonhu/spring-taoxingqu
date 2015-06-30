package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by hujiaxuan on 2015/6/29.
 */
@Controller
public class FollowingController {
    @RequestMapping("/following")
    public @ResponseBody boolean following(HttpServletRequest request,HttpSession session){

        String user_id = request.getParameter("user_name");
        String myname =(String)session.getAttribute("user_name");



        System.out.println(user_id);
        return true;
    }


}
