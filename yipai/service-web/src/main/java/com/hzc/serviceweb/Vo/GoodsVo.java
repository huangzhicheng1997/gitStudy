package com.hzc.serviceweb.Vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Data
@Document(indexName = "goods",type = "good")
public class GoodsVo implements Serializable {
    @Id
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

    @Override
    public String toString() {
        return "GoodsVo{" +
                "id='" + id + '\'' +
                ", goodPrice='" + goodPrice + '\'' +
                ", goodDescribe='" + goodDescribe + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", goodName='" + goodName + '\'' +
                ", auctionPrice='" + auctionPrice + '\'' +
                ", status='" + status + '\'' +
                ", detailImg1='" + detailImg1 + '\'' +
                ", detailImg2='" + detailImg2 + '\'' +
                ", detailImg3='" + detailImg3 + '\'' +
                ", createTime='" + createTime + '\'' +
                ", limitedTime='" + limitedTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
