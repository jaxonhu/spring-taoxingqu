package com.springapp.mvc.controller;

import com.springapp.mvc.util.DuplicateException;
import com.springapp.mvc.dao.UserDA;
import com.springapp.mvc.model.UserPD;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hujiaxuan on 2015/6/22.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView start(){
        ModelAndView mv = new ModelAndView();
        System.out.println("success");
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping("/login.do")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String name = httpServletRequest.getParameter("user_name");
        String pwd = httpServletRequest.getParameter("password");
        int flag;
        UserPD m = new UserPD(name,pwd);
        ModelAndView mv = new ModelAndView();
        UserDA.getConnection();
        try{
            flag = UserDA.insert(m);
        }catch (DuplicateException e){
            System.out.println(e);
        }
        UserDA.terminate();
        mv.addObject("name",m.getName());
        mv.addObject("name",m.getPwd());
        mv.setViewName("home");
        return mv;
    }
}
