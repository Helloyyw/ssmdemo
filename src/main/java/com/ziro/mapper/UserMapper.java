package com.ziro.mapper;

import com.ziro.entity.WeiXiuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有的维修故障信息
    List<WeiXiuEntity> findByName(@Param("name") String name,@Param("type")String type);
    List<WeiXiuEntity> findByType(@Param("type")String type);
    int  addData(WeiXiuEntity data);
    List<WeiXiuEntity> findAll();
}
