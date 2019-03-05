package com.hzc.serviceuser.Handler;

import com.hzc.api.enums.ResultCode;
import com.hzc.serviceuser.dto.vo.GoodsVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.GoodsExample;
import com.hzc.serviceuser.mapper.GoodsMapper;
import com.hzc.serviceuser.service.RabbitMqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GoodsHandler {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RabbitMqProducerService rabbitMqProducerService;

    /**
     * 获取全部商品列表
     * @return
     */
    public GoodsVo<List> getGoods(){
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");
        criteria.andSearchStatusEqualTo("1");
        List<Goods> goods = goodsMapper.selectByExample(example);
        if(goods==null&&goods.size()==0){
            return new GoodsVo<>(ResultCode.FAIL,goods);
        }
        GoodsVo<List> goodsVo=new GoodsVo<>(ResultCode.SUCCESS,goods);
      return goodsVo;
    }

    /**
     * 插入商品 mq通知增加elsearch引索库
     * @return
     */
    @Transactional
    public Boolean addGoods(Goods goods){
        int insert = goodsMapper.insert(goods);
        rabbitMqProducerService.sendGoods(goods);
        if(insert>0){
            return true;
        }else{
            return false;
        }
    }



    public Goods getGoodsById(String id){
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods;
    }


}
