package com.example.othersource.lrh.controller;


import com.example.common.Page;
import com.example.menu.service.MenuInfoService;
import com.example.othersource.lrh.entity.UserDetail;
import com.example.othersource.lrh.service.UserDetailService;
import com.example.user.entity.ManageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:34:15
 */
@RestController
@RequestMapping(value="/userdetail")
public class UserDetailController {
	 @Autowired
	private UserDetailService userDetailService;

	/**
	 * 用户列表主页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String userMain(Map<String, Object> map) {
		List<UserDetail> list=userDetailService.selectAllUsers();
		return list.get(0).getName();
	}
	
}
