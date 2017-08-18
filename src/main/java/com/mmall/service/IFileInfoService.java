package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.FileInfo;
import com.mmall.pojo.Product;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface IFileInfoService {

    ServerResponse<FileInfo> saveOrUpdateFileInfo(FileInfo fileInfo);
}
