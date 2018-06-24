package com.qx.cfg.service;

import java.util.List;

import com.qx.cfg.bean.Project;

public interface ProjectService {
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

	List<Project> listAllProject();

	void addView(String id);
}