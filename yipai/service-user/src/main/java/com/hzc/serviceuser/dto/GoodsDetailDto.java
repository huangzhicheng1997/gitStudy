package com.hzc.serviceuser.dto;

import com.hzc.serviceuser.entity.Goods;


public class GoodsDetailDto extends Goods {
    /**
     * 当前用户是否以经竞拍过
     */
    private Boolean UserIsAuction;

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

    public Boolean getUserIsAuction() {
        return UserIsAuction;
    }

    public void setUserIsAuction(Boolean userIsAuction) {
        UserIsAuction = userIsAuction;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getGoodPrice() {
        return goodPrice;
    }

    @Override
    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Override
    public String getGoodDescribe() {
        return goodDescribe;
    }

    @Override
    public void setGoodDescribe(String goodDescribe) {
        this.goodDescribe = goodDescribe;
    }

    @Override
    public String getImgSrc() {
        return imgSrc;
    }

    @Override
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String getGoodName() {
        return goodName;
    }

    @Override
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Override
    public String getAuctionPrice() {
        return auctionPrice;
    }

    @Override
    public void setAuctionPrice(String auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getDetailImg1() {
        return detailImg1;
    }

    @Override
    public void setDetailImg1(String detailImg1) {
        this.detailImg1 = detailImg1;
    }

    @Override
    public String getDetailImg2() {
        return detailImg2;
    }

    @Override
    public void setDetailImg2(String detailImg2) {
        this.detailImg2 = detailImg2;
    }

    @Override
    public String getDetailImg3() {
        return detailImg3;
    }

    @Override
    public void setDetailImg3(String detailImg3) {
        this.detailImg3 = detailImg3;
    }

    @Override
    public String getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getLimitedTime() {
        return limitedTime;
    }

    @Override
    public void setLimitedTime(String limitedTime) {
        this.limitedTime = limitedTime;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getSearchStatus() {
        return searchStatus;
    }

    @Override
    public void setSearchStatus(String searchStatus) {
        this.searchStatus = searchStatus;
    }
}
