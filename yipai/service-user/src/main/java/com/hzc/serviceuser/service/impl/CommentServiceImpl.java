package com.hzc.serviceuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzc.serviceuser.dto.vo.GoodsComentVo;
import com.hzc.serviceuser.dto.vo.UserCommentVo;
import com.hzc.serviceuser.entity.GoodsComent;
import com.hzc.serviceuser.mapper.CommentMapper;
import com.hzc.serviceuser.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper,GoodsComent> implements CommentService {
    @Override
    public int addComments(GoodsComent goodsComent) {
        return baseMapper.insert(goodsComent);
    }

    @Override
    public List<UserCommentVo> getComments(String goodsId,Integer page,Integer rows) {
        Integer start=(page-1)*rows;
        Integer end=page*rows;
        List<UserCommentVo> comments = baseMapper.getComments(goodsId,start,end);
        return comments;
    }
}
