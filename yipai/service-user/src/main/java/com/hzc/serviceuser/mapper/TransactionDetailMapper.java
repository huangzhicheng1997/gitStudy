package com.hzc.serviceuser.mapper;

import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.dto.vo.TransactionDetailVo;
import com.hzc.serviceuser.entity.TransactionDetail;
import com.hzc.serviceuser.entity.TransactionDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TransactionDetailMapper {
    long countByExample(TransactionDetailExample example);

    int deleteByExample(TransactionDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    List<TransactionDetail> selectByExample(TransactionDetailExample example);

    TransactionDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransactionDetail record, @Param("example") TransactionDetailExample example);

    int updateByExample(@Param("record") TransactionDetail record, @Param("example") TransactionDetailExample example);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.price,\n" +
            "\ta.goods_id AS goodsId,\n" +
            "\tb.good_name AS goodsName,\n" +
            "\ta.ctime,\n" +
            "\tc.username AS ownerName,\n" +
            "\tb.`status`,\n" +
            "\td.username AS myName,\n" +
            "\te.deal_user_id as myId\n" +
            "FROM\n" +
            "\ttransaction_detail a\n" +
            "LEFT JOIN\n" +
            "  goods b ON a.goods_id=b.id LEFT JOIN `user` c ON a.user_id=c.userId LEFT JOIN `user` d ON a.auction_user_id=d.userId LEFT JOIN deal_flow_detail e ON a.goods_id=e.goods_id WHERE d.userId=#{userid}")
    List<TransactionDetailVo> getTransactions(@Param(value = "userid") String userid);

    @Select("SELECT b.id,b.goods_id as goodsId,b.auction_user_id as auctionUserId ,b.user_id as userId,b.ctime,b.utime,b.price FROM goods a,transaction_detail b WHERE a.auction_price=b.price AND b.goods_id=#{goodId}")
    TransactionDetail getMaxDetail(@Param(value = "goodId") String goodId);
    @Select("SELECT b.id,b.goods_id as goodsId,b.auction_user_id as auctionUserId ,b.user_id as userId,b.ctime as ctime,b.utime as ctime,b.price as price FROM goods a,transaction_detail b WHERE a.auction_price=b.price")
    List<JSONObject> getDetail();
}