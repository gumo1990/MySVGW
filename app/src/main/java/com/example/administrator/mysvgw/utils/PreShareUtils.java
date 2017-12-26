package com.example.administrator.mysvgw.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by whq on 2017/12/26.
 * sharePreference封装
 */

public class PreShareUtils {
    private static final  String PREF_NAME = "mysvgw";
    private static SharedPreferences sp;

    public static void putBoolean(Context context, String key, boolean value){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key,value).commit();
    }
    public static boolean getBoolean(Context context, String key, boolean defaule){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key,defaule);
    }

    public static void putString(Context context, String key, String value){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        }
        sp.edit().putString(key,value).commit();
    }
    public static String getString(Context context, String key, String defaule){
        if(sp == null){
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key,defaule);
    }







}
