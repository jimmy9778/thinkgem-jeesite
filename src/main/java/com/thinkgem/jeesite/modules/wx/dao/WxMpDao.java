/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wx.entity.WxMp;

/**
 * 微信公众号管理DAO接口
 * @author jimmy_bhb
 * @version 2018-02-06
 */
@MyBatisDao
public interface WxMpDao extends CrudDao<WxMp> {
	
}