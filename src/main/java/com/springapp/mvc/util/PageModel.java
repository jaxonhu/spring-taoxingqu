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
    public int isNextPage;//0代表没有下一页了，1代表还有下一页
    public int lastRecords;//最后一项的index
    public int getTotalPages() {
        return (totalRecords + page_size -1)/page_size;
    }

    public int getTopPageNo(){
        return 1;
    }

    public List<E> getList() {
        return records;
    }

    public PageModel(int page, List<E> records,int page_size) {
        this.page = page;
        this.records = records;
        this.page_size = page_size;
    }

    public List<E> getPageList(){
        List<E> result = new ArrayList<E>();
        /*
        这里根据page 读取 records中的数据，存入result中
         */

        totalRecords = records.size();
        lastRecords = totalRecords-1;
        int currentIndex = (page-1)*page_size;
        int endIndex = currentIndex + page_size -1;

        if(endIndex < lastRecords){
            isNextPage = 1;//有下一页
        }
        if(endIndex >= lastRecords){
            isNextPage = 0;//没有下一页
            endIndex = lastRecords;
        }

        for(int i=currentIndex;i<=endIndex;i++){
            E tmp;
            tmp = records.get(i);
            result.add(tmp);
        }

        return result;
    }

    public int isNextPageExist(){
        return isNextPage;
    }


}
