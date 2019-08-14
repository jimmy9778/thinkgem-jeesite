/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wx.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wx.entity.WxMp;
import com.thinkgem.jeesite.modules.wx.service.WxMpService;

/**
 * 微信公众号管理Controller
 * @author jimmy_bhb
 * @version 2018-02-06
 */
@Controller
@RequestMapping(value = "${adminPath}/wx/wxMp")
public class WxMpController extends BaseController {

	@Autowired
	private WxMpService wxMpService;
	
	@ModelAttribute
	public WxMp get(@RequestParam(required=false) String id) {
		WxMp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wxMpService.get(id);
		}
		if (entity == null){
			entity = new WxMp();
		}
		return entity;
	}
	
	@RequiresPermissions("wx:wxMp:view")
	@RequestMapping(value = {"list", ""})
	public String list(WxMp wxMp, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WxMp> page = wxMpService.findPage(new Page<WxMp>(request, response), wxMp); 
		model.addAttribute("page", page);
		return "modules/wx/wxMpList";
	}

	@RequiresPermissions("wx:wxMp:view")
	@RequestMapping(value = "form")
	public String form(WxMp wxMp, Model model) {
		model.addAttribute("wxMp", wxMp);
		return "modules/wx/wxMpForm";
	}

	@RequiresPermissions("wx:wxMp:edit")
	@RequestMapping(value = "save")
	public String save(WxMp wxMp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wxMp)){
			return form(wxMp, model);
		}
		wxMpService.save(wxMp);
		addMessage(redirectAttributes, "保存微信公众号成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxMp/?repage";
	}
	
	@RequiresPermissions("wx:wxMp:edit")
	@RequestMapping(value = "delete")
	public String delete(WxMp wxMp, RedirectAttributes redirectAttributes) {
		wxMpService.delete(wxMp);
		addMessage(redirectAttributes, "删除微信公众号成功");
		return "redirect:"+Global.getAdminPath()+"/wx/wxMp/?repage";
	}

}