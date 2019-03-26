package com.hzc.serviceweb.dto.param;


import com.hzc.serviceweb.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginRq extends BaseDTO {
    private String phone;
    private String pwd;
    private String email;
}
