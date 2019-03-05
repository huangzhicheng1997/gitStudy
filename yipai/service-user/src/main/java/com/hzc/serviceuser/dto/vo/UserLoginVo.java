package com.hzc.serviceuser.dto.vo;

import com.hzc.ResponseBase;
import com.hzc.api.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginVo extends ResponseBase {
    private String token;

    public UserLoginVo() {

    }
    public UserLoginVo(ResultCode resultCode) {
        super(resultCode);
        this.token = "";
    }
    public UserLoginVo(ResultCode resultCode, String token) {
        super(resultCode);
        this.token = token;
    }
}
