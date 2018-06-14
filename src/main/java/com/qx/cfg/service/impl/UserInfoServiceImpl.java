package com.qx.cfg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.cfg.bean.UserInfo;
import com.qx.cfg.dao.UserInfoDao;
import com.qx.cfg.service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	
	@Override
	public List<UserInfo> getUser() {
		// TODO Auto-generated method stub
		return userInfoDao.selectAllUser();
	}

}
