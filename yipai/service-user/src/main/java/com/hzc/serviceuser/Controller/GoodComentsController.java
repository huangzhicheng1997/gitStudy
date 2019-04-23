package com.hzc.serviceuser.Controller;

import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.dto.response.BaseRs;
import com.hzc.serviceuser.dto.response.pageRs;
import com.hzc.serviceuser.dto.vo.UserCommentVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.GoodsComent;
import com.hzc.serviceuser.param.UserInfo;
import com.hzc.serviceuser.service.CommentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class GoodComentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/getComments")
    public pageRs getComments(String goodId,Integer page,Integer rows){
        List<UserCommentVo> comments = commentService.getComments(goodId, page, rows);
       if(comments==null || comments.size()==0) {
           return new pageRs(0, "成功", Collections.emptyList(), 0);
       }else {
           return new pageRs(0,"成功",comments,comments.size());
       }
    }

    @RequestMapping("/addComments")
    public BaseRs addComments(GoodsComent goodsComent){
        if(StringUtils.isBlank(goodsComent.getContent())){
            return new BaseRs(StatusCodeEnum.NULLCONTENT);
        }
        if (StringUtils.isBlank(goodsComent.getGoodId())){
            return new BaseRs(StatusCodeEnum.NULLID);
        }
        goodsComent.setCtime(Integer.valueOf(System.currentTimeMillis()/1000+""));
        goodsComent.setUserId(UserInfo.getUgiser().getUserid());
        int i = commentService.addComments(goodsComent);
        if(i==0){
            return new BaseRs(StatusCodeEnum.FAILD);
        }else {
            return new BaseRs(StatusCodeEnum.SUCCESS);
        }
    }
}
