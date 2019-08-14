/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 微信公众号管理Entity
 * @author jimmy_bhb
 * @version 2018-02-06
 */
public class WxMp extends DataEntity<WxMp> {
	
	private static final long serialVersionUID = 1L;
	private String mpcname;		// 微信公众号
	private String mpname;		// 微信公众号
	private String appname;		// 登陆账户
	private Integer status;		// 状态
	private String appid;		// 开发者ID
	private String appsecret;		// 开发者密码
	private String opentoken;		// 开发者令牌
	private String codeurl;		// code地址
	private String openserverurl;		// 公众服务l号服务器地址
	private Integer secuteflag;		// 加密方式
	private Integer userdatatype;		// 微信用户绑定数
	private String openaeskey;		// 消息加密密锁
	private String subrespmsg;		// 订阅提示信息
	private String inmpmsg;		// 已订阅提示信息
	private String username;		// 公众号联系人
	private String mobile;		// 联系号码
	private String appveridlist;		// app版本ID列表，多个ID之间以逗号分开，ID对用app_version中appId字段
	private Date createtime;		// 创建日期
	private String mpdesc;		// 描述
	
	public WxMp() {
		super();
	}

	public WxMp(String id){
		super(id);
	}

	@Length(min=1, max=20, message="微信公众号长度必须介于 1 和 20 之间")
	public String getMpcname() {
		return mpcname;
	}

	public void setMpcname(String mpcname) {
		this.mpcname = mpcname;
	}
	
	@Length(min=1, max=40, message="微信公众号长度必须介于 1 和 40 之间")
	public String getMpname() {
		return mpname;
	}

	public void setMpname(String mpname) {
		this.mpname = mpname;
	}
	
	@Length(min=0, max=40, message="登陆账户长度必须介于 0 和 40 之间")
	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Length(min=1, max=18, message="开发者ID长度必须介于 1 和 18 之间")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	@Length(min=0, max=32, message="开发者密码长度必须介于 0 和 32 之间")
	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	
	@Length(min=0, max=32, message="开发者令牌长度必须介于 0 和 32 之间")
	public String getOpentoken() {
		return opentoken;
	}

	public void setOpentoken(String opentoken) {
		this.opentoken = opentoken;
	}
	
	@Length(min=0, max=100, message="code地址长度必须介于 0 和 100 之间")
	public String getCodeurl() {
		return codeurl;
	}

	public void setCodeurl(String codeurl) {
		this.codeurl = codeurl;
	}
	
	@Length(min=0, max=100, message="公众服务l号服务器地址长度必须介于 0 和 100 之间")
	public String getOpenserverurl() {
		return openserverurl;
	}

	public void setOpenserverurl(String openserverurl) {
		this.openserverurl = openserverurl;
	}
	
	public Integer getSecuteflag() {
		return secuteflag;
	}

	public void setSecuteflag(Integer secuteflag) {
		this.secuteflag = secuteflag;
	}
	
	public Integer getUserdatatype() {
		return userdatatype;
	}

	public void setUserdatatype(Integer userdatatype) {
		this.userdatatype = userdatatype;
	}
	
	@Length(min=0, max=100, message="消息加密密锁长度必须介于 0 和 100 之间")
	public String getOpenaeskey() {
		return openaeskey;
	}

	public void setOpenaeskey(String openaeskey) {
		this.openaeskey = openaeskey;
	}
	
	@Length(min=0, max=255, message="订阅提示信息长度必须介于 0 和 255 之间")
	public String getSubrespmsg() {
		return subrespmsg;
	}

	public void setSubrespmsg(String subrespmsg) {
		this.subrespmsg = subrespmsg;
	}
	
	@Length(min=0, max=255, message="已订阅提示信息长度必须介于 0 和 255 之间")
	public String getInmpmsg() {
		return inmpmsg;
	}

	public void setInmpmsg(String inmpmsg) {
		this.inmpmsg = inmpmsg;
	}
	
	@Length(min=0, max=40, message="公众号联系人长度必须介于 0 和 40 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=0, max=100, message="联系号码长度必须介于 0 和 100 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=100, message="app版本ID列表，多个ID之间以逗号分开，ID对用app_version中appId字段长度必须介于 0 和 100 之间")
	public String getAppveridlist() {
		return appveridlist;
	}

	public void setAppveridlist(String appveridlist) {
		this.appveridlist = appveridlist;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=100, message="描述长度必须介于 0 和 100 之间")
	public String getMpdesc() {
		return mpdesc;
	}

	public void setMpdesc(String mpdesc) {
		this.mpdesc = mpdesc;
	}
	
}