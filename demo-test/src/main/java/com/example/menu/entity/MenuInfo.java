package com.example.menu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.StringUtils;



/**
 * 
 * @author <zhangzhizhong>
 * @version  2017-04-18 17:34:15
 */

public class MenuInfo  implements Serializable{
	
	//columns START
	/**
	 * menu_id
	 */
	private Long menuId;
	/**
	 * menu_name
	 */
	private String menuName;
	/**
	 * menu_url
	 */
	private String menuUrl;
	/**
	 * parent_id
	 */
	private Long parentId;
	/**
	 * is_enable
	 */
	private String isEnable;
	/**
	 * update_time
	 */
	private Date updateTime;

	/**
	 * 菜单授权
	 * */
	private String menuPers;
	/**
	 * 菜单类型（0：目录   1：菜单   2：按钮）
	 * */
	private String menuType;

	/**
	 * 菜单排序
	 * */
	private Integer orderNum;
	//columns END 数据库字段结束
	
	

	//get and set
	public void setMenuId(Long menuId) {
	    
		this.menuId = menuId;
	}
	
	
	public Long getMenuId() {
		return this.menuId;
	}
	public void setMenuName(String menuName) {
	    
		    if(StringUtils.isNotBlank(menuName)){
			 menuName=menuName.trim();
			}
		this.menuName = menuName;
	}
	
	
	public String getMenuName() {
		return this.menuName;
	}
	public void setMenuUrl(String menuUrl) {
	    
		    if(StringUtils.isNotBlank(menuUrl)){
			 menuUrl=menuUrl.trim();
			}
		this.menuUrl = menuUrl;
	}
	
	
	public String getMenuUrl() {
		return this.menuUrl;
	}
	public void setParentId(Long parentId) {
	    
		this.parentId = parentId;
	}
	
	
	public Long getParentId() {
		return this.parentId;
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

	public String getMenuPers() {
		return menuPers;
	}

	public void setMenuPers(String menuPers) {
		this.menuPers = menuPers;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("menuId=").append(getMenuId()).append(",")
			.append("menuName=").append(getMenuName()).append(",")
			.append("menuUrl=").append(getMenuUrl()).append(",")
			.append("parentId=").append(getParentId()).append(",")
			.append("isEnable=").append(getIsEnable()).append(",")
			.append("updateTime=").append(getUpdateTime()).append(",")
			.toString();
	}
	
	
}

	
