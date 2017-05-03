package com.example.role.controller;


import com.alibaba.fastjson.JSON;
import com.example.common.Page;
import com.example.menu.entity.MenuInfo;
import com.example.menu.service.MenuInfoService;
import com.example.role.entity.RoleInfo;
import com.example.role.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 10:33:28
 */
@Controller
@RequestMapping(value="/roleinfo")
public class RoleInfoController {
	 @Autowired
	private RoleInfoService roleInfoService;
	@Autowired
	private MenuInfoService menuInfoService;


	/**
	 * 角色列表主页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String roleMain(Map<String, Object> map) {
		Page<RoleInfo> page = new Page<RoleInfo>(10);
		//page.setOrderBy("create_date");
		//page.setOrder("desc");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		page = roleInfoService.queryRolePage(page, queryMap);
		List<RoleInfo> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/role/roleList";
	}

	/**
	 * 角色查询
	 *
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String roleList(@ModelAttribute Page<RoleInfo> page, Map<String, Object> map, @RequestParam("roleName") String roleName) {
		//page.setOrderBy(qDto.getOrderField());
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("roleName",roleName);
		//queryMap.put("isEnable",isEnable);
		page = roleInfoService.queryRolePage(page, queryMap);
		List<RoleInfo> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/role/roleTable";
	}

	/**
	 * 进入新增页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String roleAddPage(Map<String, Object> map) {

		Collection<MenuInfo> allMenuList = menuInfoService.selectAllMenuInfoList();
		Collection<MenuInfo> selectedModule = null;
		// 获取该角色所拥有的权限
		map.put("funcTreeStr", setTree(allMenuList,selectedModule));

		return "page/role/roleAdd";
	}

	/**
	 * 角色新增
	 *
	 * @param role
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/roleAdd", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String roleAdd(@ModelAttribute RoleInfo role, HttpServletRequest request) {
		String message="";
		Map<String, Object> result = new HashMap<String,Object>();

		if("on".equals(role.getIsEnable())){
			role.setIsEnable("1");
		}else{
			role.setIsEnable("0");
		}
		String funcIdTreeStr = request.getParameter("funcIdTreeStr");
		result = roleInfoService.insertRoleInfo(role,funcIdTreeStr);
		message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 进入修改页面
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editPage/{id}", method = RequestMethod.GET)
	public String roleEditPage(Map<String, Object> map,@PathVariable String id) {
		RoleInfo role = roleInfoService.selectRoleInfoById(Long.valueOf(id));

		Collection<MenuInfo> allMenuList = menuInfoService.selectAllMenuInfoList();
		Collection<MenuInfo> selectedModule = menuInfoService.selectMeanInfoByRoleId(Long.valueOf(id));

		//Integer count = roleService.getFuncCount();
		// 获取该角色所拥有的权限
		map.put("funcTreeStr", setTree(allMenuList,selectedModule));
		//mv.addObject("count", count);
		map.put("role", role);

		return "page/role/roleEdit";
	}

	/**
	 * 角色修改
	 *
	 * @param role
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/roleEdit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String roleUpdate(RoleInfo role, HttpServletRequest request) {
		String message = "SUCCESS";
		Map<String, Object> result = new HashMap<String,Object>();
		if("on".equals(role.getIsEnable())){
			role.setIsEnable("1");
		}else{
			role.setIsEnable("0");
		}
		String funcIdTreeStr = request.getParameter("funcIdTreeStr");
		result = roleInfoService.updateRoleInfo(role,funcIdTreeStr);

		message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 角色删除
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/roleDelete/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String roleDelete(@PathVariable String id, HttpServletRequest request) {
		String message = "SUCCESS";
		Map<String, Object> result = new HashMap<String,Object>();
		result = roleInfoService.deleteRoleInfo(Long.valueOf(id));
		message = JSON.toJSONString(result);
		return message;
	}



	// 组合树形控件字符串,角色中有的权限则选中
	// { id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
	// { id:1, pId:0, name:"随意勾选 1", open:true},
	private String setTree(Collection<MenuInfo> listAll, Collection<MenuInfo> listSelect) {
		StringBuffer sb = new StringBuffer("");
		for (MenuInfo o : listAll) {
			MenuInfo func = (MenuInfo) o;
			boolean isSelect = false;
			if (listSelect != null) {
				for (MenuInfo m : listSelect) {
					isSelect = m.getMenuId().equals(func.getMenuId());
					if (isSelect) {
						break;
					}
				}
			}
			if (isSelect) {
				sb.append("{ id:" + func.getMenuId() + ",");
				sb.append("pId:" + (func.getParentId() != null ? func.getParentId() : 0) + ",");
				sb.append("name:'" + func.getMenuName());
				sb.append("',");
				sb.append("checked:true,open:true},");
			} else {
				sb.append("{ id:" + func.getMenuId() + ",");
				sb.append("pId:" + (func.getParentId() != null ? func.getParentId() : 0) + ",");
				sb.append("name:'" + func.getMenuName());
				sb.append("',");
				sb.append("checked:false,open:false},");
			}
		}
		if (sb.toString().length() > 1) {
			return sb.toString().substring(0, sb.length() - 1);
		} else {
			return null;
		}
	}
	
}
