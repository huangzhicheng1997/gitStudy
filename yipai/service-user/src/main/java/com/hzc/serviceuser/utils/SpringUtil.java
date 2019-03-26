package com.hzc.serviceuser.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringUtil implements ApplicationContextAware {
    private static  ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        return ctx;
    }
}
