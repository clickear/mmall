package com.mmall.dao;

import com.mmall.pojo.ScheduleJob;

import java.util.List;

/**
 * Created by Administrator on 2017/9/2.
 */
public interface ScheduleJobMapper {
    int deleteByPrimaryKey(Long jobId);

    int insert(ScheduleJob record);

    int insertSelective(ScheduleJob record);

    ScheduleJob selectByPrimaryKey(Long jobId);

    int updateByPrimaryKeySelective(ScheduleJob record);

    int updateByPrimaryKey(ScheduleJob record);

    List<ScheduleJob> getAll();
}