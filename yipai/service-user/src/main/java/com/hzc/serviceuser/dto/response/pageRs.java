package com.hzc.serviceuser.dto.response;

import com.hzc.serviceuser.dto.BaseDTO;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;

public class pageRs<T> extends BaseDTO {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回结果描述
     */
    private String message;
    /**
     * 数据条数
     */
    private Integer count;

    private T data;

    public pageRs() {
    }

    public pageRs(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public pageRs(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.data = content;
    }

    public pageRs(StatusCodeEnum status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    public pageRs(StatusCodeEnum status, T content) {
        this.code = status.getCode();
        this.message = status.getMsg();
        this.data = content;
    }
    public pageRs(int code,String message, T content,Integer count) {
        this.code=code;
        this.count=count;
        this.message=message;
        this.data=content;
    }
    public pageRs(StatusCodeEnum status, T content,Integer count) {
     this.code=status.getCode();
     this.count=count;
     this.message=status.getMsg();
     this.data=content;
    }

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
