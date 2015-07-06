package com.springapp.mvc.controller;

import com.springapp.mvc.model.Union;
import com.springapp.mvc.service.FollowService;
import com.springapp.mvc.service.FollowServiceImpl;
import com.springapp.mvc.service.UserServiceImpl;
import com.springapp.mvc.service.WeiboServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/25.
 */
@Controller
@RequestMapping(value = "/weibo")
public class WeiboController {
   @RequestMapping("/publish")
    public @ResponseBody Map<String,Object> WeiboPublish(HttpServletRequest request,HttpServletResponse response) throws IOException{

       ModelAndView mv = new ModelAndView();
       String content = URLDecoder.decode(request.getParameter("content"),"UTF-8");
       String picture_id = request.getParameter("pic_url");
       String str_thumb_on = request.getParameter("thumb_on");
       int thumb_on = Integer.parseInt(str_thumb_on);
       String user_id = request.getParameter("user_id");
       String interest_id = request.getParameter("interest_id");


       JSONObject json  = new JSONObject();
       System.out.println(content);

//       response.setCharacterEncoding("utf-8");
//       response.getWriter().write("{\"成功接收\":true }");
//       response.getWriter().flush();
       Map<String,Object> modelMap = new HashMap<String, Object>(7);
       modelMap.put("tao_id","");
       modelMap.put("content", content);
       modelMap.put("thumb_on",thumb_on);
       modelMap.put("time","");
       modelMap.put("user_id",user_id);
       modelMap.put("interest_id",interest_id);
       modelMap.put("picture_id",picture_id);
       /*
       此处调用service层
        */

       new WeiboServiceImpl().WeiboPublish(modelMap);


//       try{
//           json.put("content",content);
//           json.put("result","success");
//       }catch(JSONException e){
//           System.out.println(e);
//       }
        return modelMap;
    }

   @RequestMapping("/praise")
   public @ResponseBody String WeiboPraise(HttpServletRequest request)throws IOException{

      String tao_id = URLDecoder.decode(request.getParameter("tao_id"),"UTF-8");
      boolean res = new WeiboServiceImpl().GivePraise(tao_id);
      return "success";
   }
   @RequestMapping("/down")
   public @ResponseBody String WeiboDown(HttpServletRequest request)throws IOException{

      String tao_id = URLDecoder.decode(request.getParameter("tao_id"),"UTF-8");
      boolean res = new WeiboServiceImpl().GiveDown(tao_id);
      return "success";
   }
   @RequestMapping("/search")
   public ModelAndView SearchWeibo(HttpServletRequest request,HttpSession session){
      ModelAndView mv = new ModelAndView();
      String keywords="";
      String face_url="";
      List<Union> records2;
      records2 = new WeiboServiceImpl().GetSearchRes(keywords);
      String user_name = (String)session.getAttribute("user_name");
      mv.addObject("UnionList",records2);
      mv.addObject("user_name",user_name);
      WeiboServiceImpl wbService = new WeiboServiceImpl();
      FollowService followService = new FollowServiceImpl();
      int weibo_num = wbService.GetWeiboNum(user_name);
      int follow_num = followService.GetFollowNum(user_name);
      int fans_num = followService.GetFansNum(user_name);
      face_url = new UserServiceImpl().GetUserFaceUrl(user_name);

      mv.addObject("UnionList",records2);
      mv.addObject("weibo_num",weibo_num);
      mv.addObject("follow_num",follow_num);
      mv.addObject("fans_num",fans_num);
      mv.addObject("face_url",face_url);
      mv.addObject("keywords",keywords);
      mv.setViewName("home");
      
      return mv;
   }
}
