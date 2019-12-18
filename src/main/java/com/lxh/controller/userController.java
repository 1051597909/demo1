package com.lxh.controller;

import com.lxh.bean.user;
import com.lxh.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class userController {
    //注入业务
    @Autowired
    private userService userservice;
    @RequestMapping("/main1")
    public String main1(){
        return "main1";
    }
    @RequestMapping("/main2")
    public String main2(){
        return "main2";
    }
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }
    @RequestMapping("/register" )
    public String register(user user, Map<String,Object> map){
        String name  = user.getName();
        String password = user.getPassword();
        user a = userservice.findByName(name);
        boolean resultName = userservice.checkName(name);
        boolean resultPassword = userservice.checkPassword(password);
        if(a!=null){
            map.put("msg","用户名已经存在，请重新输入");
        }else if(resultName==false){
            map.put("msg","用户名不合法,请重新输入");
        }else if(resultPassword==false){
            map.put("msg","密码格式不合法,请重新输入");
        }else if (resultName==true&&resultPassword==true){
            userservice.insertuser(user);
            map.put("msg","注册成功,请返回登录");
        }
        return "register";
    }

    @RequestMapping("/login")
    public String login(String name,String password, Model model){
        /**
         * 使用shiro编写认证操作
         */
        //1.获取subject
         Subject subject = SecurityUtils.getSubject();
         //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        //3.执行登陆方法
        try{
            subject.login(token);
            //登陆成功，跳转到主界面
            return "redirect:/main2";
        }catch (UnknownAccountException e){
            //登陆失败，用户不存在
            model.addAttribute("msg","用户不存在");
            return "login";
        }catch (IncorrectCredentialsException e ){
            //登陆失败密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
