package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.FileInfoMapper;
import com.mmall.pojo.FileInfo;
import com.mmall.service.IFileInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/6.
 */

@Service("iFileInfoService")
public class FileInfoServiceImpl implements IFileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Override
    public ServerResponse<FileInfo> saveOrUpdateFileInfo(FileInfo fileInfo) {

        if(fileInfo != null)        {
            if(fileInfo.getId() != null){
                int rowCount = fileInfoMapper.updateByPrimaryKey(fileInfo);
                if(rowCount > 0){
                    fileInfo = fileInfoMapper.selectByPrimaryKey(fileInfo.getId());
                    return ServerResponse.createBySuccess("更新成功",fileInfo);
                }
                return ServerResponse.createBySuccess("更新产品失败",fileInfo);
            }else{
                long rowCount = fileInfoMapper.insert(fileInfo);
                if(rowCount > 0){
                    fileInfo.setId(rowCount);
                    fileInfo = fileInfoMapper.selectByPrimaryKey(fileInfo.getId());
                    return ServerResponse.createBySuccess("添加成功",fileInfo);
                }
                return ServerResponse.createBySuccess("添加失败", fileInfo);
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
    }
}
