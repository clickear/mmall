package com.mmall.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/5.
 */
public class QiNiuFileUitl {

    private static String  ACCESS_KEY =  PropertiesUtil.getProperty("qiniu.accessKey");
    private static String SECRET_KEY = PropertiesUtil.getProperty("qiniu.secretKey");
    private static String bucketname = PropertiesUtil.getProperty("qiniu.bucket");
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public static String getUpToken() {

        StringMap putPolicy = new StringMap();
       // putPolicy.put("callbackUrl", PropertiesUtil.getProperty("qiniu.callbackurl","callbackUrl"));
       // putPolicy.put("callbackBody", "key=$(key)&hash=$(etag)&bucket=$(bucket)&fsize=$(fsize)&fname=$(fname)&mimeType=$(mimeType)&ext=$(ext)");
        putPolicy.put("callbackBodyType", "application/json");
//      putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":\"$(fsize)\",\"fname:\":\"$(fname)\",\"mimeType\":\"$(mimeType)\",\"ext\":\"$(ext)\"}");


        long expireSeconds = 3600;

        String upToken = auth.uploadToken(bucketname, null, expireSeconds, putPolicy);

        return upToken;
    }
}
