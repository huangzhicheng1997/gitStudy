package com.hzc.serviceuser.Handler;

import com.hzc.api.enums.ResultCode;
import com.hzc.serviceuser.dto.vo.GoodsVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.GoodsExample;
import com.hzc.serviceuser.mapper.GoodsMapper;
import com.hzc.serviceuser.service.FeignClient;
import com.hzc.serviceuser.service.RabbitMqProducerService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Component
public class GoodsHandler {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RabbitMqProducerService rabbitMqProducerService;
    @Autowired
    private FeignClient feignClient;
    @Autowired
    private TransactionTemplate transactionTemplate;
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
        if(insert>0){
            rabbitMqProducerService.sendGoods(goods);
            return true;
        }else{
            return false;
        }
    }



    public Goods getGoodsById(String id){
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods;
    }

   public List<Goods> getGoodsByUserId(String userId){
        GoodsExample example=new GoodsExample();
       GoodsExample.Criteria criteria = example.createCriteria();
       criteria.andUserIdEqualTo(userId);
       List<Goods> goods = goodsMapper.selectByExample(example);
       return goods;
   }

    public Boolean Deal(Goods goods){
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(goods.getId());
        int i = goodsMapper.updateByExampleSelective(goods, example);
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * 删除es和数据库中的商品
     * @param id
     * @return
     */
    public Boolean deleteGoods(String id) {
       Boolean flag=transactionTemplate.execute(transactionStatus -> {
           int i = goodsMapper.deleteByPrimaryKey(id);
           //判断数据库是否插入成功
           if(i>0){
               try {
                   Boolean flag1 = feignClient.deleteFromES(id);
               }catch (Exception e){
                   //数据库成功 es异常则数据库进行回滚
                    transactionStatus.setRollbackOnly();
                    return false;
               }
           }else {
               return false;
           }
           return true;
       });
       return flag;
    }
}
