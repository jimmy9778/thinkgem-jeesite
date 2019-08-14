/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wx.entity.WxMp;
import com.thinkgem.jeesite.modules.wx.dao.WxMpDao;

/**
 * 微信公众号管理Service
 * @author jimmy_bhb
 * @version 2018-02-06
 */
@Service
@Transactional(readOnly = true)
public class WxMpService extends CrudService<WxMpDao,WxMp> {

	public WxMp get(String id) {
		return super.get(id);
	}
	
	public List<WxMp> findList(WxMp wxMp) {
		return super.findList(wxMp);
	}
	
	public Page<WxMp> findPage(Page<WxMp> page, WxMp wxMp) {
		return super.findPage(page, wxMp);
	}
	
	@Transactional(readOnly = false)
	public void save(WxMp wxMp) {
		super.save(wxMp);
	}
	
	@Transactional(readOnly = false)
	public void delete(WxMp wxMp) {
		super.delete(wxMp);
	}
	
}