package com.qx.cfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.bean.Follow;
import com.qx.cfg.result.Result;
import com.qx.cfg.service.FollowService;

@Controller
@RequestMapping("/follow")
public class FollowController extends BaseController{

	@Autowired
	private FollowService followService;
	
	@RequestMapping("/{id}")
	public Result<String> insertFollow(@PathVariable String id,@RequestParam String openId){
		Follow follow = new Follow();
		//follow.setFollowOpenId(openId);
		
				return null;
	}
	
	@RequestMapping("/cancel/{id}")
	public Result<String> cancelFollow(@PathVariable String id){
		
		return null;
	}
	
	@RequestMapping("/list/{openId}")
	public Result<String> listFollow(@PathVariable String openId){
		
		return null;
	}
}
