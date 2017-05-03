package com.example.othersource.lrh.service.impl;

import com.example.othersource.lrh.dao.UserDetailDao;
import com.example.othersource.lrh.entity.UserDetail;
import com.example.othersource.lrh.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangzhizhong on 2017/4/20.
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailDao userDetailDao;

    @Override
    public List<UserDetail> selectAllUsers() {
        String xx="firstMysqlDatasource";
        return userDetailDao.selectAll();
    }
}
