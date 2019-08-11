package com.ziro.mapper;

import com.ziro.entity.TelPhoneEntity;
import com.ziro.entity.UserEntity;
import com.ziro.entity.WeiXiuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
//    根据姓名和电话搜索联系人信息
    List<TelPhoneEntity> findByName(@Param("name") String name,@Param("type")String type);
    List<WeiXiuEntity> findByType(@Param("type")String type);
    int  addData(WeiXiuEntity data);
    List<WeiXiuEntity> findAll();
    UserEntity check(@Param("name") String name, @Param("pwd")  String pwd);

    List<TelPhoneEntity> findAllPerson();

    List<TelPhoneEntity> findByName1(String name1);
    List<TelPhoneEntity> findByName2(String phone);

    int delete(Integer id);

    int Update(String id,String name, String sex, String phone, String text);

}
