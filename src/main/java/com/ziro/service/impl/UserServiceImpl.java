package com.ziro.service.impl;

import com.ziro.entity.WeiXiuEntity;
import com.ziro.mapper.UserMapper;
import com.ziro.service.UserService;
import com.ziro.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public  List<WeiXiuEntity>  findByName(String name,String type) {
        List<WeiXiuEntity> byName = userMapper.findByName(name,type);

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
}
