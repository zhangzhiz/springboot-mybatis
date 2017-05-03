package com.example.user.dao;


import com.example.common.datasource.mysql.MybatisMapper;
import com.example.user.entity.ManageUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-17 09:52:01
 */
@Mapper
public interface ManageUserDao extends MybatisMapper {
	/**
	 *保存
	 *
	 */
	public Integer  saveManageUser(ManageUser entity) ;
	/**
	 *修改
	 *
	 */
	public Integer updateManageUserById(ManageUser entity) ;
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ManageUser selectManageUserById(Object id) ;

	public List<ManageUser> queryManageUserByMap(Map<String, Object> qMap);


	/**
	 * 根据ID查找
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	ManageUser selectManageUserByUserName(String userName) ;

	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	Integer deleteManageUserByUserId(Long userId);

	Integer changeUserStatus(Map<String, Object> qMap);
	
	
	
}
