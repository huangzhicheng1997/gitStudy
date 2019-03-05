package com.hzc.serviceuser.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;


@Configuration
public class RabbitMqProducerConfig{
    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

   /* *
     * 建立一个队列
     * durable开启持久化
     * @param rabbitAdmin
     * @return
     */
    @Bean
    Queue queueGoods(RabbitAdmin rabbitAdmin){
        Queue queue=new Queue("Goods",true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

   /* *
     * 建立一个交换所
     * @param rabbitAdmin
     * @return*/

    @Bean
    TopicExchange exchange(RabbitAdmin rabbitAdmin){
        //建立一个交换所
        TopicExchange exchange=new TopicExchange("exchange");
        rabbitAdmin.declareExchange(exchange);
        return exchange;
    }

   /* *
     * 交换所和队列绑定路由键
     * @param queue
     * @param exchange
     * @param rabbitAdmin
     * @return*/

    @Bean
    Binding bindingExchangeGoods(Queue queue,TopicExchange exchange,RabbitAdmin rabbitAdmin){
        Binding binding= BindingBuilder.bind(queue).to(exchange).with("Goods");
        rabbitAdmin.declareBinding(binding);
        return binding;
    }
    /**
     * 生产者用
     *
     * @return*/

    @Bean
    public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
        RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
        rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
        rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
        return rabbitMessagingTemplate;
    }

    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }
}
