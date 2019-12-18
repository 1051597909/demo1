package com.lxh.mapper;


import com.lxh.bean.Information;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface informationMapper {
    //个人信息的添加
    public int insertinformation (Information information);
}
