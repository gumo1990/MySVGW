package com.example.administrator.mysvgw.bean;

import java.io.Serializable;

/**
 * Created by whq on 2017/12/27.
 */

public class UserBean implements Serializable {
    public String userName;
    public String realName;
    public String age;
    public int sex;
    public String birthday;
    public String token;
    private long userId;

    public UserBean(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public long getId() {
        return userId;
    }
}
