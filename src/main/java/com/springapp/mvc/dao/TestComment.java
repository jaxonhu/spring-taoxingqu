package com.springapp.mvc.dao;

import com.springapp.mvc.model.Comment;
import com.springapp.mvc.service.CommentService;
import com.springapp.mvc.service.CommentServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/7/1.
 */
public class TestComment{
    public static void main(String[] args){
        CommentService commentService = new CommentServiceImpl();
        List<Comment> records;
        Map<String,Object> map = new HashMap<String, Object>(3);
        String content = "啦啦啦啦";
        String tao_id = "胡家煊123";
        String user_name = "胡家煊";
        map.put("content",content);
        map.put("tao_id",tao_id);
        map.put("user_id",user_name);

        records = commentService.GetCommentByTaoid(1,"胡家煊1435633089026");

        for(Comment co:records){
            System.out.println(co.getComment());
        }
//        boolean res = commentService.CommentPublish(map);
//        if(res){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }
    }
}
