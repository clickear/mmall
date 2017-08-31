package com.mmall.dao;

import com.mmall.pojo.SignLog;

public interface SignLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SignLog record);

    int insertSelective(SignLog record);

    SignLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SignLog record);

    int updateByPrimaryKey(SignLog record);
}