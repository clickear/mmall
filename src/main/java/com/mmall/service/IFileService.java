package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by geely
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

}
