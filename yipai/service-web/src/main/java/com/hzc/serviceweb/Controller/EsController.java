package com.hzc.serviceweb.Controller;


import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.hzc.serviceweb.Dao.GoodsRepository;
import com.hzc.serviceweb.Service.ESService;
import com.hzc.serviceweb.Vo.GoodsVo;
import com.hzc.serviceweb.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/query")
@Slf4j
public class EsController {
    @Autowired
    private ESService esService;

    @RequestMapping("/getGoods")
    public List<GoodsVo> getGoods(String keyword){
        List<GoodsVo> goods = esService.getGoods(keyword);
        return goods;
    }

    @RequestMapping("/getAllGoods")
    public Iterable<GoodsVo> getAllGoods(){
        Iterable<GoodsVo> allGoods = esService.getAllGoods();

        return allGoods;
    }

    @RequestMapping("/deleteGoods")
    public Boolean deleteGoodsFromEs(String id){
        Boolean flag = esService.deleteGoods(id);
       return flag;
    }
}
