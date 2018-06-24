package com.qx.cfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qx.cfg.bean.Project;
import com.qx.cfg.bean.UserInfo;
import com.qx.cfg.result.Result;
import com.qx.cfg.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/insert")
	public Result<String> insertProject(@RequestParam String token,@RequestParam String title,@RequestParam String content,@RequestParam String type,@RequestParam String circleTime,@RequestParam String money){
		//getApplication().setAttribute(userInfo.getUserId().toString(), userInfo);
		String userId = checkTokenAndUser(token);
		Project project = new Project();
		project.setCircleTime(circleTime);
		project.setContent(content);
		project.setMoney(money);
		project.setTitle(title);
		project.setType(Integer.parseInt(type));
		project.setOpenId(userId);
		projectService.insertSelective(project);
		return Result.success("");
		
	}
	
	@RequestMapping("/update/{projectId}")
	public Result<String> updateProject(@RequestBody Project project){
		projectService.updateByPrimaryKey(project);
		return Result.success("");
		
	}
	
	
	@RequestMapping("/list")
	public Result<PageInfo<Project>> listProject(@RequestParam String page,@RequestParam String size){
		//String userId = checkTokenAndUser(token);
		
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
		//List<UserInfo> list = userInfoService.getUser();
		
		List<Project> listProject = projectService.listAllProject();
		PageInfo<Project> pageInfo = new PageInfo<>(listProject);
		return Result.success(pageInfo);
	}
	
	@RequestMapping("/list/{openId}")
	public Result<PageInfo<Project>> listMyProject(@RequestParam String token,@RequestParam String page,@RequestParam String size){
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
		//List<UserInfo> list = userInfoService.getUser();
		
		List<Project> listProject = projectService.listAllProject();
		PageInfo<Project> pageInfo = new PageInfo<>(listProject);
		return Result.success(pageInfo);
	}

}
