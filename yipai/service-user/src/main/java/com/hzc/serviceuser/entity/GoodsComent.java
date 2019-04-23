package com.hzc.serviceuser.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GeneratorType;
import org.omg.CORBA.StringHolder;

import javax.persistence.*;



@Data
@EqualsAndHashCode(callSuper = false)
@TableName("goods_comment")
public class GoodsComent {
    @TableId(value = "id")
    private Integer id;
    @TableField(value = "user_id")
    private String userId;
    @TableField(value = "content")
    private String content;
    @TableField(value = "ctime")
    private Integer ctime;
    @TableField(value = "good_id")
    private String goodId;
}
