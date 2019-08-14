/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apkver.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.apkver.entity.AppVersionChip;
import com.thinkgem.jeesite.modules.apkver.dao.AppVersionChipDao;

/**
 * app版本管理Service
 * @author jimmy
 * @version 2018-02-06
 */
@Service
@Transactional(readOnly = true)
public class AppVersionChipService extends CrudService<AppVersionChipDao, AppVersionChip> {

	public AppVersionChip get(String id) {
		return super.get(id);
	}
	
	public List<AppVersionChip> findList(AppVersionChip appVersionChip) {
		return super.findList(appVersionChip);
	}
	
	public Page<AppVersionChip> findPage(Page<AppVersionChip> page, AppVersionChip appVersionChip) {
		return super.findPage(page, appVersionChip);
	}
	
	@Transactional(readOnly = false)
	public void save(AppVersionChip appVersionChip) {
		super.save(appVersionChip);
	}
	
	@Transactional(readOnly = false)
	public void delete(AppVersionChip appVersionChip) {
		super.delete(appVersionChip);
	}
	
}