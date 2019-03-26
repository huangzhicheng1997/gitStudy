package com.hzc.serviceuser.repositories;

import com.hzc.serviceuser.entity.JpaGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface goodsRespository extends JpaRepository<JpaGoods,String> {
    @Query("select g from JpaGoods g")
    public List<JpaGoods> getAll();

    public List<JpaGoods> findByUserId(String userId);
    public List<JpaGoods> findByStatus(String userId);

}
