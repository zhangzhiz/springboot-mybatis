package com.example.orderInfo.controller;


import com.alibaba.fastjson.JSON;
import com.example.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.example.orderInfo.entity.OrderInfo;
import com.example.orderInfo.service.OrderInfoService;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-25 14:18:46
 */
@Controller
@RequestMapping(value="/orderinfo")
public class OrderInfoController {
	 @Autowired
	private OrderInfoService orderInfoService;
	
	/**
	 * 列表主页面
	 *
	 * @return string
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String orderInfoMain(Map<String, Object> map) {
		Page<OrderInfo> page = new Page<OrderInfo>(10);
		Map<String, Object> queryMap=new HashMap<String, Object>();
		page = orderInfoService.queryOrderInfoPage(page, queryMap);
		List<OrderInfo> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/orderInfo/orderInfoList";
	}
	
	/**
	 * 查询
	 *
	 * @return String
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String orderInfoList(@ModelAttribute Page<OrderInfo> page, Map<String, Object> map, @ModelAttribute OrderInfo orderInfo) {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("orderInfo",orderInfo);
		page = orderInfoService.queryOrderInfoPage(page, queryMap);
		List<OrderInfo> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/orderInfo/orderInfoTable";
	}
	
	/**
	 * 进入新增页面
	 *
	 * @return String
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String orderInfoAddPage() {
		
		return "page/orderInfo/orderInfoAdd";
	}
	
	/**
	 * 提交新增
	 *
	 * @param orderInfo
	 * @return String
	 */
	@RequestMapping(value = "/orderInfoAdd", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String orderInfoAdd(@ModelAttribute OrderInfo orderInfo) throws Exception {
		String message="";
		Map<String, Object> result = new HashMap<String,Object>();

		int status = orderInfoService.saveOrderInfo(orderInfo);

		if(status==0){
			result.put("status",0);
			result.put("message","新增失败！");
		}else{
			result.put("status",1);
			result.put("message","新增成功！");
		}
		message = JSON.toJSONString(result);
		return message;
	}
	
	/**
	 * 进入修改页面
	 *
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/editPage/{id}", method = RequestMethod.GET)
	public String orderInfoEditPage(Map<String, Object> map,@PathVariable String id) throws Exception {
		//获取实体基本信息
		OrderInfo orderInfo = orderInfoService.selectOrderInfoById(Long.valueOf(id));
		map.put("orderInfo", orderInfo);

		return "page/orderInfo/orderInfoEdit";
	}
	
	/**
	 * 提交修改
	 *
	 * @param orderInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orderInfoEdit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String orderInfoUpdate(OrderInfo orderInfo, HttpServletRequest request) throws Exception {
		String message = "";
		Map<String, Object> result = new HashMap<String,Object>();
		
		int status = orderInfoService.updateOrderInfoById(orderInfo);
		
		if(status==0){
			result.put("status",0);
			result.put("message","修改失败！");
		}else{
			result.put("status",1);
			result.put("message","修改成功！");
		}
		message = JSON.toJSONString(result);
		return message;
	}
	
	/**
	 * 删除
	 *
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/orderInfoDelete/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String orderInfoDelete(@PathVariable String id) {
		String message = "";
		Map<String, Object> result = new HashMap<String,Object>();
		
		int status = orderInfoService.deleteOrderInfoById(Long.valueOf(id));
		if(status==0){
			result.put("status",0);
			result.put("message","修改失败！");
		}else{
			result.put("status",1);
			result.put("message","删除成功！");
		}
		message = JSON.toJSONString(result);
		return message;
	}
}
