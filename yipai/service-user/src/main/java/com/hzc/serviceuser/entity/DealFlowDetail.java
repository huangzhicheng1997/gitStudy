package com.hzc.serviceuser.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class DealFlowDetail implements Serializable {
    private Integer id;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 物主id
     */
    private String userId;

    /**
     * 成交人id
     */
    private String dealUserId;

    /**
     * 创建时间
     */
    private Integer ctime;

    /**
     * 更新时间
     */
    private Integer utime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public Integer getUtime() {
        return utime;
    }

    public void setUtime(Integer utime) {
        this.utime = utime;
    }
}