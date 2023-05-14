package com.gk.study.permission;

public enum AccessLevel {

    // 此处需与user表的role字段对应起来

    LOGIN(1, "all"), // 登录用户
    DEMO(2, "demo"), // 演示账号
    ADMIN(3, "admin"), // 管理员
    SUPER(4, "super"); // 超级管理员

    int code;
    String msg;

    AccessLevel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
