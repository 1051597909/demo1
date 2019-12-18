package com.lxh.mapper;

import com.lxh.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
@Mapper
public interface userMapper {

    public user findByName(String name);

    public user findByid(int id);

    public int insertuser(user user);

}
