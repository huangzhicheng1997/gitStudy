package com.hzc.serviceuser.intercept;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;
import com.hzc.serviceuser.entity.User;
import com.hzc.serviceuser.exception.BaseException;
import com.hzc.serviceuser.param.UserInfo;
import com.hzc.serviceuser.utils.RedisUtil;
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
            response.setStatus(606);
            return false;
        }else {
            setUser(loginInfo);
            return true;
        }

    }

    public void setUser(String user){
        User admin = new User();
        JSONObject jsonObject= JSONObject.parseObject(user);
        admin.setAdmintel(jsonObject.getString("admintel"));
        admin.setEmail(jsonObject.getString("email"));
        admin.setStatus(jsonObject.getInteger("status"));
        admin.setUserImg(jsonObject.getString("userImg"));
        admin.setUserid(jsonObject.getString("userid"));
        admin.setUsername(jsonObject.getString("username"));
        UserInfo.setUser(admin);
    }

    }
