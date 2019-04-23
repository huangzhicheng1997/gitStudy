package com.hzc.serviceuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzc.serviceuser.dto.vo.UserCommentVo;
import com.hzc.serviceuser.entity.GoodsComent;

import java.util.List;

public interface CommentService extends IService<GoodsComent> {
    int addComments(GoodsComent goodsComent);
    List<UserCommentVo> getComments(String goodsId,Integer page,Integer rows);
}
