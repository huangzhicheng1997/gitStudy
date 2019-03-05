package com.hzc.serviceuser.Controller;


import com.auth0.jwt.internal.org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import com.hzc.serviceuser.Handler.UploadImageHandler;
import com.qiniu.common.QiniuException;
import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;

@RestController
@RequestMapping("/home")
public class TestController {
    @Autowired
    private UploadImageHandler uploadImageHandler;
    @RequestMapping("/test")
    public String test(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        String s = uploadImageHandler.upLoadQNImg(inputStream, null);
        return s;
    }

}
