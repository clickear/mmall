package com.mmall.controller.portal;

import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.FileInfo;
import com.mmall.service.IFileInfoService;
import com.mmall.service.IFileService;
import com.mmall.util.PropertiesUtil;
import com.mmall.util.QiNiuFileUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/5.
 */

@Controller
@RequestMapping(value = "/upload/qiniu")
public class UploadController {

    @Autowired
    private IFileService iQiNiuFileService;

    @Autowired
    private IFileInfoService iFileInfoService;

    @RequestMapping(value = "token.do", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody Map getToken(){
        Map map = new HashMap();
        map.put("uptoken",QiNiuFileUitl.getUpToken());

        return map;
    }

    @RequestMapping(value = "callback.do", method = {RequestMethod.POST} )
    @ResponseBody
    public ServerResponse<FileInfo> getFileInfo(@RequestBody FileInfo fileInfo){
        fileInfo.setSavetype(1);
        fileInfo.setUrl(PropertiesUtil.getProperty("qiniu.domain","") + fileInfo.getKey());
        return iFileInfoService.saveOrUpdateFileInfo(fileInfo);
    }
//
//    @RequestMapping(value = "callback.do", method = {RequestMethod.GET,RequestMethod.POST})
//    public @ResponseBody  FileInfo getFileInfo1(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ServletInputStream inputStream = request.getInputStream();
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        String reult =inputStream2String(inputStream);
//
//        FileInfo fileInfo = new FileInfo();
//        fileInfo.setSavetype(1);
//        fileInfo.setUrl(PropertiesUtil.getProperty("qiniu.domain","") + fileInfo.getKey());
//        return fileInfo;
//    }
//
//    public   String   inputStream2String   (InputStream in)   throws   IOException   {
//        StringBuffer   out   =   new   StringBuffer();
//        byte[]   b   =   new   byte[4096];
//        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {
//            out.append(new   String(b,   0,   n));
//        }
//        return   out.toString();
//    }

}
