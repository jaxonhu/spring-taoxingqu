package com.springapp.mvc.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.mvc.model.Comment;
import com.springapp.mvc.service.CommentServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/7/1.
 */
public class TestJackson {
    public static void main(String[] args) throws  IOException{
        List<Comment> list = new ArrayList<Comment>();
        Comment comment1 = new Comment("1324657","胡家煊","2015","dasadaqwe","asdasd");
        Comment comment2 = new Comment("1322134578","qweqw","2013","qweqwer","qweqweq");
        list.add(comment1);
        list.add(comment2);
        String unicodeMessage = "胡家煊";
        List<Comment> list2= new CommentServiceImpl().GetCommentByTaoid(1,"胡家煊1435633089026");
        final OutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, comment1);
        final String data = out.toString();
//        PrintStream out1 = new PrintStream(System.out, true, "UTF-8");
//        out1.println(unicodeMessage);
        System.out.println(data);

    }
}
