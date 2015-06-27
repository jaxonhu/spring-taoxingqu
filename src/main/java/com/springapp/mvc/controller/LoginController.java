package com.springapp.mvc.controller;

import com.springapp.mvc.service.UserService;
import com.springapp.mvc.service.UserServiceImpl;
import com.springapp.mvc.util.DuplicateException;
import com.springapp.mvc.dao.UserDaoImpl;
import com.springapp.mvc.model.UserPD;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

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
        String  name = new String(httpServletRequest.getParameter("user_name").getBytes("ISO8859-1"), "UTF-8");
        String pwd = httpServletRequest.getParameter("password");
        boolean flag;
        ModelAndView mv = new ModelAndView();
        flag = new UserServiceImpl().UserLogin(name,pwd);
        if(flag){

            mv.addObject("name","c");
            mv.addObject("name","a");

            mv.setViewName("home");
        }else{
            mv.addObject("result","error");
            mv.setViewName("login");
        }
        return mv;
    }
}
