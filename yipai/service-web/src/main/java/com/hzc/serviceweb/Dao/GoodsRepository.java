package com.hzc.serviceweb.Dao;

import com.hzc.serviceweb.Vo.GoodsToSearch;
import com.hzc.serviceweb.Vo.GoodsVo;
import com.hzc.serviceweb.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsVo, String> {

}
