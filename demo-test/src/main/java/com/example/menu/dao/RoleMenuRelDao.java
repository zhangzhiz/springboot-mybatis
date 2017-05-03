package com.example.menu.dao;


import com.example.common.datasource.mysql.MybatisMapper;
import com.example.menu.entity.RoleMenuRel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:37:56
 */
@Mapper
public interface RoleMenuRelDao extends MybatisMapper {
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

	/**
	 *查询角色菜单对应关系数量
	 * */
	Integer selectRoleMenuRelByMenuId(Long menuId);

	/**
	 *删除角色菜单对应关系
	 * */
	Integer deleteRoleMenuRelByMenuId(Long menuId);

	/**
	 *删除角色菜单对应关系
	 * */
	Integer deleteRoleMenuRelByRoleId(Long RoleId);

	Integer selectRoleMenuRelByRoleId(Long RoleId);
	
}
