package com.example.administrator.mysvgw;

import com.example.administrator.mysvgw.utils.CommonUtils;

/**
 * Created by whq on 2017/12/25.
 */

public class Constant {

    public static final long SEND_CODE_TIME = 60 * 1000; //再次发送验证码时间间隔
    //渠道设置
    public static String CHANNEL = CommonUtils.getChannel();//qq 360

}
