package com.hzc.serviceweb.Service.impl;

import com.google.common.collect.Lists;
import com.hzc.serviceweb.Dao.GoodsRepository;
import com.hzc.serviceweb.Service.ESService;
import com.hzc.serviceweb.Vo.GoodsVo;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ESServiceImpl implements ESService {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<GoodsVo> getGoods(String condition) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should( QueryBuilders.multiMatchQuery(condition,"goodDescribe"));
        boolQueryBuilder.should(QueryBuilders.prefixQuery("goodDescribe",condition));
        boolQueryBuilder.should(QueryBuilders.wildcardQuery("goodDescribe","*"+condition+"*"));
        Iterable<GoodsVo> search = goodsRepository.search(boolQueryBuilder);
        ArrayList<GoodsVo> goodsVos = Lists.newArrayList(search);
        goodsVos.forEach(goodsVo -> {
           goodsVo.setGoodDescribe(goodsVo.getGoodDescribe().replaceAll(condition,"<span style='color:red'>"+condition+"</span>"));
            goodsVo.setGoodName(goodsVo.getGoodName().replaceAll(condition,"<span style='color:red'>"+condition+"</span>"));
        });
        return goodsVos;
    }

    @Override
    public  Iterable<GoodsVo> getAllGoods(){
        Iterable<GoodsVo> all = goodsRepository.findAll();

        return all;
    }

    @Override
    public Boolean deleteGoods(String id) {
        try {
            DeleteQuery query = new DeleteQuery();
            query.setIndex("goods");
            query.setType("good");
            MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("id", id);
            query.setQuery(matchQueryBuilder);
            elasticsearchTemplate.delete(query);
            return true;
        } catch (Exception e) {
             return false;
        }
    }
}
