package com.example.othersource.lrh.dao;

import com.example.common.datasource.mysql.MybatisMapper;
import com.example.othersource.lrh.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDetailDao extends MybatisMapper {

    public List<UserDetail> selectAll();
}