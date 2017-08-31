package com.mmall.service;

import com.mmall.pojo.SignLog;
import com.mmall.pojo.TemplateWithBLOBs;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */
public interface ISignService {
    List<TemplateWithBLOBs> selectByUserId(Integer userId);
    int insertSignLog(SignLog signLog);
}
