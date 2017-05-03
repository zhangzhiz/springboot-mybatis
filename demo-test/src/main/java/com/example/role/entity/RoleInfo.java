package com.example.role.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.StringUtils;



/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 10:33:28
 */

public class RoleInfo  implements Serializable{
	
	//columns START
	/**
	 * role_id
	 */
	private Long roleId;
	/**
	 * role_name
	 */
	private String roleName;
	/**
	 * is_enable
	 */
	private String isEnable;
	/**
	 * update_time
	 */
	private Date updateTime;
	//columns END 数据库字段结束
	
	

	//get and set
	public void setRoleId(Long roleId) {
	    
		this.roleId = roleId;
	}
	
	
	public Long getRoleId() {
		return this.roleId;
	}
	public void setRoleName(String roleName) {
	    
		    if(StringUtils.isNotBlank(roleName)){
			 roleName=roleName.trim();
			}
		this.roleName = roleName;
	}
	
	
	public String getRoleName() {
		return this.roleName;
	}
	public void setIsEnable(String isEnable) {
	    
		    if(StringUtils.isNotBlank(isEnable)){
			 isEnable=isEnable.trim();
			}
		this.isEnable = isEnable;
	}
	
	
	public String getIsEnable() {
		return this.isEnable;
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
			.append("roleId=").append(getRoleId()).append(",")
			.append("roleName=").append(getRoleName()).append(",")
			.append("isEnable=").append(getIsEnable()).append(",")
			.append("updateTime=").append(getUpdateTime()).append(",")
			.toString();
	}
	
	
}

	
