package com.mmall.dao;

import com.mmall.pojo.SignTask;

public interface SignTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SignTask record);

    int insertSelective(SignTask record);

    SignTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SignTask record);

    int updateByPrimaryKey(SignTask record);
}