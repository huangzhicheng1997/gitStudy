package com.hzc;

import com.hzc.api.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseBase implements Serializable {
   private String code;
   private String message;

    public ResponseBase() {

    }
    public ResponseBase(String code) {
        this.code = code;
        this.message="";
    }
    public ResponseBase(String code,String message) {
        this.code = code;
        this.message=message;
    }
    public ResponseBase(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.message=resultCode.getMsg();
    }
}
