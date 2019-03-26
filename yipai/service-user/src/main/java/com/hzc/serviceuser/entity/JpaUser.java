package com.hzc.serviceuser.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class JpaUser implements Serializable {
    private static final long serialVersionUID = -4205096641307478500L;
    @Id
    @Column(name = "userId")
    private String userId;
    @Column(name = "adminTel")
    private String adminTel;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private Integer status;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "user_img")
    private String userImg;
}
