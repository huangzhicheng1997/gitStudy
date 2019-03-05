package com.hzc.serviceuser.exception;

import com.alibaba.fastjson.JSON;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;

public class BaseException {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public static void error() throws Exception{
    error(StatusCodeEnum.FAILD);
    }
    public static void error(StatusCodeEnum statusCodeEnum) throws Exception{
        error(statusCodeEnum.getCode(),statusCodeEnum.getMsg());
    }
    public static void error(int code, String message) throws Exception{
        BaseException baseException=new BaseException();
        baseException.setCode(code);
        baseException.setMessage(message);
        throw  new Exception(JSON.toJSONString(baseException));
    }

    @Override
    public String toString(){
        return  "BaseException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
