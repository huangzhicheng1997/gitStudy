package com.hzc.serviceuser.dto.response;


import com.hzc.serviceuser.dto.BaseDTO;
import com.hzc.serviceuser.dto.enums.StatusCodeEnum;

public class BaseRs<T> extends BaseDTO {
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

    private T content;

    public BaseRs() {
    }

    public BaseRs(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseRs(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public BaseRs(StatusCodeEnum status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    public BaseRs(StatusCodeEnum status, T content) {
        this.code = status.getCode();
        this.message = status.getMsg();
        this.content = content;
    }

    public static <V> BaseRs ok(V content) {
        return new BaseRs(StatusCodeEnum.SUCCESS, content);
    }

    public static BaseRs ok() {
        return new BaseRs(StatusCodeEnum.SUCCESS);
    }

    public static BaseRs error(StatusCodeEnum error) {
        return new BaseRs(error);
    }

    public void setCode(StatusCodeEnum status) {
        this.code = status.getCode();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BaseRs{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", content=" + content +
                '}';
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getContent() {
        return content;
    }
}
