package com.springapp.mvc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujiaxuan on 2015/6/26.
 */
public class PageModel<E> {
    public int page = 1; //当前页
    public int totalPages = 0;//总页数
    public  int page_size = 6;//每一页显示条数
    public int totalRecords = 0;//总的记录数
    public List<E> records;//结果集

    public int getTotalPages() {
        return (totalRecords + page_size -1)/page_size;
    }

    public int getTopPageNo(){
        return 1;
    }

    public List<E> getList() {
        return records;
    }

    public PageModel(int page, List<E> records) {
        this.page = page;
        this.records = records;
    }

    public List<E> getPageList(){
        List<E> result = new ArrayList<E>();
        /*
        这里根据page 读取 records中的数据，存入result中
         */
        
        return result;
    }

}
