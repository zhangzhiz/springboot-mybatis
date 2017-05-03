package com.example.user.service.impl;


import com.example.user.dao.UserRoleRelDao;
import com.example.user.entity.UserRoleRel;
import com.example.user.service.UserRoleRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 11:38:09
 */
@Service("userRoleRelService")
public class UserRoleRelServiceImpl implements UserRoleRelService {
	@Autowired
    private UserRoleRelDao userRoleRelDao;
   
    @Override
	public Integer  saveUserRoleRel(UserRoleRel entity ){
	       return userRoleRelDao.saveUserRoleRel(entity);
	}

	
	@Override
    public Integer updateUserRoleRelById(UserRoleRel entity ){
	return userRoleRelDao.updateUserRoleRelById(entity);
    }
    @Override
	public UserRoleRel selectUserRoleRelById(Object id){
	 return userRoleRelDao.selectUserRoleRelById(id);
	}
	


}
