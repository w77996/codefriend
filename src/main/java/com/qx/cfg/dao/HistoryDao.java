package com.qx.cfg.dao;

import com.qx.cfg.bean.History;

public interface HistoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}