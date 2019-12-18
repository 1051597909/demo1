package com.lxh.service;

import com.lxh.bean.Information;
import com.lxh.mapper.informationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class informationServiceImp implements informationService{
    @Autowired
    private informationMapper informationmapper;
    @Override
    public int insertinformation(Information information) {
        return informationmapper.insertinformation(information);
    }
}
