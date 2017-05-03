package com.example.user.controller;


import com.alibaba.fastjson.JSON;
import com.example.common.Page;
import com.example.role.entity.RoleInfo;
import com.example.role.service.RoleInfoService;
import com.example.user.entity.ManageUser;
import com.example.user.entity.UserRoleRel;
import com.example.user.service.ManageUserService;
import com.example.user.service.UserRoleRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-17 09:52:01
 */
@Controller
@RequestMapping(value="/manageuser")
public class ManageUserController {
    @Autowired
	private ManageUserService manageUserService;

	@Autowired
	private RoleInfoService roleInfoService;

	@Autowired
	private UserRoleRelService userRoleRelService;

	// 从 application.properties 中读取配置，如取不到默认值为Hello
	@Value("${manageuser.password}")
	private String userPassword;


	/**
	 * 用户列表主页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String userMain(Map<String, Object> map) {
		Page<ManageUser> page = new Page<ManageUser>(10);
		page.setOrderBy("create_date");
		//page.setOrder("desc");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		page = manageUserService.queryUserPage(page, queryMap);
		List<ManageUser> list = page.getResult();
		map.put("list", list);
        map.put("page", page);
		return "page/user/userList";
	}

	/**
	 * 用户列表主页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String userList(@ModelAttribute Page<ManageUser> page,Map<String, Object> map, @RequestParam("userName") String userName,@RequestParam("isEnable") String isEnable) {

		page.setOrderBy("create_date");
		//page.setOrder("desc");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("userName",userName);
		queryMap.put("isEnable",isEnable);
		page = manageUserService.queryUserPage(page, queryMap);
		List<ManageUser> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/user/userTable";
	}

	/**
	 * 进入新增页面
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String userAddPage(Map<String, Object> map) {
		List<RoleInfo> allRoleList = roleInfoService.selectRoleAllList();
		map.put("allRoleList", allRoleList);

		return "page/user/userAdd";
	}

	/**
	 * 用户新增
	 *
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userAdd", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userAdd(@ModelAttribute ManageUser user, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		String roleId = request.getParameter("roleId");
		if("on".equals(user.getIsEnable())){
			user.setIsEnable("1");
		}else{
			user.setIsEnable("0");
		}
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		result = manageUserService.insertManageUserInfo(user,roleId);

		String jsonStr = JSON.toJSONString(result);
		//net.sf.json.JSONObject oj = net.sf.json.JSONObject.fromObject(result);
		return jsonStr;
	}

	/**
	 * 用户删除
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/userDelete/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userDelete(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String,Object>();

		result = manageUserService.deleteUserInfo(Long.valueOf(id));
		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 重置密码
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/resetPwd/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String resetPwd(@PathVariable String id, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();

		ManageUser entity = new ManageUser();
		entity.setUserId(Long.valueOf(id));
		entity.setUserPassword(userPassword);
		result = manageUserService.changeUserPassword(entity);
		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 进入修改页面
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editPage/{id}", method = RequestMethod.GET)
	public String userEditPage(Map<String,Object> map,@PathVariable String id) {
		ManageUser user = manageUserService.selectManageUserById(Long.valueOf(id));
		UserRoleRel rel = userRoleRelService.selectUserRoleRelById(Long.valueOf(id));

		List<RoleInfo> allRoleList = roleInfoService.selectRoleAllList();

		map.put("user",user);
		map.put("roleId",rel.getRoleId());
		map.put("allRoleList",allRoleList);

		return "page/user/userEdit";
	}

	/**
	 * 用户修改
	 *
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userEdit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userUpdate(ManageUser user, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		String roleId = request.getParameter("roleId");
		if("on".equals(user.getIsEnable())){
			user.setIsEnable("1");
		}else{
			user.setIsEnable("0");
		}
		int status = manageUserService.updateManageUserById(user);
		UserRoleRel rel = new UserRoleRel();
		rel.setUserId(user.getUserId());
		rel.setRoleId(Long.valueOf(roleId));
		status = userRoleRelService.updateUserRoleRelById(rel);
		if(status==0){
			result.put("status",0);
			result.put("message","修改失败！");
		}else{
			result.put("status",1);
			result.put("message","修改成功！");
		}

		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 启用用户
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/enableUser/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public String enableUser(@PathVariable String ids, HttpServletRequest request) {

		Map<String, Object> result = new HashMap<String,Object>();

		result = manageUserService.enableUser(ids);
		String message = JSON.toJSONString(result);
		return message;
	}

	/**
	 * 禁用用户
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/disableUser/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public String disableUser(@PathVariable String ids, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();

		result = manageUserService.disableUser(ids);
		String message = JSON.toJSONString(result);
		return message;
	}
}
