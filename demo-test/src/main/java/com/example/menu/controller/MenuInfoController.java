package com.example.menu.controller;


import com.alibaba.fastjson.JSON;
import com.example.common.Page;
import com.example.menu.entity.MenuInfo;
import com.example.menu.service.MenuInfoService;
import com.example.role.entity.RoleInfo;
import com.example.user.entity.ManageUser;
import com.example.user.entity.UserRoleRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:34:15
 */
@Controller
@RequestMapping(value="/menuinfo")
public class MenuInfoController {
	 @Autowired
	private MenuInfoService menuInfoService;

	/**
	 * 用户列表主页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String menuMain(Map<String, Object> map) {
		Page<MenuInfo> page = new Page<MenuInfo>(10);
		page.setOrderBy("create_date");
		//page.setOrder("desc");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		page = menuInfoService.queryMenuInfoListByMap(page,queryMap);
		List<MenuInfo> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/menu/menuList";
	}

	/**
	 * 用户列表主页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String menuList(@ModelAttribute Page<MenuInfo> page, Map<String, Object> map, @RequestParam("menuName") String menuName, @RequestParam("isEnable") String isEnable) {

		page.setOrderBy("create_date");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("menuName",menuName);
		queryMap.put("isEnable",isEnable);
		page = menuInfoService.queryMenuInfoListByMap(page, queryMap);
		List<MenuInfo> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/menu/menuTable";
	}

	/**
	 * 进入新增页面
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String menuAddPage(Map<String, Object> map) {
		List<MenuInfo> allMenuList = menuInfoService.selectParentMenuAllList();
		map.put("allMenuList", allMenuList);

		return "page/menu/menuAdd";
	}

	/**
	 * 菜单新增
	 *
	 * @param menu
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menuAdd", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menuAdd(@ModelAttribute MenuInfo menu, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		String parentId = request.getParameter("parentId");
		if("on".equals(menu.getIsEnable())){
			menu.setIsEnable("1");
		}else{
			menu.setIsEnable("0");
		}
		menu.setUpdateTime(new Date());

		if(!StringUtils.isEmpty(parentId)){
			menu.setParentId(Long.valueOf(parentId));
		}
		result = menuInfoService.insertMenuInfo(menu);
		String jsonStr = JSON.toJSONString(result);
		return jsonStr;
	}


	/**
	 * 进入修改页面
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editPage/{id}", method = RequestMethod.GET)
	public String menuEditPage(Map<String,Object> map,@PathVariable String id) {

		MenuInfo menu = menuInfoService.selectMenuInfoById(Long.valueOf(id));
		List<MenuInfo> allMenuList = menuInfoService.selectParentMenuAllList();

		map.put("menu",menu);
		map.put("allMenuList", allMenuList);

		return "page/menu/menuEdit";
	}

	/**
	 * 菜单修改
	 *
	 * @param menu
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menuEdit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menuUpdate(MenuInfo menu, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		String parentId = request.getParameter("parentId");
		if("on".equals(menu.getIsEnable())){
			menu.setIsEnable("1");
		}else{
			menu.setIsEnable("0");
		}
		menu.setUpdateTime(new Date());

		if(!StringUtils.isEmpty(parentId)){
			menu.setParentId(Long.valueOf(parentId));
		}
		result = menuInfoService.updateMenuInfo(menu);

		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 菜单删除
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuDelete/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menuDelete(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String,Object>();

		result = menuInfoService.deleteMenuInfo(Long.valueOf(id));
		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 启用菜单
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/enableMenu/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public String enableMenu(@PathVariable String ids, HttpServletRequest request) {

		Map<String, Object> result = new HashMap<String,Object>();

		result = menuInfoService.enableMenu(ids);
		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 禁用用户
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/disableMenu/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public String disableMenu(@PathVariable String ids, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();

		result = menuInfoService.disableMenu(ids);
		String message = JSON.toJSONString(result);
		return message;
	}
	
}
