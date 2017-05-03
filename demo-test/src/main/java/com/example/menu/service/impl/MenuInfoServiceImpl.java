package com.example.menu.service.impl;


import com.example.common.Page;
import com.example.menu.dao.MenuInfoDao;
import com.example.menu.dao.RoleMenuRelDao;
import com.example.menu.entity.MenuInfo;
import com.example.menu.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:34:15
 */
@Service("menuInfoService")
public class MenuInfoServiceImpl implements MenuInfoService {
	@Autowired
    private MenuInfoDao menuInfoDao;

	@Autowired
	private RoleMenuRelDao roleMenuRelDao;
   
    @Override
	public Integer  saveMenuInfo(MenuInfo entity ){
	       return menuInfoDao.saveMenuInfo(entity);
	}

	
	@Override
    public Integer updateMenuInfoById(MenuInfo entity ){
	return menuInfoDao.updateMenuInfoById(entity);
    }
    @Override
	public MenuInfo selectMenuInfoById(Object id){
	 return menuInfoDao.selectMenuInfoById(id);
	}

	@Override
	public List<MenuInfo> selectMeanInfoList(String userName) {
		return menuInfoDao.selectMeanInfoList(userName);
	}

	@Override
	public Page<MenuInfo> queryMenuInfoListByMap(Page<MenuInfo> page, Map<String, Object> qMap) {
		List<MenuInfo> list = menuInfoDao.queryMenuInfoListByMap(qMap);
		page.setTotalCount(list.size());
		page.setResult(list);
		return page;
	}

	@Override
	public List<MenuInfo> selectParentMenuAllList() {
		return menuInfoDao.selectParentMenuAllList();
	}

	@Override
	@Transactional
	public Map<String, Object> insertMenuInfo(MenuInfo entity) {

		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menuName",entity.getMenuName());
		MenuInfo info = menuInfoDao.queryMenuInfoListByEntity(entity);
		if(info==null){
			int status = menuInfoDao.saveMenuInfo(entity);
			result.put("status",status);
		}else{
			result.put("status",0);
			result.put("message","菜单已存在");
		}
		return result;
	}

	@Override
	@Transactional
	public Map<String, Object> updateMenuInfo(MenuInfo entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menuName",entity.getMenuName());
		MenuInfo info = menuInfoDao.queryMenuInfoListByEntity(entity);
		if(info==null || info.getMenuId()==entity.getMenuId()){
			int status = menuInfoDao.updateMenuInfoById(entity);
			result.put("status",status);
		}else{
			result.put("status",0);
			result.put("message","菜单已存在");
		}
		return result;
	}

	@Override
	@Transactional
	public Map<String, Object> deleteMenuInfo(Long menuId) {
		Map<String, Object> result = new HashMap<String, Object>();
		int status = menuInfoDao.deleteMenuInfoById(menuId);
		if(status==0){
			result.put("message","删除失败！");
			result.put("status",0);
			return result;
		}else {
			int count = roleMenuRelDao.selectRoleMenuRelByMenuId(menuId);
			if(count !=0){
				roleMenuRelDao.deleteRoleMenuRelByMenuId(menuId);
			}

		}

		result.put("message","删除成功！");
		result.put("status",1);

		return result;
	}


	@Override
	public Map<String, Object> enableMenu(String ids) {
		Map<String, Object> result = new HashMap<String,Object>();
		String[] menuIds = ids.split(",");

		Map<String,Object> param = new HashMap<String,Object>();
		param.put("menuIds",menuIds);
		param.put("isEnable","1");

		menuInfoDao.changeMenuStatus(param);

		result.put("message","启用成功！");
		result.put("status",1);

		return result;
	}

	@Override
	public Map<String, Object> disableMenu(String ids) {
		Map<String, Object> result = new HashMap<String,Object>();
		String[] menuIds = ids.split(",");

		Map<String,Object> param = new HashMap<String,Object>();
		param.put("menuIds",menuIds);
		param.put("isEnable","0");

		menuInfoDao.changeMenuStatus(param);

		result.put("message","禁用成功！");
		result.put("status",1);

		return result;
	}

	@Override
	public List<MenuInfo> selectAllMenuInfoList() {
		return menuInfoDao.selectAllMenuInfoList();
	}

	@Override
	public List<MenuInfo> selectMeanInfoByRoleId(Long roleId) {
		return menuInfoDao.selectMeanInfoByRoleId(roleId);
	}
}
