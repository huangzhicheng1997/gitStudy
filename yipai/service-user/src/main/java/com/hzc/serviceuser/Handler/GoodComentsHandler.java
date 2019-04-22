package com.hzc.serviceuser.Handler;

import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.repositories.GoodsCommentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GoodComentsHandler {
     @Autowired
     private GoodsCommentRespository goodsCommentRespository;

     public List<JSONObject> getGoodsComment(String goodId,Integer page,Integer rows){
         Integer start=(page-1)*rows;
         Integer end=start+rows;
         List<JSONObject> coment = goodsCommentRespository.getComent(goodId,start,end);
         if(coment==null || coment.size()==0){
             return Collections.emptyList();
         }
         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         coment.forEach(jsonObject -> {
             String format = simpleDateFormat.format(new Date(((Integer) jsonObject.get("ctime")) * 1000L));
             jsonObject.put("ctime",format);
         });
         return coment;
     }
}
