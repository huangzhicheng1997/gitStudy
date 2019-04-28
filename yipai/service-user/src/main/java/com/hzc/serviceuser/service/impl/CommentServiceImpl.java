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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper,GoodsComent> implements CommentService {
    @Override
    public int addComments(GoodsComent goodsComent) {
        return baseMapper.insert(goodsComent);
    }

    @Override
    public List<UserCommentVo> getComments(String goodsId,Integer page,Integer rows) {
        List<UserCommentVo> comments = baseMapper.getComments(goodsId);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comments.forEach(userCommentVo -> {
            userCommentVo.setCtime(dateFormat.format(new Date(Long.valueOf(userCommentVo.getCtime())*1000)));
        });
        return comments;
    }
}
