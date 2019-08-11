package com.ziro.service;

import com.ziro.entity.TelPhoneEntity;
import com.ziro.entity.UserEntity;
import com.ziro.entity.WeiXiuEntity;
import com.ziro.utils.JsonData;

import java.util.List;

public interface UserService {
    UserEntity check(String name, String pwd);
    List<TelPhoneEntity>  findByName(String name, String type);
    JsonData addData(WeiXiuEntity data);
    List<WeiXiuEntity> findAll();
    List<WeiXiuEntity> findByType(String type);
    List<TelPhoneEntity> findAllPerson();
//根据姓名查找
    List<TelPhoneEntity> findByName1(String name1);
 //根据电话找
    List<TelPhoneEntity> findByName2(String phone);
//根据id删除
    int delete(Integer id);
//更新
    int Update(String id ,String name, String sex, String phone, String text);
}
