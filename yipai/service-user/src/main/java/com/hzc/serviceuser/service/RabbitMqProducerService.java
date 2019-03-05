package com.hzc.serviceuser.service;

import com.hzc.serviceuser.entity.Goods;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducerService {
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;
    public void sendGoods(final Goods goods){
        this.rabbitMessagingTemplate.convertAndSend("exchange","Goods",goods);
    }
}
