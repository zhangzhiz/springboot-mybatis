package com.example.user.service.impl;


import com.example.common.Page;
import com.example.common.SystemSession.SystemThreadLocal;
import com.example.common.datasource.mysql.MysqlDataSourceConfig;
import com.example.user.dao.ManageUserDao;
import com.example.user.dao.UserRoleRelDao;
import com.example.user.entity.ManageUser;
import com.example.user.entity.UserRoleRel;
import com.example.user.service.ManageUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-17 09:52:01
 */
@Service
public class ManageUserServiceImpl implements ManageUserService {

	private final Logger LOGGER = LoggerFactory.getLogger(ManageUserServiceImpl.class);

	@Autowired
    private ManageUserDao manageUserDao;

	@Autowired
	private UserRoleRelDao userRoleRelDao;
   
    @Override
	public Integer  saveManageUser(ManageUser entity ) {
	       return manageUserDao.saveManageUser(entity);
	}

	
	@Override
    public Integer updateManageUserById(ManageUser entity ) {
	return manageUserDao.updateManageUserById(entity);
    }

    @Override
	public ManageUser selectManageUserById(Object id){
	 return manageUserDao.selectManageUserById(id);
	}

	@Override
	public Page<ManageUser> queryUserPage(Page<ManageUser> page, Map<String, Object> qMap) {

		List<ManageUser> list = manageUserDao.queryManageUserByMap(qMap);
		page.setTotalCount(list.size());
		page.setResult(list);

		return page;
	}

	@Override
	public Map<String, Object> insertManageUserInfo(ManageUser entity, String roleId) {

		Map<String, Object> result = new HashMap<String,Object>();
		//保存用户信息
		ManageUser user = manageUserDao.selectManageUserByUserName(entity.getUserName());
		if(user != null){
			result.put("message","用户已存在！");
			result.put("status",0);
			return result;
		}

		manageUserDao.saveManageUser(entity);
		System.out.println(entity.getUserId());

		UserRoleRel rel = new UserRoleRel();
		rel.setUserId(entity.getUserId());
		rel.setRoleId(Long.valueOf(roleId));
		userRoleRelDao.saveUserRoleRel(rel);

		result.put("message","新增成功！");
		result.put("status",1);

		ManageUser local = SystemThreadLocal.getUserSession();
		LOGGER.info(local.getUserName());

		return result;
	}

	@Override
	public Map<String, Object> deleteUserInfo(Long userId) {

		Map<String, Object> result = new HashMap<String,Object>();

		int status=0;
		status = manageUserDao.deleteManageUserByUserId(userId);
		if(status==0){
			result.put("message","删除失败！");
			result.put("status",0);
			return result;
		}else{
			int count = userRoleRelDao.selectUserRoleRelByUserId(userId);
			if(count !=0){
				userRoleRelDao.deleteUserRoleRelByUserId(userId);
			}
		}

		result.put("message","删除成功！");
		result.put("status",1);

		return result;
	}

	@Override
	public Map<String, Object> changeUserPassword(ManageUser entity) {

		Map<String, Object> result = new HashMap<String,Object>();

		int status=0;
		status = manageUserDao.updateManageUserById(entity);

		result.put("status",status);
		if(status==0){
			result.put("message","修改失败！");
		}else{
			result.put("message","修改成功！");
		}

		return result;
	}

	@Override
	public Map<String, Object> enableUser(String ids) {

		Map<String, Object> result = new HashMap<String,Object>();
		String[] userIds = ids.split(",");

		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userIds",userIds);
		param.put("isEnable","1");

		manageUserDao.changeUserStatus(param);

		result.put("message","启用成功！");
		result.put("status",1);

		return result;
	}

	@Override
	public Map<String, Object> disableUser(String ids) {
		Map<String, Object> result = new HashMap<String,Object>();
		String[] userIds = ids.split(",");

		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userIds",userIds);
		param.put("isEnable","0");

		manageUserDao.changeUserStatus(param);

		result.put("message","禁用成功！");
		result.put("status",1);
		return result;
	}

	@Override
	public Map<String,Object> selectUserByUserName(String userName) {

		Map<String, Object> result = new HashMap<String,Object>();

		ManageUser entity = manageUserDao.selectManageUserByUserName(userName);

		if(entity==null){
			result.put("status",0);
			result.put("message","账号不存在！");
		}else{
			result.put("manageUser",entity);
			result.put("status",1);
			result.put("message","查询成功！");
		}

		return result;
	}
}
