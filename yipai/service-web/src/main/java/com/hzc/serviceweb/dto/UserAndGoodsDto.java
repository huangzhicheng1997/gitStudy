package com.hzc.serviceweb.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAndGoodsDto<T> implements Serializable {

    private T  content;






    private static final long serialVersionUID = -7678037990487693311L;
}
