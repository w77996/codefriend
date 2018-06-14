package com.qx.cfg.dao;

import java.util.List;

import com.qx.cfg.bean.UserInfo;




public interface UserInfoDao{

	List<UserInfo> selectAllUser();
	
}
