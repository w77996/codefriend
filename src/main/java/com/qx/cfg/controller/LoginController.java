package com.qx.cfg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.cfg.result.Result;

@Controller
public class LoginController {
	
	@RequestMapping(value="/getOpenId")
	public String getUserOpenId(){
		System.out.println("7777777777");
		return null;
	}
	
	
	

}
