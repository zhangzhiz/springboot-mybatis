package com.example.menu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.StringUtils;



/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:37:56
 */

public class RoleMenuRel  implements Serializable{
	
	//columns START
	/**
	 * id
	 */
	private Long id;
	/**
	 * role_id
	 */
	private Long roleId;
	/**
	 * menu_id
	 */
	private Long menuId;
	//columns END 数据库字段结束
	
	

	//get and set
	public void setId(Long id) {
	    
		this.id = id;
	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setRoleId(Long roleId) {
	    
		this.roleId = roleId;
	}
	
	
	public Long getRoleId() {
		return this.roleId;
	}
	public void setMenuId(Long menuId) {
	    
		this.menuId = menuId;
	}
	
	
	public Long getMenuId() {
		return this.menuId;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("id=").append(getId()).append(",")
			.append("roleId=").append(getRoleId()).append(",")
			.append("menuId=").append(getMenuId()).append(",")
			.toString();
	}
	
	
}

	
