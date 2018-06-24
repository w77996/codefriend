package com.qx.cfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.bean.History;
import com.qx.cfg.result.Result;
import com.qx.cfg.service.HistoryService;

@Controller
@RequestMapping("/history")
public class HistoryController extends BaseController{
	
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping("/insert")
	public Result<String> insertHistory(@RequestParam String token,@RequestParam String type,@RequestParam String id){
		String userId = checkTokenAndUser(token);
		
		History hitory = historyService.selectIdByUserId(userId,id);
		
		History history = new History();
		history.setHistoryId(Integer.parseInt(id));
		history.setOpenId(userId);
		history.setType(Integer.parseInt(type));
		
		historyService.insertSelective(history);
		return Result.success("");
	}

}
