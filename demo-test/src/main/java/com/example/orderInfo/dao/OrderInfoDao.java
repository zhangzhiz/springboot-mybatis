package com.example.orderInfo.dao;

import com.example.orderInfo.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-25 14:18:46
 */
@Mapper
public interface OrderInfoDao{
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
	 * 根据Map查找
	 * @param queryMap
	 * @return list
	 * @throws Exception
	 */
	List<OrderInfo> selectOrderInfoListByMap(Map<String, Object> queryMap);
	
	/**
	 *删除
	 *
	 */
	Integer deleteOrderInfoById(Object id);
	
}
