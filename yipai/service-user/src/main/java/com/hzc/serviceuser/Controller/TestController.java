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


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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
    public void test(HttpServletResponse response) throws IOException {
        String cnName="asdsa";
        cnName= new String(cnName.getBytes("gb2312"), "ISO8859-1");
        response.setCharacterEncoding("utf-8");
        //设置响应的内容类型
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition","attachment;filename="
                + cnName//设置名称格式，没有这个中文名称无法显示
                + ".txt");
        String a="xxxxxx";
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedOutputStream buff=new BufferedOutputStream(outputStream);
        buff.write(a.getBytes());
        buff.flush();
        buff.close();
    }

    @RequestMapping("/tt")
    public UserAndGoodsDto tt(){

        List list = testHandler.testJpa();
        JSONArray array=new JSONArray(list);
        UserAndGoodsDto userAndGoodsDto=new UserAndGoodsDto();
        userAndGoodsDto.setContent(array);
        return userAndGoodsDto;
    }

    @RequestMapping("/ts")
    public String test(String name){
        return new String(name);
    }

}
