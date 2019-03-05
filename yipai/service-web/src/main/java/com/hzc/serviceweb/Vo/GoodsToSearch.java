package com.hzc.serviceweb.Vo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Data
@Document(indexName = "goods",type = "good")
public class GoodsToSearch implements Serializable {
    private Long id;

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
     * 1 上架 2下架 3成交
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

    private static final long serialVersionUID = 1L;
}
