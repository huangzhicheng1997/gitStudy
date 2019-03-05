package com.hzc.api.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("200","成功"),
    FAIL("500","失败"),
    SYSTEM_ERROR("500","系统异常"),
    SUCCESS_VERIFY("200","验证通过"),
    FAILD_VERIFY("500","账户已存在");
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;

    ResultCode(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
