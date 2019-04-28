package com.hzc.serviceuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzc.serviceuser.dto.vo.UserCommentVo;
import com.hzc.serviceuser.entity.GoodsComent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<GoodsComent> {
    @Select("select b.username,a.content,a.ctime,a.good_id,a.user_id from goods_comment a,user b where a.user_id=b.userId And good_id=#{goodId}")
    List<UserCommentVo> getComments(@Param("goodId") String goodId);
}
