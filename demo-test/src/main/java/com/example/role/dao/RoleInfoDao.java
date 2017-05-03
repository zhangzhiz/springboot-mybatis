package com.example.role.dao;

import com.example.common.datasource.mysql.MybatisMapper;
import com.example.role.entity.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 10:33:28
 */
@Mapper
public interface RoleInfoDao extends MybatisMapper {
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
	 */
	RoleInfo selectRoleInfoById(Object id);

	/**
	 * 查找所有角色
	 *
	 * @return
	 */
	List<RoleInfo> selectRoleAllList();


	List<RoleInfo> selectRoleInfoListByMap(Map<String,Object> map);


	RoleInfo selectRoleInfoByRoleName(String roleName);

	Integer deleteRoleInfoByRoleId(Long roleId);
}
