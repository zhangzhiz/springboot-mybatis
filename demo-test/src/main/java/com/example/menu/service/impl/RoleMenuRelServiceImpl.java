package com.example.menu.service.impl;


import com.example.menu.dao.RoleMenuRelDao;
import com.example.menu.entity.RoleMenuRel;
import com.example.menu.service.RoleMenuRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:37:56
 */
@Service("roleMenuRelService")
public class RoleMenuRelServiceImpl implements RoleMenuRelService {
	@Autowired
    private RoleMenuRelDao roleMenuRelDao;
   
    @Override
	public Integer  saveRoleMenuRel(RoleMenuRel entity ){
	       return roleMenuRelDao.saveRoleMenuRel(entity);
	}

	
	@Override
    public Integer updateRoleMenuRelById(RoleMenuRel entity ){
	return roleMenuRelDao.updateRoleMenuRelById(entity);
    }
    @Override
	public RoleMenuRel selectRoleMenuRelById(Object id){
	 return roleMenuRelDao.selectRoleMenuRelById(id);
	}
	


}
