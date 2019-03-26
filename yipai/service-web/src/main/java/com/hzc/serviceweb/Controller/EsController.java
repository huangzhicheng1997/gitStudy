package com.hzc.serviceweb.Controller;


import com.hzc.serviceweb.Dao.GoodsRepository;
import com.hzc.serviceweb.Vo.GoodsVo;
import com.hzc.serviceweb.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/query")
@Slf4j
public class EsController {
    @Autowired
    private GoodsRepository goodsRepository;

    @RequestMapping("/getAll")
    public List<GoodsVo> getAll() {
        Iterable<GoodsVo> all = goodsRepository.findAll();
        List<GoodsVo> ls=new ArrayList<>();
        all.forEach(goodsVo -> {
            ls.add(goodsVo);
        });
        return ls;
    }
}
