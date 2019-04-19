package com.hzc.serviceuser.mapper;

import com.hzc.serviceuser.entity.DealFlowDetail;
import com.hzc.serviceuser.entity.DealFlowDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DealFlowDetailMapper {
    long countByExample(DealFlowDetailExample example);

    int deleteByExample(DealFlowDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DealFlowDetail record);

    int insertSelective(DealFlowDetail record);

    List<DealFlowDetail> selectByExample(DealFlowDetailExample example);

    DealFlowDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DealFlowDetail record, @Param("example") DealFlowDetailExample example);

    int updateByExample(@Param("record") DealFlowDetail record, @Param("example") DealFlowDetailExample example);

    int updateByPrimaryKeySelective(DealFlowDetail record);

    int updateByPrimaryKey(DealFlowDetail record);


}