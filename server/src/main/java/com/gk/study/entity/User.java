package com.gk.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@TableName("b_user")
public class User implements Serializable {
    public static final int NormalUser = 1;
    public static final int DemoUser = 2;
    public static final int AdminUser = 3;

    @TableId(value = "id",type = IdType.AUTO)
    public String id;
    @TableField
    public String username;
    @TableField
    public String password;
    @TableField(exist = false)
    public String rePassword;
    @TableField
    public String nickname;
    @TableField
    public String mobile;
    @TableField
    public String email;
    @TableField
    public String description;
    @TableField
    public String role;
    @TableField
    public String status;
    @TableField
    public String score;
    @TableField
    public String avatar;
    @TableField(exist = false)
    public MultipartFile avatarFile;
    @TableField
    public String token;
    @TableField
    public String createTime;
    @TableField
    public String pushEmail;
    @TableField
    public String pushSwitch;



}
