package com.qx.cfg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.cfg.result.Result;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/insert")
	public Result<String> insertUser(){
		return null;
	}

}
