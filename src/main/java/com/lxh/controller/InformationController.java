package com.lxh.controller;

import com.lxh.bean.Information;
import com.lxh.service.informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class InformationController {
    @Autowired
    private com.lxh.service.userService userService;
    @Autowired
    private informationService informationservice;
    @RequestMapping("/add")
    public String add(Information information, Map<String,Object> map) {
        String name1 = information.getName();
        String name2 = information.getName1();
        String phonenumber = information.getPhonenumber();
        String scholl = information.getScholl();
        String education = information.getEducation();
        String profession = information.getProfessional();
        if(name1==null){
            map.put("msg","请填写个人信息");
        } else if((phonenumber.length())!=11&&(phonenumber.length())!=7&&phonenumber!=null){
            map.put("msg","您电话号码不合理");
        }else if(!education.equals("本科")){
            map.put("msg","您的学历不符合要求，注册账号的最低学历为本科");
        }else if(name1!=null&&name2!=null&&scholl!=null&&education!=null&&profession!=null) {
           informationservice.insertinformation(information);
           map.put("msg", "信息添加成功");
       }
        return "add";
    }
}
