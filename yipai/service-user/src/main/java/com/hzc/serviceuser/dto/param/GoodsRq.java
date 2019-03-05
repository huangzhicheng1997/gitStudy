package com.hzc.serviceuser.dto.param;

import lombok.Data;

@Data
public class GoodsRq {
    private String goodName;
    private String coverImage;
    private String goodPrice;
    private String limited_time;
    private String detailImage;
    private String goodDescribe;
}
