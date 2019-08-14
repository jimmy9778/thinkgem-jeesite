/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apkver.web;

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
import com.thinkgem.jeesite.modules.apkver.entity.AppVersionChip;
import com.thinkgem.jeesite.modules.apkver.service.AppVersionChipService;

/**
 * app版本管理Controller
 * @author jimmy
 * @version 2018-02-06
 */
@Controller
@RequestMapping(value = "${adminPath}/apkver/appVersionChip")
public class AppVersionChipController extends BaseController {

	@Autowired
	private AppVersionChipService appVersionChipService;
	
	@ModelAttribute
	public AppVersionChip get(@RequestParam(required=false) String id) {
		AppVersionChip entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = appVersionChipService.get(id);
		}
		if (entity == null){
			entity = new AppVersionChip();
		}
		return entity;
	}
	
	@RequiresPermissions("apkver:appVersionChip:view")
	@RequestMapping(value = {"list", ""})
	public String list(AppVersionChip appVersionChip, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AppVersionChip> page = appVersionChipService.findPage(new Page<AppVersionChip>(request, response), appVersionChip); 
		model.addAttribute("page", page);
		return "modules/apkver/appVersionChipList";
	}

	@RequiresPermissions("apkver:appVersionChip:view")
	@RequestMapping(value = "form")
	public String form(AppVersionChip appVersionChip, Model model) {
		model.addAttribute("appVersionChip", appVersionChip);
		return "modules/apkver/appVersionChipForm";
	}

	@RequiresPermissions("apkver:appVersionChip:edit")
	@RequestMapping(value = "save")
	public String save(AppVersionChip appVersionChip, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, appVersionChip)){
			return form(appVersionChip, model);
		}
		appVersionChipService.save(appVersionChip);
		addMessage(redirectAttributes, "保存app版本成功");
		return "redirect:"+Global.getAdminPath()+"/apkver/appVersionChip/?repage";
	}
	
	@RequiresPermissions("apkver:appVersionChip:edit")
	@RequestMapping(value = "delete")
	public String delete(AppVersionChip appVersionChip, RedirectAttributes redirectAttributes) {
		appVersionChipService.delete(appVersionChip);
		addMessage(redirectAttributes, "删除app版本成功");
		return "redirect:"+Global.getAdminPath()+"/apkver/appVersionChip/?repage";
	}

}