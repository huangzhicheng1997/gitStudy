package com.hzc.serviceuser.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "goods")
public class JpaGoods implements Serializable {
    private static final long serialVersionUID = -6763800936325172735L;

    @Id
    private String id;

    /**
     * 商品拍卖价格
     */
    @Column(name = "good_price")
    private String goodPrice;

    /**
     * 商品描述
     */
    @Column(name = "good_describe")
    private String goodDescribe;

    /**
     * 图片集
     */
    @Column(name = "img_src")
    private String imgSrc;

    /**
     * 商品名
     */
    @Column(name = "good_name")
    private String goodName;

    /**
     * 竞拍价格
     */
    @Column(name = "auction_price")
    private String auctionPrice;

    /**
     * 1 上架 2下架 3成交 4已邮件通知成交
     */
    private String status;
  @Column(name = "detail_img1")
    private String detailImg1;
    @Column(name = "detail_img2")
    private String detailImg2;
    @Column(name = "detail_img3")
    private String detailImg3;
    @Column(name = "create_time")
    private String createTime;

    /**
     * 自动成交时间 按天计算
     */
    @Column(name = "limited_time")
    private String limitedTime;
    @Column(name = "user_id")
    private String userId;

    /**
     * 0添加索引库失败 1添加索引库成功
     */
    @Column(name = "search_status")
    private String searchStatus;

}
