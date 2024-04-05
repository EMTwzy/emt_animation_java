package com.emt_animation_java.www.Pojo;

import lombok.Data;

@Data
public class emt_user {
    private Integer userId;   //用户序列号
    private String userName;  //用户名称
    private String userPassword;  //用户密码
    private Integer loginTime;    //登录时间
    private String loginIp;       //登录ip地址
    private String loginDevice;   //登录设备
    private Integer loginPass;    //登录许可 1许可 0不许可

}
