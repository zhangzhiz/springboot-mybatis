package com.example.role.service;


import com.example.common.Page;
import com.example.role.entity.RoleInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 10:33:28
 */
public interface RoleInfoService {
	/**
	 *保存
	 *
	 */
	public Integer  saveRoleInfo(RoleInfo entity);
	/**
	 *修改
	 *
	 */
	public Integer updateRoleInfoById(RoleInfo entity);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	RoleInfo selectRoleInfoById(Object id) ;

	/**
	 * 查找所有角色
	 *
	 * @return
	 */
	List<RoleInfo> selectRoleAllList();
	
	
	public Page<RoleInfo> queryRolePage(Page<RoleInfo> page, Map<String,Object> map);

	/**
	 * 新增角色，同时为新角色添加菜单
	 * */
	public Map<String,Object> insertRoleInfo(RoleInfo role,String menuIds);

	/**
	 * 修改角色，同时为新角色添加菜单
	 * */
	public Map<String,Object> updateRoleInfo(RoleInfo role,String menuIds);

	/**
	 * 删除角色，同时删除角色用户对应关系
	 * */
	public Map<String,Object> deleteRoleInfo(Long roleId);
}
