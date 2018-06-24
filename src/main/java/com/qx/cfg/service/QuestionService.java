package com.qx.cfg.service;

import com.qx.cfg.bean.Question;

public interface QuestionService {
    int deleteByPrimaryKey(Long id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

	void addView(String id);
}