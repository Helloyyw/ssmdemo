package com.ziro.service.impl;

import com.ziro.entity.TelPhoneEntity;
import com.ziro.entity.UserEntity;
import com.ziro.entity.WeiXiuEntity;
import com.ziro.mapper.UserMapper;
import com.ziro.service.UserService;
import com.ziro.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public UserEntity check(String name, String pwd) {
        UserEntity user = userMapper.check(name,pwd);
        return user;
    }

    public  List<TelPhoneEntity>  findByName(String name, String type) {
        List<TelPhoneEntity> byName = userMapper.findByName(name,type);

        return byName;
    }

    public JsonData addData(WeiXiuEntity data) {
        int i = userMapper.addData(data);
        if(i ==1 ) {
            return JsonData.success("插入成功");
        }
            return JsonData.fail("插入失败，请联系管理员");
    }

    public List<WeiXiuEntity> findAll() {

        return userMapper.findAll();
    }

    @Override
    public List<WeiXiuEntity> findByType(String type) {

        return userMapper.findByType(type);
    }
//查询所有的联系人信息
    @Override
    public List<TelPhoneEntity> findAllPerson() {
        return userMapper.findAllPerson();
    }

    @Override
    public List<TelPhoneEntity> findByName1(String name1) {
        return userMapper.findByName1(name1);
    }

    @Override
    public List<TelPhoneEntity> findByName2(String phone) {
        return userMapper.findByName2(phone);
    }

    @Override
    public int delete(Integer id) {

        return userMapper.delete(id);
    }
    @Override
    public int Update(String id,String name, String sex, String phone, String text) {
        return userMapper.Update(id,name,sex,phone,text);
    }
}
