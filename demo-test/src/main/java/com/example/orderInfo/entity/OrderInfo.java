package com.example.orderInfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;



/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-25 14:18:46
 */

public class OrderInfo  implements Serializable{
	
	//columns START
	/**
	 * 产品ID
	 */
	private Long productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品颜色
	 */
	private String productColor;
	/**
	 * 产品重量
	 */
	private String productWeight;
	/**
	 * 产品价格
	 */
	private Long productPrice;
	/**
	 * 生产厂家
	 */
	private String createCompany;
	/**
	 * 生产日期
	 */
	private Date createTime;
	//columns END 数据库字段结束
	
	

	//get and set
	public void setProductId(Long productId) {
	    
		this.productId = productId;
	}
	
	
	public Long getProductId() {
		return this.productId;
	}
	public void setProductName(String productName) {
	    
		    if(StringUtils.isNotBlank(productName)){
			 productName=productName.trim();
			}
		this.productName = productName;
	}
	
	
	public String getProductName() {
		return this.productName;
	}
	public void setProductColor(String productColor) {
	    
		    if(StringUtils.isNotBlank(productColor)){
			 productColor=productColor.trim();
			}
		this.productColor = productColor;
	}
	
	
	public String getProductColor() {
		return this.productColor;
	}
	public void setProductWeight(String productWeight) {
	    
		    if(StringUtils.isNotBlank(productWeight)){
			 productWeight=productWeight.trim();
			}
		this.productWeight = productWeight;
	}
	
	
	public String getProductWeight() {
		return this.productWeight;
	}
	public void setProductPrice(Long productPrice) {
	    
		this.productPrice = productPrice;
	}
	
	
	public Long getProductPrice() {
		return this.productPrice;
	}
	public void setCreateCompany(String createCompany) {
	    
		    if(StringUtils.isNotBlank(createCompany)){
			 createCompany=createCompany.trim();
			}
		this.createCompany = createCompany;
	}
	
	
	public String getCreateCompany() {
		return this.createCompany;
	}
		/*
	public String getcreate_timeString() {
		return DateUtils.convertDate2String(FORMAT_CREATE_TIME, getcreate_time());
	}
	public void setcreate_timeString(String value) throws ParseException{
		setcreate_time(DateUtils.convertString2Date(FORMAT_CREATE_TIME,value));
	}*/
	
	public void setCreateTime(String createTime) throws ParseException {
		if(createTime==null || "".equals(createTime)){
			this.createTime=null;
		}else{
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.createTime = sdf.parse(createTime);
		}

	}


	public Date getCreateTime() {
		return this.createTime;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("productId=").append(getProductId()).append(",")
			.append("productName=").append(getProductName()).append(",")
			.append("productColor=").append(getProductColor()).append(",")
			.append("productWeight=").append(getProductWeight()).append(",")
			.append("productPrice=").append(getProductPrice()).append(",")
			.append("createCompany=").append(getCreateCompany()).append(",")
			.append("createTime=").append(getCreateTime()).append(",")
			.toString();
	}
	
	
}

	
