package com.springapp.mvc.service;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.dao.UserDaoImpl;
import com.springapp.mvc.model.Union;
import com.springapp.mvc.model.UserPD;
import com.springapp.mvc.model.Weibo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hujiaxuan on 2015/6/27.
 */
public class UserServiceImpl implements UserService{
    public UserDao  userDao= new UserDaoImpl();
    public UserPD userPD = null;
    public String user_id;
    public String user_pwd;
    public Date date;
    public SimpleDateFormat dateFormat;
    public long time_num;

    @Override
    public boolean UserLogin(String user_name, String user_pwd) {

        userPD = userDao.UserSelect(user_name);


        if(userPD == null){
            return false;
        }else{
            if(userPD.user_pwd.equals(user_pwd)){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean UserRegister(Map<String, Object> map) {

        String user_id;
        String user_name = (String)map.get("user_name");
        String user_pwd = (String)map.get("user_pwd");
        String email = (String)map.get("email");
        String register_time = GetUserRegisterTime();
        user_id = GetUserId(user_name);

        UserPD user = new UserPD(user_id,user_name,user_pwd,email,register_time);

        boolean result = userDao.UserInsert(user);

        return result;

    }

    @Override
    public String GetUserRegisterTime() {
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(date);
        return currentTime;
    }

    @Override
    public String GetUserId(String user_name) {
        time_num = date.getTime();
        String user_id = user_name + time_num;
        return user_id;
    }

    @Override
    public boolean UserFaceUpload(String user_name, String url) {
        boolean res = userDao.UserFaceInsert(user_name,url);
        return res;
    }

    @Override
    public List<Union> GetUsersByWeibo(List<Weibo> weibo_list) {
        List<Union> result=new ArrayList<Union>();

        UserPD user_temp;
        for(Weibo wb:weibo_list){
            Union temp=new Union();
            temp.weibo = wb;
            user_temp = userDao.UserSelect(wb.user_id);
            temp.user = user_temp;
            result.add(temp);
            temp=null;
        }

        return result;
    }

    @Override
    public String GetUserFaceUrl(String user_name) {

        UserPD user;
        user = userDao.UserSelect(user_name);

        return user.face_url;
    }
}
