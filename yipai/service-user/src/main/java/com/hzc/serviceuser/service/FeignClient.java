package com.hzc.serviceuser.service;

import com.hzc.serviceuser.entity.Goods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@org.springframework.cloud.openfeign.FeignClient(value ="service-web")
public interface FeignClient {
    @RequestMapping("/query/getAllGoods")
    public Map getAllGoods();

    @RequestMapping("/query/deleteGoods")
    public Boolean deleteFromES(@RequestParam(value = "id")String id);
}
