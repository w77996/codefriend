package com.qx.cfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qx.cfg.bean.UserInfo;
import com.qx.cfg.result.Result;
import com.qx.cfg.service.UserInfoService;



@Controller
public class UsreInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/user")
	@ResponseBody
	public Result<PageInfo<UserInfo>> getUser() {
		PageHelper.startPage(1, 10);
		List<UserInfo> list = userInfoService.getUser();
		PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
		
		return Result.success(pageInfo);
	}
	
	
}
