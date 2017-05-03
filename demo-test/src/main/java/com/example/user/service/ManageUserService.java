package com.example.user.service;


import com.example.common.Page;
import com.example.user.entity.ManageUser;

import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-17 09:52:01
 */
public interface ManageUserService {
	/**
	 *保存
	 *
	 */
	public Integer  saveManageUser(ManageUser entity) ;
	/**
	 *修改
	 *
	 */
	public Integer updateManageUserById(ManageUser entity);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ManageUser selectManageUserById(Object id);


	/**
	 * 分页查询列表
	 *
	 * @param page
	 * @param qMap
	 * @return
	 */
	public Page<ManageUser> queryUserPage(Page<ManageUser> page, Map<String,Object> qMap);


	public Map<String,Object> insertManageUserInfo(ManageUser entity,String roleId);

	/**
	 *删除用户
	 * */
	public Map<String,Object> deleteUserInfo(Long userId);

	/**
	 * 修改用户密码
	 * */
	public Map<String,Object> changeUserPassword(ManageUser entity);

	/**
	 * 用户启用
	 * */
	public Map<String,Object> enableUser(String ids);
	/**
	 * 用户禁用
	 * */
	public Map<String,Object> disableUser(String ids);

	/**
	 * 验证用户是否正确，是否可用登录
	 * */
	Map<String,Object> selectUserByUserName(String userName);

}
