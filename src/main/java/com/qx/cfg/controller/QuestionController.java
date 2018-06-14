package com.qx.cfg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.cfg.result.Result;

@Controller
public class QuestionController {
	
	
	@RequestMapping(value="/publish/question")
	public Result<String> publishQuestion(){
		
		return null;
		
	}
	
	
	@RequestMapping(value="/question/modify")
	public Result<String> modifyQuestion(){
		
		return null;
		
	}
	
	@RequestMapping(value="/del/modify")
	public Result<String> delQuestion(){
		
		return null;
		
	}

}
