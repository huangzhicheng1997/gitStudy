package com.hzc.serviceuser.repositories;

import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.dto.vo.GoodsComentVo;
import com.hzc.serviceuser.entity.GoodsComent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface GoodsCommentRespository extends JpaRepository<GoodsComent,Integer> {
    @Query(value = "select b.username ,a.content,a.ctime,a.user_id as userId from goods_comment a,user b where a.user_id=b.userId and a.good_id=?1  order by a.ctime limit ?2,?3",nativeQuery = true)
    List<JSONObject> getComent(String goodId,Integer start,Integer end);
}
