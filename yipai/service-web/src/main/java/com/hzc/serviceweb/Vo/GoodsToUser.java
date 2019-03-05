package com.hzc.serviceweb.Vo;

import com.hzc.serviceweb.entity.Goods;
import com.hzc.serviceweb.entity.User;
import lombok.Data;

@Data
public class GoodsToUser extends Goods {
private User user;
}
