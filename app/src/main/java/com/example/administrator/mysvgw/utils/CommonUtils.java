package com.example.administrator.mysvgw.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.example.administrator.mysvgw.MyApplication;

/**
 * Created by whq on 2017/12/25.
 */

public class CommonUtils {

    /**
     * 获取渠道名
     */
    public static String getChannel(){
        String ret = "";
        try {
            ret = MyApplication.getInstance().getPackageManager()
                    .getApplicationInfo(MyApplication.getInstance().getPackageName(),
                            PackageManager.GET_META_DATA).metaData.getString("UMENG_CHANNEL");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("whq" ,"渠道名称--"+ ret);
        return ret;
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
