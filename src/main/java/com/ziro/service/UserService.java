package com.ziro.service;

import com.ziro.entity.WeiXiuEntity;
import com.ziro.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    List<WeiXiuEntity>  findByName(String name,String type);
    JsonData addData(WeiXiuEntity data);
    List<WeiXiuEntity> findAll();
    List<WeiXiuEntity> findByType(String type);
}
