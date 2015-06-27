package com.springapp.mvc.controller;
import com.springapp.mvc.service.UserServiceImpl;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/23.
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public ModelAndView start(){
        ModelAndView mv = new ModelAndView();
        System.out.println("success");
        mv.setViewName("register");
        return mv;
    }


    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public ModelAndView setView(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mv = new ModelAndView();
        String  user_name = new String(request.getParameter("user_name").getBytes("ISO8859-1"), "UTF-8");
        String  user_pwd = request.getParameter("user_pwd");
        String  email = request.getParameter("email");

        Map<String,Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("user_name",user_name);
        modelMap.put("user_pwd",user_pwd);
        modelMap.put("email",email);

        Boolean result = new UserServiceImpl().UserRegister(modelMap);

        if(result){
            mv.addObject("message","register");
            mv.setViewName("login");
        }else{
            mv.addObject("message","error");
            mv.setViewName("register");
        }


        return mv;
    }
}
