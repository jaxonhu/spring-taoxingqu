package com.springapp.mvc.controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hujiaxuan on 2015/6/23.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public ModelAndView setView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
}
