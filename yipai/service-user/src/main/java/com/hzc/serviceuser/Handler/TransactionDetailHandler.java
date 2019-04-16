package com.hzc.serviceuser.Handler;

import com.hzc.serviceuser.dto.vo.TransactionDetailVo;
import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.TransactionDetail;
import com.hzc.serviceuser.entity.TransactionDetailExample;
import com.hzc.serviceuser.mapper.GoodsMapper;
import com.hzc.serviceuser.mapper.TransactionDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class TransactionDetailHandler {
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public  List<TransactionDetail> getTransactionDetail(String goodId,String userId){
        TransactionDetailExample transactionDetailExample=new TransactionDetailExample();
        TransactionDetailExample.Criteria criteria = transactionDetailExample.createCriteria();
        if(userId!=null) {
            criteria.andAuctionUserIdEqualTo(userId);
        }
        if(goodId!=null){
            criteria.andGoodsIdEqualTo(goodId);
        }
        List<TransactionDetail> transactionDetail= transactionDetailMapper.selectByExample(transactionDetailExample);
        return transactionDetail;

    }


    @Transactional
    public Boolean doAuction(TransactionDetail transactionDetail){
        Goods goods=new Goods();
        goods.setId(transactionDetail.getGoodsId());
        goods.setAuctionPrice(transactionDetail.getPrice());
        int count = goodsMapper.updateByPrimaryKeySelective(goods);
        TransactionDetailExample transactionDetailExample=new TransactionDetailExample();
        TransactionDetailExample.Criteria criteria = transactionDetailExample.createCriteria();
        int i = transactionDetailMapper.insertSelective(transactionDetail);
        if(i>0&&count>0){
            return true;
        }
        return false;
    }

    /**
     * 获取当前用户的id
     * @param userId
     * @return
     */
    public  List<TransactionDetailVo> getTransaction(String userId){
        List<TransactionDetailVo> transactions = transactionDetailMapper.getTransactions(userId);
        transactions.forEach(transactionDetailVo -> {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            transactionDetailVo.setCtime(format.format(new Date(Long.valueOf(transactionDetailVo.getCtime())*1000L)));
        });
        return transactions;
    }


    /**
     * 删除竞拍
     * @param id
     * @return
     */
    public Boolean deleteTransaction(String id){
        TransactionDetailExample example=new TransactionDetailExample();
        TransactionDetailExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(id));
        int i = transactionDetailMapper.deleteByExample(example);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
