package com.hzc.serviceuser.dto.param;

import lombok.Data;

@Data
public class RegistRq{
    private String phone;
    private String pwd;
    private String email;
    private String username;
}
