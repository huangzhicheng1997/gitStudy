package com.hzc.serviceuser.entity;


import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.omg.CORBA.StringHolder;

import javax.persistence.*;



@Entity
@Table(name = "goods_comment")
@Data
public class GoodsComent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    private String content;

    private Integer ctime;

    @Column(name = "good_id")
    private String goodId;
}
