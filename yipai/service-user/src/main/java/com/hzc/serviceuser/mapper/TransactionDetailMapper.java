package com.hzc.serviceuser.mapper;

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
    @Select("SELECT a.id,a.price,a.goods_id as goodsId,b.good_name as goodsName,a.ctime,c.username as ownerName,b.`status`,d.username as myName,d.userId as myId " +
            "FROM transaction_detail a,goods b,`user` c,`user` d " +
            "WHERE a.goods_id=b.id AND a.user_id=c.userId AND a.auction_user_id=d.userId And d.userId=#{userid}")
    List<TransactionDetailVo> getTransactions(@Param(value = "userid") String userid);
    @Select("SELECT b.id,b.goods_id as goodsId,b.auction_user_id as auctionUserId ,b.user_id as userId,b.ctime,b.utime,b.price FROM goods a,transaction_detail b WHERE a.auction_price=b.price AND b.goods_id=#{goodId}")
    TransactionDetail getMaxDetail(@Param(value = "goodId") String goodId);
}