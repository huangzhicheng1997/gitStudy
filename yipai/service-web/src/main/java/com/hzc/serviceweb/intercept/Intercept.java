package com.hzc.serviceweb.intercept;

import com.hzc.serviceweb.enums.StatusCodeEnum;
import com.hzc.serviceweb.exception.BaseException;
import com.hzc.serviceweb.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class Intercept implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method=request.getMethod();
        if(StringUtils.isNotEmpty(method) && "OPTIONS".equals(method)){
            return true;
        }
        String token = request.getHeader("token");
        if(!StringUtils.isNotEmpty(token)){
            BaseException.error(StatusCodeEnum.LOGIN_EXPIRE);
        }
        String loginInfo = redisUtil.get(token);
        if(!StringUtils.isNotEmpty(loginInfo)){
            BaseException.error(StatusCodeEnum.LOGIN_EXPIRE);
        }
        return true;
    }

    }
