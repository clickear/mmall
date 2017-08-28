package com.mmall.service.impl;

import com.mmall.dao.ProductMapper;
import com.mmall.dao.TemplateMapper;
import com.mmall.pojo.TemplateWithBLOBs;
import com.mmall.service.ISignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

@Service("iSignService")
public class SignServiceImpl implements ISignService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public List<TemplateWithBLOBs> selectByUserId(Integer userId) {

        return templateMapper.selectByUserId(userId);

    }
}
