package com.hzc.serviceuser.Controller;


import com.alibaba.fastjson.JSONArray;
import com.auth0.jwt.internal.org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import com.hzc.serviceuser.Handler.UploadImageHandler;
import com.hzc.serviceuser.Handler.testHandler;
import com.hzc.serviceuser.dto.UserAndGoodsDto;
import com.qiniu.common.QiniuException;
import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/home")
public class TestController {
    @Autowired
    private UploadImageHandler uploadImageHandler;
    @Autowired
    private testHandler testHandler;

    @RequestMapping("/test")
    public String test(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String s = uploadImageHandler.upLoadQNImg(multipartFile);
        return s;
    }

    @RequestMapping("/tt")
    public UserAndGoodsDto tt(){

        List list = testHandler.testJpa();
        JSONArray array=new JSONArray(list);
        UserAndGoodsDto userAndGoodsDto=new UserAndGoodsDto();
        userAndGoodsDto.setContent(array);
        return userAndGoodsDto;
    }



}
