package com.hzc.serviceuser.Handler;

import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.JpaGoods;
import com.hzc.serviceuser.entity.JpaUser;
import com.hzc.serviceuser.mapper.GoodsMapper;
import com.hzc.serviceuser.repositories.goodsRespository;
import com.hzc.serviceuser.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testHandler {
    @Autowired
    private userRepository userRepository;

    @Autowired
    private goodsRespository goodsRespository;

    @Autowired
    GoodsMapper goodsMapper;

    public List testJpa(){
        List<JpaGoods> all =  userRepository.getAll();
        return all;
    }

    public Goods getGoodsById(String id){
        Goods goods = goodsMapper.getGoods(id);
        return goods;
    }

}
