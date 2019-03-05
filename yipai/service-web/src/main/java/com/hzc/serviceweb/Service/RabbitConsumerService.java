package com.hzc.serviceweb.Service;

import com.hzc.serviceweb.Dao.GoodsRepository;
import com.hzc.serviceweb.Vo.GoodsToSearch;
import com.hzc.serviceweb.Vo.GoodsVo;
import com.hzc.serviceweb.Vo.GoodsVoToPojo;
import com.hzc.serviceweb.entity.Goods;
import com.hzc.serviceweb.mapper.GoodsMapper;
import com.hzc.serviceweb.utils.ReflectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Component
public class RabbitConsumerService {
   @Autowired
   private TransactionTemplate transactionTemplate;
   @Autowired
   private GoodsRepository goodsRepository;
   @Autowired
   private GoodsMapper goodsMapper;
   @RabbitListener(queues="Goods",containerFactory = "rabbitListenerContainerFactory")
   public void receiveExchangeQueue(GoodsVo goodsVo){
      log.info("消费message:"+goodsVo.toString());
      this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
         @Override
         protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
            try{
               goodsRepository.save(goodsVo);
               //更新是否添加进索引库
               Goods goods=new Goods();
               goods.setId(goodsVo.getId());
               goods.setSearchStatus("1");
               goodsMapper.updateByPrimaryKeySelective(goods);
               log.info("*********添加引索库成功*******************");
            }catch (Exception e){
               log.error("******************添加引索库失败*********************");
               transactionStatus.setRollbackOnly();
               e.printStackTrace();
            }
         }
      });
   }

}
