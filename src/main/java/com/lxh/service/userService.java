package com.lxh.service;

import com.lxh.bean.user;

public interface userService {
    public user findByName(String name);

    public user findByid(int id);

    public int insertuser(user user);

    /**
     *验证用户名(开头不能为数字，3-10位，用户名由字母数字和下划线组成)
     */
    public boolean checkName(String name);

    /**
     *验证密码(3-10位，用户名由字母数字和下划线组成)
     */
    public boolean checkPassword(String password);
}
