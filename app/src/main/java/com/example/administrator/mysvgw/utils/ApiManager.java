package com.example.administrator.mysvgw.utils;

import com.example.administrator.mysvgw.Constant;
import com.example.administrator.mysvgw.MyApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whq on 2017/12/25.
 */

public class ApiManager {
    public static Map<String, String> simpleHeader = new HashMap<>();
    static {
        simpleHeader.put("client", "android");
        String code = SystemHelper.getAppVersionCode(MyApplication.getInstance())+"";
        simpleHeader.put("version", code);
        simpleHeader.put("channel", Constant.CHANNEL);
    }
}
