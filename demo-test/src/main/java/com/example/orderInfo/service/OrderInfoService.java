package com.example.orderInfo.service;

import com.example.common.Page;
import com.example.orderInfo.entity.OrderInfo;

import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-25 14:18:46
 */
public interface OrderInfoService {
	/**
	 *保存
	 *
	 */
	public Integer  saveOrderInfo(OrderInfo entity) throws Exception;
	/**
	 *修改
	 *
	 */
	public Integer updateOrderInfoById(OrderInfo entity) throws Exception;
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	OrderInfo selectOrderInfoById(Object id) throws Exception;
	
	/**
	 *查询分页列表信息
	 *@param page
	 *@param queryMap
	 *@return page
	 */
	Page<OrderInfo> queryOrderInfoPage(Page<OrderInfo> page, Map<String, Object> queryMap);
	
	/**
	 *删除
	 *
	 */
	Integer deleteOrderInfoById(Object id);
	
		
}
