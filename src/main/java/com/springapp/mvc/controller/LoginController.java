package com.springapp.mvc.controller;

import com.springapp.mvc.model.Weibo;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.service.UserServiceImpl;
import com.springapp.mvc.service.WeiboServiceImpl;
import com.springapp.mvc.util.DuplicateException;
import com.springapp.mvc.dao.UserDaoImpl;
import com.springapp.mvc.model.UserPD;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/22.
 */
@Controller
@SessionAttributes("user_name")
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView start(){
        ModelAndView mv = new ModelAndView();
        System.out.println("success");
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping("/login.do")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,HttpSession httpSession,Model model) throws Exception {
        String  name = new String(httpServletRequest.getParameter("user_name").getBytes("ISO8859-1"), "UTF-8");
        String pwd = httpServletRequest.getParameter("password");
        String redirect_name;
        int index;
        List<Weibo> weiboList = new ArrayList<Weibo>();//微博list  分页处理结果返回 List<Weibo>
        boolean flag;
        ModelAndView mv = new ModelAndView();
        flag = new UserServiceImpl().UserLogin(name,pwd);
        if(flag){
            model.addAttribute("user_name",name);
            redirect_name = "redirect:/homes?tag="+""+"&page=1";
            mv.setViewName(redirect_name);
        }else{
            mv.addObject("result","error");
            mv.setViewName("login");
        }
        return mv;
    }
}
      /*
            这里把姓名，账号存入session
             */
//            model.addAttribute("user_name",name);
//
//            Enumeration<String> e = httpSession.getAttributeNames();
//            while (e.hasMoreElements()) {
//                String s = e.nextElement();
//                System.out.println(s + " == " + httpSession.getAttribute(s));
//            }


//            mv.addObject("user_name",name);
//            index = 1;
//            WeiboServiceImpl wbService = new WeiboServiceImpl();
//            List<Weibo> records2 = wbService.GetPageByIndex(index,"",name);
//            int isNext = wbService.IsNextPageExist();
//            mv.addObject("weiboList",records2);
//            mv.addObject("isNextPage",isNext);
//            mv.addObject("index",index);