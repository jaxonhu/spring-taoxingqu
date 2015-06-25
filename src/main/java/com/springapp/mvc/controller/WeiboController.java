package com.springapp.mvc.controller;

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
    public @ResponseBody Map<String,Object> WeiboPublish(HttpServletRequest request,HttpServletResponse response) throws IOException{

       ModelAndView mv = new ModelAndView();
       String content = URLDecoder.decode(request.getParameter("content"),"UTF-8");
       JSONObject json  = new JSONObject();
       System.out.println(content);

//       response.setCharacterEncoding("utf-8");
//       response.getWriter().write("{\"成功接收\":true }");
//       response.getWriter().flush();
       Map<String,Object> modelMap = new HashMap<String, Object>(7);
       modelMap.put("tao_id",124514);
       modelMap.put("content", content);
       modelMap.put("thumb_on",3);
       modelMap.put("time","2015-6-25");
       modelMap.put("user_id",132456);
       modelMap.put("interest_id",978978);
       modelMap.put("picture_id","C:/");
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
}
