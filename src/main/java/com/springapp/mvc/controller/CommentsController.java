package com.springapp.mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.springapp.mvc.model.Comment;
import com.springapp.mvc.service.CommentServiceImpl;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/7/1.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentsController {
    @RequestMapping("/publish")
    public @ResponseBody Map<String,Object> CommentPublish(HttpServletRequest request,HttpSession session) throws IOException{

        Map<String,Object> map = new HashMap<String, Object>(3);
        String content = URLDecoder.decode(request.getParameter("content"), "UTF-8");
        String tao_id = URLDecoder.decode(request.getParameter("tao_id"), "UTF-8");
//        String user_id = URLDecoder.decode(request.getParameter("user_id"), "UTF-8");
        String user_name = (String)session.getAttribute("user_name");
        map.put("content",content);
        map.put("tao_id",tao_id);
        map.put("user_id",user_name);

        boolean res = new CommentServiceImpl().CommentPublish(map);



        return map;


    }
    @RequestMapping(value = "/show")
    public @ResponseBody String CommentShow(HttpServletRequest request)throws IOException{
        String tao_id = URLDecoder.decode(request.getParameter("tao_id"), "UTF-8");
        String user_id = URLDecoder.decode(request.getParameter("user_id"), "UTF-8");
        String page = request.getParameter("page");
        int index = Integer.parseInt(page);
        List<Comment> list ;
        list= new CommentServiceImpl().GetCommentByTaoid(index,tao_id);
        final OutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, list);

        final String data = out.toString();
        return data;
    }
}
