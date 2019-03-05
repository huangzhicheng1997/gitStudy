package com.hzc.serviceuser.Handler;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class UploadImageHandler {
    @Value("${qiniu.accesskey}")
    private String accesskey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.path}")
    private String path;
    public String upLoadQNImg(InputStream file, String key) throws QiniuException {
        Configuration cfg=new Configuration(Zone.zone0());
        UploadManager uploadManager=new UploadManager(cfg);
        //生成凭证
        Auth auth=Auth.create(accesskey,secretKey);
        String upToken=auth.uploadToken(bucket);
        Response response = uploadManager.put(file, key, upToken, null, null);
        DefaultPutRet putRet=new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        String returnPath = path + "/" + putRet.key;
        return returnPath;
    }
}
