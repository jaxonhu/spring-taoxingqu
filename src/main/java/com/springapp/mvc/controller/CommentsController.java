package com.springapp.mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.springapp.mvc.model.Comment;
import com.springapp.mvc.service.CommentServiceImpl;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
    public @ResponseBody String CommentPublish(HttpServletRequest request,HttpSession session) throws IOException{
        Map<String,Object> map = new HashMap<String, Object>(3);
        String content = URLDecoder.decode(request.getParameter("content"), "UTF-8");
        String tao_id = URLDecoder.decode(request.getParameter("tao_id"), "UTF-8");
//        String user_id = URLDecoder.decode(request.getParameter("user_id"), "UTF-8");
        String user_name = (String)session.getAttribute("user_name");
        map.put("content",content);
        map.put("tao_id",tao_id);
        map.put("user_id",user_name);
        boolean res = new CommentServiceImpl().CommentPublish(map);
        return "success";
    }
    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public @ResponseBody void CommentShow(HttpServletRequest request,HttpServletResponse response)throws IOException{
        String tao_id = URLDecoder.decode(request.getParameter("tao_id"), "UTF-8");
        String user_id = URLDecoder.decode(request.getParameter("user_id"), "UTF-8");

        final ObjectMapper mapper = new ObjectMapper();
        String page = request.getParameter("page");
        int index = Integer.parseInt(page);
        List<Comment> list ;
        list= new CommentServiceImpl().GetCommentByTaoid(index,tao_id);
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式
        PrintWriter out2 = response.getWriter(); //获取写入对象
        out2.print(json); //将json数据写入流中
        out2.flush();
    }
}
