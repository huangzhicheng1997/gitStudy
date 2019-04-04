package com.hzc.serviceuser.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class TransactionDetail implements Serializable {
    private Integer id;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 竞拍人id
     */
    private String auctionUserId;

    /**
     * 物主id
     */
    private String userId;

    private String ctime;

    private String utime;

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

    public String getAuctionUserId() {
        return auctionUserId;
    }

    public void setAuctionUserId(String auctionUserId) {
        this.auctionUserId = auctionUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }
}