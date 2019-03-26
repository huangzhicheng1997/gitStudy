package com.hzc.serviceuser.repositories;

import com.hzc.serviceuser.dto.UserAndGoodsDto;
import com.hzc.serviceuser.entity.JpaGoods;
import com.hzc.serviceuser.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userRepository extends JpaRepository<JpaUser,String> {
    @Query("select u from JpaUser u where u.userId=?1")
    public JpaUser getById(String userId);
    @Query("select  g.id,u.userId,u.adminTel,g.status from JpaUser u inner join JpaGoods g on u.userId=g.userId where u.userId='5e29a9b0-64bd-4de6-8762-372e3801f7d0'")
    public List<Object> get();
    @Query(value = "select goods.* from user,goods where user.userId=goods.user_id",nativeQuery = true)
    public List getAll();
}
