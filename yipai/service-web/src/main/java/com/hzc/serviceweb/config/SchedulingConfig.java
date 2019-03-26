package com.hzc.serviceweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

/*@Configuration
@EnableScheduling
public class SchedulingConfig {
    @Bean
    TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("Task-Thread-");
        return taskScheduler;
    }
}*/
