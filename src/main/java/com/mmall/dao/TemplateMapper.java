package com.mmall.dao;

import com.mmall.pojo.Template;
import com.mmall.pojo.TemplateWithBLOBs;

import java.util.List;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplateWithBLOBs record);

    int insertSelective(TemplateWithBLOBs record);

    TemplateWithBLOBs selectByPrimaryKey(Integer id);

    List<TemplateWithBLOBs> selectByUserId(Integer userid);

    int updateByPrimaryKeySelective(TemplateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TemplateWithBLOBs record);

    int updateByPrimaryKey(Template record);
}