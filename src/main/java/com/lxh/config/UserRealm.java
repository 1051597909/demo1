package com.lxh.config;

import com.lxh.bean.user;
import com.lxh.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    //注入业务
    @Autowired
    private userService userservice;
    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加资源的授权字符串
        //获取当前登陆用户
        Subject subject = SecurityUtils.getSubject();
        user user = (user)subject.getPrincipal();
        if(user.getName().equals("admin")){
            info.addStringPermission("user:add");
            info.addStringPermission("user:update");
            info.addStringPermission("user:delete");
            info.addStringPermission("user:select");
            return info;
        }else {
            info.addStringPermission("user:update");
            info.addStringPermission("user:add");
            return info;
        }

    }
    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
        System.out.println(token);
        user user = userservice.findByName(token.getUsername());
        System.out.println(user);
        if(user==null){
            return null;//shiro底层会抛出UnknownAccountException
        }
        //2.判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
        }

}
