package com.qx.cfg.service;

import com.qx.cfg.bean.History;

public interface HistoryService {
    int deleteByPrimaryKey(Long id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

	History selectIdByUserId(String userId, String id);
}