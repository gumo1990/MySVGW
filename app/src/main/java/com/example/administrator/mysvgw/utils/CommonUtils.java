package com.example.administrator.mysvgw.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mysvgw.MyApplication;

/**
 * Created by whq on 2017/12/25.
 */

public class CommonUtils {

    private static final  String PREF_NAME = "mysvgw";
    private static SharedPreferences sp;

    /**
     * 空判断
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == "" || str == null || str.length() == 0 || "null".equalsIgnoreCase(str.toString()))
            return true;
        else
            return false;
    }
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

    //当前登录状态
    public static boolean isLogin() {
        boolean result = false;
        String loginKey = MyApplication.getInstance().getLoginKey();
        if (!isEmpty(loginKey)) {
            return true;
        }

        return result;
    }


    /**
     * 是否点击的是EditText
     */
    public static boolean isShouldHideInput(View view, MotionEvent event) {
        if (view != null && (view instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location
            view.getLocationInWindow(leftTop);
            ;
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + view.getHeight();
            int right = left + view.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top
                    && event.getY() < bottom) {
                //点击的是输入框，保留EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    /**
     * 关闭软键盘
     */

    public static void hintSoftKeyboard(Activity context) {
        View view = context.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }











}
