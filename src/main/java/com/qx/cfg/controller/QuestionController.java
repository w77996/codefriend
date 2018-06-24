package com.qx.cfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.bean.Project;
import com.qx.cfg.bean.Question;
import com.qx.cfg.exception.GlobalException;
import com.qx.cfg.result.CodeMsg;
import com.qx.cfg.result.Result;
import com.qx.cfg.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {
	
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value="/publish")
	public Result<String> publishQuestion(@RequestParam String token,@RequestParam String title,@RequestParam String content){
		String userId = checkTokenAndUser(token);
		Question question = new Question();
		question.setTitle(title);
		question.setContent(content);
		question.setOpenId(userId);
		questionService.insert(question);
		return Result.success("");
		
	}
	
	
	@RequestMapping(value="/modify/{questionId}")
	public Result<String> modifyQuestion(@RequestParam String questionId,@RequestParam String token,@RequestParam String title,@RequestParam String content){
		String userId = checkTokenAndUser(token);
		Question question = questionService.selectByPrimaryKey(Long.parseLong(questionId));
		if(question == null ){
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		question.setId(Long.parseLong(questionId));
		question.setTitle(title);
		question.setContent(content);
		questionService.updateByPrimaryKey(question);
		return null;
		
	}
	
	@RequestMapping(value="/del")
	public Result<String> delQuestion(){
		
		return null;
		
	}
	
	@RequestMapping(value="/view/{id}")
	public void viewQuestion(@PathVariable String id){
		questionService.addView(id);
	}

}
