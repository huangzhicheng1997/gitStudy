package com.hzc.serviceweb.enums;

import java.io.Serializable;

public enum StatusCodeEnum implements Serializable {
    SUCCESS(200,"成功"),
    FAILD(-1,"失败"),
    /**
     * 登陆超时,请重新登陆
     */
    LOGIN_EXPIRE(1001, "登陆超时,请重新登陆");
    private int code;
    private  String msg;
    StatusCodeEnum(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
