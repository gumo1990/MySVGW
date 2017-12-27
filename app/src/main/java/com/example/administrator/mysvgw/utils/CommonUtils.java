package com.example.administrator.mysvgw.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mysvgw.MyApplication;

/**
 * Created by whq on 2017/12/25.
 */

public class CommonUtils {

    private static final  String PREF_NAME = "mysvgw";
    private static SharedPreferences sp;
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

    /**
     * sharepreference存储的是手机app内存中
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean devalue){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key,devalue);
    }
    public static void putString(Context context, String key, String value){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key,value).commit();
    }

    public static String getString(Context context, String key, String devalue){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, devalue);
    }
    public static void toast(Context context, String msg){
        String oldMsg = null;
        Toast toast = null;
        long firstTime = 0;
        long secondTiem = 0;
        if(toast == null){
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            toast.show();
            firstTime = System.currentTimeMillis();
        }else{
            secondTiem = System.currentTimeMillis();
            if(msg.equals(oldMsg)){
                if(secondTiem - firstTime > Toast.LENGTH_LONG){
                    toast.show();
                }
            }else{
                oldMsg = msg;
                toast.setText(msg);
                toast.show();
            }
        }
       firstTime = secondTiem;
    }
















}
