package com.example.role.service.impl;


import com.example.common.Page;
import com.example.menu.dao.RoleMenuRelDao;
import com.example.menu.entity.RoleMenuRel;
import com.example.role.dao.RoleInfoDao;
import com.example.role.entity.RoleInfo;
import com.example.role.service.RoleInfoService;
import com.example.user.dao.UserRoleRelDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 10:33:28
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
	@Autowired
    private RoleInfoDao roleInfoDao;

	@Autowired
	private RoleMenuRelDao roleMenuRelDao;

	@Autowired
	private UserRoleRelDao userRoleRelDao;

	@Override
	public Integer  saveRoleInfo(RoleInfo entity ){
	       return roleInfoDao.saveRoleInfo(entity);
	}

	
	@Override
    public Integer updateRoleInfoById(RoleInfo entity ){
	return roleInfoDao.updateRoleInfoById(entity);
    }
    @Override
	public RoleInfo selectRoleInfoById(Object id){
	 return roleInfoDao.selectRoleInfoById(id);
	}

	@Override
	public List<RoleInfo> selectRoleAllList() {
		return roleInfoDao.selectRoleAllList();
	}

	@Override
	public Page<RoleInfo> queryRolePage(Page<RoleInfo> page, Map<String, Object> map) {

		List<RoleInfo> list = roleInfoDao.selectRoleInfoListByMap(map);
		page.setTotalCount(list.size());
		page.setResult(list);
		return page;
	}

	/**
	 * 新增角色，同时为新角色添加菜单
	 *
	 * @param role
	 * @param menuIds
	 */
	@Override
	@Transactional
	public Map<String, Object> insertRoleInfo(RoleInfo role, String menuIds) {
		Map<String, Object> result = new HashMap<String,Object>();

		//先验证角色名称是否可用,(可用true  不可用false)
		boolean flag = this.validateName(role);
		if(true){
			result.put("status",0);
			result.put("message","该角色名称已存在！");
		}

		roleInfoDao.saveRoleInfo(role);

		// 添加新的权限
		if (StringUtils.isNotEmpty(menuIds)) {
			String[] funcTreeId = StringUtils.split(menuIds, ",");
			for (int i = 0; i < funcTreeId.length; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				RoleMenuRel entity = new RoleMenuRel();
				entity.setRoleId(role.getRoleId());
				entity.setMenuId(Long.valueOf(funcTreeId[i]));
				roleMenuRelDao.saveRoleMenuRel(entity);
			}
		}
		result.put("status",1);
		result.put("message","添加成功！");

		return result;
	}

	private boolean validateName(RoleInfo role){
		RoleInfo info = roleInfoDao.selectRoleInfoByRoleName(role.getRoleName());
		//如果没有查到role说明该角色名称没有使用可以新增，如果查询到角色信息，但是ID相等说明角色已经存在，并没有修改角色名称
		if(info==null || info.getRoleId()==role.getRoleId()){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 修改角色，同时为新角色添加菜单
	 *
	 * @param role
	 * @param menuIds
	 */
	@Override
	@Transactional
	public Map<String, Object> updateRoleInfo(RoleInfo role, String menuIds) {
		Map<String, Object> result = new HashMap<String,Object>();

		//先验证角色名称是否可用,(可用true  不可用false)
		boolean flag = this.validateName(role);
		if(true){
			result.put("status",0);
			result.put("message","该角色名称已存在！");
		}

		//修改角色
		roleInfoDao.updateRoleInfoById(role);

		//删除旧角色菜单对应关系
		roleMenuRelDao.deleteRoleMenuRelByRoleId(role.getRoleId());
		//添加新的对应关系
		if (StringUtils.isNotEmpty(menuIds)) {
			String[] funcTreeId = StringUtils.split(menuIds, ",");
			for (int i = 0; i < funcTreeId.length; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				RoleMenuRel entity = new RoleMenuRel();
				entity.setRoleId(role.getRoleId());
				entity.setMenuId(Long.valueOf(funcTreeId[i]));
				roleMenuRelDao.saveRoleMenuRel(entity);
			}
		}
		result.put("status",1);
		result.put("message","修改成功！");

		return result;
	}

	/**
	 * 删除角色，同时删除角色用户对应关系，角色菜单对应关系
	 *
	 * @param roleId
	 */
	@Override
	@Transactional
	public Map<String, Object> deleteRoleInfo(Long roleId) {
		Map<String, Object> result = new HashMap<String,Object>();

		int status = roleInfoDao.deleteRoleInfoByRoleId(roleId);
		if(status==0){
			result.put("status",0);
			result.put("message","删除失败！");
			return result;
		}

		//删除角色菜单对应关系
		int countMenu = roleMenuRelDao.selectRoleMenuRelByRoleId(roleId);
		if(countMenu !=0){
			roleMenuRelDao.deleteRoleMenuRelByRoleId(roleId);
		}

		//删除角色用户对应关系
		int countUser = userRoleRelDao.selectUserRoleRelByRoleId(roleId);
		if(countUser !=0){
			userRoleRelDao.deleteUserRoleRelByroleId(roleId);
		}
		//userRoleRelDao.deleteUserRoleRelByroleId(roleId);
		result.put("status",1);
		result.put("message","修改成功！");
		return result;
	}
}
