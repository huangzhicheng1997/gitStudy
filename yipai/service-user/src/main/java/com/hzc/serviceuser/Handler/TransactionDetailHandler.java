package com.hzc.serviceuser.Handler;

import com.hzc.serviceuser.entity.Goods;
import com.hzc.serviceuser.entity.TransactionDetail;
import com.hzc.serviceuser.entity.TransactionDetailExample;
import com.hzc.serviceuser.mapper.TransactionDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDetailHandler {
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

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

    public Boolean doAuction(TransactionDetail transactionDetail){
        TransactionDetailExample transactionDetailExample=new TransactionDetailExample();
        TransactionDetailExample.Criteria criteria = transactionDetailExample.createCriteria();
        int i = transactionDetailMapper.insertSelective(transactionDetail);
        if(i>0){
            return true;
        }
        return false;
    }
}
