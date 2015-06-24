package com.springapp.mvc.dao;

/**
 * Created by hujiaxuan on 2015/6/17.
 */
public class DuplicateException extends Exception {
    public DuplicateException(String message){
        super(message);
    }
}
