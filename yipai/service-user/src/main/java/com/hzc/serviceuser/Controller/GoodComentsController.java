package com.hzc.serviceuser.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.Handler.GoodComentsHandler;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class GoodComentsController {
    @Autowired
    private GoodComentsHandler goodComentsHandler;

    @RequestMapping("/getComments")
    public BaseRs getComments(String goodId,Integer page,Integer rows){
        List<JSONObject> goodsComment = goodComentsHandler.getGoodsComment(goodId,page,rows);
        BaseRs baseRs = new BaseRs(StatusCodeEnum.SUCCESS, goodsComment);
        baseRs.setCount(goodsComment.size());
        return baseRs;
    }
}
