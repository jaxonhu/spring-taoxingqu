package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hujiaxuan on 2015/7/3.
 */
@Controller
public class ImageUpload{
    @RequestMapping(value = "upload_enter.do", method = RequestMethod.GET)
    public String enter(HttpServletRequest request,
                        HttpServletResponse response, ModelMap model) throws IOException {
        return "upload";
    }
    @RequestMapping(value = "upload.do", method = RequestMethod.POST)
    public void upload(HttpServletRequest request,
                       HttpServletResponse response, ModelMap model) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile mFile = multipartRequest.getFile("file");
        //String path = request.getSession().getServletContext().getRealPath("/");
        String path = request.getSession().getServletContext().getRealPath("/resources/upload");
        String filename = mFile.getOriginalFilename();
        InputStream inputStream = mFile.getInputStream();
        byte[] b = new byte[1048576];
        int length = inputStream.read(b);
        Date date = new Date();
        SimpleDateFormat F = new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix=filename.substring(filename.lastIndexOf("."));
        filename = "123" + F.format(date) + prefix;
        String url =path +"/"+ filename;
        System.out.println(url);
        FileOutputStream outputStream = new FileOutputStream(url);
        outputStream.write(b, 0, length);
        inputStream.close();
        outputStream.close();
    }
}