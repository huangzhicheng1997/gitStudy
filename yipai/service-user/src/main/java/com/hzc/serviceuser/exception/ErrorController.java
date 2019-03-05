package com.hzc.serviceuser.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzc.serviceuser.dto.response.BaseRs;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@Controller
public class ErrorController extends AbstractErrorController {
    public ErrorController(){
        super(new DefaultErrorAttributes());
    }
    @Override
    public String getErrorPath() {
        return null;
    }
    @RequestMapping("/error")
    public Object errors(HttpServletRequest request, HttpServletResponse response){
        //拿到前台的异常信息
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
        int status=(Integer) model.get("status");
        if(404==status){
            return  "/error/404";
        }
        //自定义友好型异常
        String msg = (String)model.get("message");
        JSONObject object = JSONObject.parseObject(msg);
        int code = object.getInteger("code");
        String message = object.getString("message");
        return new ResponseEntity(new BaseRs(code,message), HttpStatus.OK);
    }
}
