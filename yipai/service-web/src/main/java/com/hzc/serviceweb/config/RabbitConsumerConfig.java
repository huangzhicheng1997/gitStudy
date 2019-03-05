package com.hzc.serviceweb.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class RabbitConsumerConfig  implements RabbitListenerConfigurer {
    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory factory=new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(new MappingJackson2MessageConverter());
        return factory;
    }
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory
    ){
    SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    //接受5条信息消费后 mq就不会在推送信息过来 等消费完了才会再次推送过来
    factory.setPrefetchCount(5);
    factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
    return factory;
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());

    }
}
