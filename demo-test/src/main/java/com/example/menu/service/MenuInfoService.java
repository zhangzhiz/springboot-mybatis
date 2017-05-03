package com.example.menu.service;


import com.example.common.Page;
import com.example.menu.entity.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:34:15
 */
public interface MenuInfoService {
	/**
	 *保存
	 *
	 */
	public Integer  saveMenuInfo(MenuInfo entity);
	/**
	 *修改
	 *
	 */
	public Integer updateMenuInfoById(MenuInfo entity);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	MenuInfo selectMenuInfoById(Object id);

	/**
	 * 根据userName查找用户角色菜单
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	List<MenuInfo> selectMeanInfoList(String userName);

	public Page<MenuInfo>  queryMenuInfoListByMap(Page<MenuInfo> page, Map<String,Object> qMap);

	public List<MenuInfo> selectParentMenuAllList();

	/**
	 *新增菜单，先检查是否存在
	 *
	 */
	public Map<String,Object> insertMenuInfo(MenuInfo entity);


	/**
	 *修改菜单，先检查是否存在
	 *
	 */
	public Map<String,Object> updateMenuInfo(MenuInfo entity);


	/**
	 * 删除菜单，并且删除菜单和角色的对应关系
	 * */
	public Map<String,Object> deleteMenuInfo(Long menuId);

	/**
	 * 菜单启用
	 * */
	public Map<String,Object> enableMenu(String ids);
	/**
	 * 菜单禁用
	 * */
	public Map<String,Object> disableMenu(String ids);

	List<MenuInfo> selectAllMenuInfoList();

	List<MenuInfo> selectMeanInfoByRoleId(Long roleId);
}
