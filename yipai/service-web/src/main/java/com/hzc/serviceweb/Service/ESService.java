package com.hzc.serviceweb.Service;

import com.hzc.serviceweb.Vo.GoodsVo;

import java.util.List;

public interface ESService {
    public List<GoodsVo> getGoods(String condition);
}
