package com.example.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-17 09:52:01
 */

public class ManageUser  implements Serializable{
	
	//columns START
	/**
	 * user_id
	 */
	private Long userId;
	/**
	 * user_name
	 */
	private String userName;
	/**
	 * user_password
	 */
	private String userPassword;
	/**
	 * is_enable
	 */
	private String isEnable;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * update_time
	 */
	private Date updateTime;
	//columns END 数据库字段结束
	
	

	//get and set
	public void setUserId(Long userId) {
	    
		this.userId = userId;
	}
	
	
	public Long getUserId() {
		return this.userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getUserName() {
		return this.userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	public String getUserPassword() {
		return this.userPassword;
	}
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
	
	
	public String getIsEnable() {
		return this.isEnable;
	}

	public void setCreateTime(Date createTime) {
	    
		this.createTime = createTime;
	}
	
	
	public Date getCreateTime() {
		return this.createTime;
	}
		/*
	public String getupdate_timeString() {
		return DateUtils.convertDate2String(FORMAT_UPDATE_TIME, getupdate_time());
	}
	public void setupdate_timeString(String value) throws ParseException{
		setupdate_time(DateUtils.convertString2Date(FORMAT_UPDATE_TIME,value));
	}*/
	
	public void setUpdateTime(Date updateTime) {
	    
		this.updateTime = updateTime;
	}
	
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("userId=").append(getUserId()).append(",")
			.append("userName=").append(getUserName()).append(",")
			.append("userPassword=").append(getUserPassword()).append(",")
			.append("isEnable=").append(getIsEnable()).append(",")
			.append("createTime=").append(getCreateTime()).append(",")
			.append("updateTime=").append(getUpdateTime()).append(",")
			.toString();
	}
	
	
}

	
