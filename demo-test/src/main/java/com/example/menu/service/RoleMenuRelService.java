package com.example.menu.service;


import com.example.menu.entity.RoleMenuRel;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:37:56
 */
public interface RoleMenuRelService {
	/**
	 *保存
	 *
	 */
	public Integer  saveRoleMenuRel(RoleMenuRel entity);
	/**
	 *修改
	 *
	 */
	public Integer updateRoleMenuRelById(RoleMenuRel entity);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	RoleMenuRel selectRoleMenuRelById(Object id);

}
