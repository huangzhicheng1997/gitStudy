package com.hzc.serviceuser.Handler;

import com.aliyun.oss.OSSClient;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class UploadImageHandler {
    @Value("${aliyunOss.accesskeyId}")
    private String accesskeyId;
    @Value("${aliyunOss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyunOss.bucketName}")
    private String bucketName;
    @Value("${aliyunOss.endPoint}")
    private String endPoint;
    @Value("${aliyunOss.callbackUrl}")
    private String callbackUrl;
    public String upLoadQNImg(MultipartFile file) throws QiniuException {
       OSSClient ossClient=new OSSClient(endPoint,accesskeyId,accessKeySecret);
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ossClient.putObject(bucketName,file.getOriginalFilename(),inputStream);
        ossClient.shutdown();
        String url=callbackUrl+file.getOriginalFilename();
        return url;
    }


}
