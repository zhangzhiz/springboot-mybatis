package com.example.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.StringUtils;



/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 11:38:09
 */

public class UserRoleRel  implements Serializable{
	
	//columns START
	/**
	 * id
	 */
	private Long id;
	/**
	 * user_id
	 */
	private Long userId;
	/**
	 * role_id
	 */
	private Long roleId;
	//columns END 数据库字段结束
	
	

	//get and set
	public void setId(Long id) {
	    
		this.id = id;
	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setUserId(Long userId) {
	    
		this.userId = userId;
	}
	
	
	public Long getUserId() {
		return this.userId;
	}
	public void setRoleId(Long roleId) {
	    
		this.roleId = roleId;
	}
	
	
	public Long getRoleId() {
		return this.roleId;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("id=").append(getId()).append(",")
			.append("userId=").append(getUserId()).append(",")
			.append("roleId=").append(getRoleId()).append(",")
			.toString();
	}
	
	
}

	
