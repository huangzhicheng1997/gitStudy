package com.hzc.serviceuser.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.internal.org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import com.hzc.serviceuser.Handler.GoodsHandler;
import com.hzc.serviceuser.Handler.TransactionDetailHandler;
import com.hzc.serviceuser.Handler.UploadImageHandler;
import com.hzc.serviceuser.Handler.testHandler;
import com.hzc.serviceuser.dto.UserAndGoodsDto;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.dto.vo.GoodsComentVo;
import com.hzc.serviceuser.dto.vo.TransactionDetailVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.TransactionDetail;

import com.hzc.serviceuser.mapper.GoodsMapper;
import com.hzc.serviceuser.mapper.TransactionDetailMapper;
import com.hzc.serviceuser.repositories.GoodsCommentRespository;
import com.hzc.serviceuser.service.FeignClient;
import com.hzc.serviceuser.utils.JpaUtils;
import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class TestController {
    @Autowired
    private UploadImageHandler uploadImageHandler;
    @Autowired
    private testHandler testHandler;
    @Autowired
    TransactionDetailHandler transactionDetailHandler;
    @Autowired
    private FeignClient feignClient;
    @Autowired
    private GoodsCommentRespository goodsCommentRespository;
   @Autowired
   private TransactionDetailMapper mapper;


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

    @RequestMapping("/getEsALL")
    public Map tt(){
        Map allGoods = feignClient.getAllGoods();
        return allGoods;
    }

    @RequestMapping("/ts")
    public  BaseRs<TransactionDetailVo> test(String id) throws IllegalAccessException {
        return null;
    }

    @RequestMapping("/deleteEs")
    public Boolean deleteEsTest(String id){
       return feignClient.deleteFromES(id);
    }

}
