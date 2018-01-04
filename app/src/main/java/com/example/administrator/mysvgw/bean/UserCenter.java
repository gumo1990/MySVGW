package com.example.administrator.mysvgw.bean;

import java.io.Serializable;

/**
 * Created by whq on 2018/1/3.
 */

public class UserCenter implements Serializable {

    /**
     * lastIp : 1.202.215.186
     * lastLogin : 2017-12-22 10:01:08
     * portrait : http://www.svgouwu.com/data/files/mall/portrait/15141721851049.jpg
     * returnGoodsNum : 0
     * userName : 13161312285
     * waitForCommentNum : 0
     * waitForConfirmNum : 0
     * waitForDeliverGoodsNum : 15
     * waitForPayNum : 0
     */

    private String lastIp;
    private String lastLogin;
    private String portrait;
    private int returnGoodsNum;
    private String userName;
    private int waitForCommentNum;
    private int waitForConfirmNum;
    private int waitForDeliverGoodsNum;
    private int waitForPayNum;

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getReturnGoodsNum() {
        return returnGoodsNum;
    }

    public void setReturnGoodsNum(int returnGoodsNum) {
        this.returnGoodsNum = returnGoodsNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWaitForCommentNum() {
        return waitForCommentNum;
    }

    public void setWaitForCommentNum(int waitForCommentNum) {
        this.waitForCommentNum = waitForCommentNum;
    }

    public int getWaitForConfirmNum() {
        return waitForConfirmNum;
    }

    public void setWaitForConfirmNum(int waitForConfirmNum) {
        this.waitForConfirmNum = waitForConfirmNum;
    }

    public int getWaitForDeliverGoodsNum() {
        return waitForDeliverGoodsNum;
    }

    public void setWaitForDeliverGoodsNum(int waitForDeliverGoodsNum) {
        this.waitForDeliverGoodsNum = waitForDeliverGoodsNum;
    }

    public int getWaitForPayNum() {
        return waitForPayNum;
    }

    public void setWaitForPayNum(int waitForPayNum) {
        this.waitForPayNum = waitForPayNum;
    }
}
