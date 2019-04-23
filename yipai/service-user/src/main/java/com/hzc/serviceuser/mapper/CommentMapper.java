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
    @Select("select b.username,a.content,a.ctime,a.good_id,a.user_id from goods_comment a,user b where a.user_id=b.userId limit #{start},#{end}")
    List<UserCommentVo> getComments(@Param("good_id") String goodId,@Param("start") Integer start,@Param("end") Integer end);
}
