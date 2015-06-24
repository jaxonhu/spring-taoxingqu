package com.springapp.mvc.dao;

/**
 * Created by hujiaxuan on 2015/6/17.
 */
public class NotFoundException extends Exception {
    public NotFoundException(String message){
        super(message);
    }
}
