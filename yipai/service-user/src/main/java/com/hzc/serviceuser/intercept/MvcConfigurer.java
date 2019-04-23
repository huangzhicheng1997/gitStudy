package com.hzc.serviceuser.intercept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    /**
     * 配置一个拦截器的bean
     * @return
     */
    @Bean
    public Intercept setIntercept(){
        return new Intercept();
    }

    /**
     * 将拦截器的bean进行注册
     * @param interceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(setIntercept())
        .addPathPatterns("/**").excludePathPatterns("/user/login").excludePathPatterns("/user/regist").excludePathPatterns("/goods/getGoods")
               ;
    }
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedHeaders("*")
                .maxAge(3600);
    }


}
