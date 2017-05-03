package com.example.user.service;


import com.example.user.entity.UserRoleRel;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 11:38:09
 */
public interface UserRoleRelService {
	/**
	 *保存
	 *
	 */
	public Integer  saveUserRoleRel(UserRoleRel entity);
	/**
	 *修改
	 *
	 */
	public Integer updateUserRoleRelById(UserRoleRel entity);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserRoleRel selectUserRoleRelById(Object id);
	
	
	
}
