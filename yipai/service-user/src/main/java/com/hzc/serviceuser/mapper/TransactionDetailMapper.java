package com.hzc.serviceuser.mapper;

import com.hzc.serviceuser.entity.TransactionDetail;
import com.hzc.serviceuser.entity.TransactionDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
}