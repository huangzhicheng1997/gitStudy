package com.hzc.serviceuser.dto.vo;

import com.hzc.ResponseBase;
import com.hzc.api.enums.ResultCode;
import lombok.Data;

@Data
public class GoodsVo<T> extends ResponseBase {
    T content;

    public GoodsVo(ResultCode resultCode, T content) {
        super(resultCode);
        this.content = content;
    }
}
