package com.hzc.serviceweb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Data
@Document(indexName = "testgoods",type="goods")
public class GoodsInfo  implements Serializable{
    private Long id;

}
