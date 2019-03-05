package com.hzc.serviceweb.mapper;

import com.hzc.serviceweb.Vo.GoodsToUser;
import com.hzc.serviceweb.entity.Goods;
import com.hzc.serviceweb.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyGoodsMapper {
    public List<GoodsToUser> getGoodsAndUserByStatus(String status);
}
