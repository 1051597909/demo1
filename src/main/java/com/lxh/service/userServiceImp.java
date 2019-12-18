package com.lxh.service;

import com.lxh.bean.user;
import com.lxh.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImp implements userService {
    //注入mapper接口
    @Autowired
    private userMapper usermapper;
    @Override
    public user findByName(String name) {
        return usermapper.findByName(name);
    }
    @Override
    public user findByid(int id) {
        return usermapper.findByid(id);
    }
    @Override
    public int insertuser(user user) {
        return usermapper.insertuser(user);
    }

    @Override
    public   boolean  checkName(String name){
        System.out.println(name);
        String regExp = "^[^0-9][\\w_]{2,9}$";
        if(name.matches(regExp)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public   boolean checkPassword(String password){
        String regExp = "^[\\w_]{3,10}$";
        if(password.matches(regExp)){
            return true;
        }else{
            return false;
        }
    }
}
