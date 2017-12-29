package com.example.administrator.mysvgw;

import android.app.Application;
import android.icu.util.TimeUnit;

import com.example.administrator.mysvgw.utils.ApiManager;
import com.example.administrator.mysvgw.utils.CommonUtils;
import com.kili.okhttp.OkHttpUtils;

/**
 * Created by whq on 2017/12/25.
 * 在这个页面设置app名称
 */

public class MyApplication extends Application {

    private static MyApplication instance;


    public static MyApplication getInstance() {
        return instance;
    }


    public MyApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtils.getInstance().addCommonHeaders(ApiManager.simpleHeader).setConnectTimeout(100000, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public void setLoginKey(String loginKey) {
        CommonUtils.putString(this, "loginKey", loginKey);
    }

    public String getLoginKey() {
        String loginKey = CommonUtils.getString(this, "loginKey","");
        return loginKey;
    }
    public void logout() {
        setLoginKey("");
    }































}
