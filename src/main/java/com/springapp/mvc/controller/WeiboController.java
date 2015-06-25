package com.springapp.mvc.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/25.
 */
@Controller
@RequestMapping(value = "/weibo")
public class WeiboController {
   @RequestMapping("/publish")
   @ResponseBody //对ajax返回响应必须加上
    public JSONObject WeiboPublish(HttpServletRequest request,HttpServletResponse response) throws IOException{

       ModelAndView mv = new ModelAndView();
       String content = URLDecoder.decode(request.getParameter("content"),"UTF-8");
       JSONObject json  = new JSONObject();
       System.out.println(content);
//       response.setCharacterEncoding("utf-8");
//       response.getWriter().write("{\"成功接收\":true }");
//       response.getWriter().flush();


//      Map<String,Object> modelMap = new HashMap<String, Object>(3);
//      modelMap.put("total","1");
//      modelMap.put("data", content);
//      modelMap.put("success", "true");
       try{
           json.put("content",content);
           json.put("result","success");
       }catch(JSONException e){
           System.out.println(e);
       }
        return json;
    }
}
