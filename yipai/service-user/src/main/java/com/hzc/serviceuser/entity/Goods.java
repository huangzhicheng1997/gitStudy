package com.hzc.serviceuser.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Goods implements Serializable {
    private String id;

    /**
     * 商品拍卖价格
     */
    private String goodPrice;

    /**
     * 商品描述
     */
    private String goodDescribe;

    /**
     * 图片集
     */
    private String imgSrc;

    /**
     * 商品名
     */
    private String goodName;

    /**
     * 竞拍价格
     */
    private String auctionPrice;

    /**
     * 1 上架 2下架 3成交 4已邮件通知成交
     */
    private String status;

    private String detailImg1;

    private String detailImg2;

    private String detailImg3;

    private String createTime;

    /**
     * 自动成交时间 按天计算
     */
    private String limitedTime;

    private String userId;

    /**
     * 0添加索引库失败 1添加索引库成功
     */
    private String searchStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodDescribe() {
        return goodDescribe;
    }

    public void setGoodDescribe(String goodDescribe) {
        this.goodDescribe = goodDescribe;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(String auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetailImg1() {
        return detailImg1;
    }

    public void setDetailImg1(String detailImg1) {
        this.detailImg1 = detailImg1;
    }

    public String getDetailImg2() {
        return detailImg2;
    }

    public void setDetailImg2(String detailImg2) {
        this.detailImg2 = detailImg2;
    }

    public String getDetailImg3() {
        return detailImg3;
    }

    public void setDetailImg3(String detailImg3) {
        this.detailImg3 = detailImg3;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLimitedTime() {
        return limitedTime;
    }

    public void setLimitedTime(String limitedTime) {
        this.limitedTime = limitedTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(String searchStatus) {
        this.searchStatus = searchStatus;
    }
}