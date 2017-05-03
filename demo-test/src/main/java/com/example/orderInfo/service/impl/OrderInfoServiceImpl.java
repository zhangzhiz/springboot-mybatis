package com.example.orderInfo.service.impl;


import com.example.orderInfo.entity.OrderInfo;
import com.example.orderInfo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.common.Page;

import com.example.orderInfo.dao.OrderInfoDao;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-25 14:18:46
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
    private OrderInfoDao orderInfoDao;
   
    @Override
	public Integer  saveOrderInfo(OrderInfo entity ) throws Exception{
	       return orderInfoDao.saveOrderInfo(entity);
	}

	
	@Override
    public Integer updateOrderInfoById(OrderInfo entity ) throws Exception{
	return orderInfoDao.updateOrderInfoById(entity);
    }
	
    @Override
	public OrderInfo selectOrderInfoById(Object id) throws Exception{
	 return orderInfoDao.selectOrderInfoById(id);
	}
	
	@Override
	public Page<OrderInfo> queryOrderInfoPage(Page<OrderInfo> page, Map<String,Object> queryMap){
		
		List<OrderInfo> list = orderInfoDao.selectOrderInfoListByMap(queryMap);
		page.setTotalCount(list.size());
		page.setResult(list);
		return page;
		
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public Integer deleteOrderInfoById(Object id) {


		return orderInfoDao.deleteOrderInfoById(id);
	}
}
