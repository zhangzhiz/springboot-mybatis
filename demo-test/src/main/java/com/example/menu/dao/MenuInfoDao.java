package com.example.menu.dao;


import com.example.common.datasource.mysql.MybatisMapper;
import com.example.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:34:15
 */
@Mapper
public interface MenuInfoDao extends MybatisMapper {
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
	MenuInfo selectMenuInfoById(Object id) ;


	/**
	 * 根据userName查找用户角色菜单
	 * @param userName
	 * @return
	 */
	List<MenuInfo> selectMeanInfoList(String userName);

	List<MenuInfo> queryMenuInfoListByMap(Map<String,Object> qMap);

	public List<MenuInfo> selectParentMenuAllList();

	/**
	 * 删除菜单
	 * */
	Integer deleteMenuInfoById(Long menuId);

	Integer changeMenuStatus(Map<String, Object> qMap);

	//验证菜单是否已存在
	MenuInfo queryMenuInfoListByEntity(MenuInfo entity);

	List<MenuInfo> selectAllMenuInfoList();

	List<MenuInfo> selectMeanInfoByRoleId(Long roleId);
}
