/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apkver.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * app版本管理Entity
 * @author jimmy
 * @version 2018-02-06
 */
public class AppVersionChip extends DataEntity<AppVersionChip> {
	
	private static final long serialVersionUID = 1L;
	private Integer appid;		// appID
	private Integer chipid;		// 设备型号
	private String updatetype;		// 升级类型
	private String chipappversion;		// apk版本
	private String chipapppackname;		// apk名称
	private Long apppacksize;		// apk包大小
	private String modtime;		// 上传修改时间
	private String chipdesc;		// 备注信息
	
	public AppVersionChip() {
		super();
	}

	public AppVersionChip(String id){
		super(id);
	}

	@NotNull(message="appID不能为空")
	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	
	@NotNull(message="设备型号不能为空")
	public Integer getChipid() {
		return chipid;
	}

	public void setChipid(Integer chipid) {
		this.chipid = chipid;
	}
	
	@Length(min=0, max=4, message="升级类型长度必须介于 0 和 4 之间")
	public String getUpdatetype() {
		return updatetype;
	}

	public void setUpdatetype(String updatetype) {
		this.updatetype = updatetype;
	}
	
	@Length(min=0, max=20, message="apk版本长度必须介于 0 和 20 之间")
	public String getChipappversion() {
		return chipappversion;
	}

	public void setChipappversion(String chipappversion) {
		this.chipappversion = chipappversion;
	}
	
	@Length(min=0, max=100, message="apk名称长度必须介于 0 和 100 之间")
	public String getChipapppackname() {
		return chipapppackname;
	}

	public void setChipapppackname(String chipapppackname) {
		this.chipapppackname = chipapppackname;
	}
	
	public Long getApppacksize() {
		return apppacksize;
	}

	public void setApppacksize(Long apppacksize) {
		this.apppacksize = apppacksize;
	}
	
	@Length(min=0, max=20, message="上传修改时间长度必须介于 0 和 20 之间")
	public String getModtime() {
		return modtime;
	}

	public void setModtime(String modtime) {
		this.modtime = modtime;
	}
	
	@Length(min=0, max=20, message="备注信息长度必须介于 0 和 20 之间")
	public String getChipdesc() {
		return chipdesc;
	}

	public void setChipdesc(String chipdesc) {
		this.chipdesc = chipdesc;
	}
	
}