package com.springapp.mvc.dao;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.mvc.model.Comment;

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
        Comment comment1 = new Comment("1324657","adasda","2015","dasadaqwe","asdasd");
        Comment comment2 = new Comment("1322134578","qweqw","2013","qweqwer","qweqweq");
        list.add(comment1);
        list.add(comment2);
        final OutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, list);

        final String data = out.toString();
        System.out.println(data);

    }
}
