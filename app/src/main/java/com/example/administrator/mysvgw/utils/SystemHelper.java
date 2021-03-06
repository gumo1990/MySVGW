package com.example.administrator.mysvgw.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.example.administrator.mysvgw.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by whq on 2017/12/25.
 * 获取系统信息工具类
 */

public class SystemHelper {
    public SystemHelper() {
    }
    /**
     * 创建本应用的桌面快捷方式
     * 注意：需要添加权限uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT"
     */
    public static void createShortcut(Context context, Class<?> clazz) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        //快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, context.getString(R.string.app_name));
        shortcut.putExtra("duplicate", false); //不允许重复创建

        Intent localIntent2 = new Intent(context, clazz);
        localIntent2.setAction(Intent.ACTION_MAIN);
        localIntent2.addCategory(Intent.CATEGORY_LAUNCHER);

        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, localIntent2);//指定快捷方式要启动的Activity类型

        //快捷方式的图标
        Intent.ShortcutIconResource iconResource = Intent.ShortcutIconResource.fromContext(context, R.drawable.ic_launcher);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);

        context.sendBroadcast(shortcut);
    }

    /**
     * 检查存储卡是否插入
     *
     * @return
     */
    public static boolean isHasSdcard() {

        String status = Environment.getExternalStorageState();

        if (status.equals(Environment.MEDIA_MOUNTED)) {

            return true;

        } else {

            return false;

        }

    }

    /**
     * 检查是否已经创建了桌面快捷方式<br/>
     * 注意：需要添加权限&lt;uses-permission android:name="com.android.launcher.permission.READ_SETTINGS"/&gt;
     *
     * @return
     */
    public static boolean hasShortCut(Context context) {
        String url = "";
        if (android.os.Build.VERSION.SDK_INT < 8) {
            url = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            url = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(Uri.parse(url), null, "title=?",
                new String[]{context.getString(R.string.app_name)}, null);

        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true;
        }

        return false;
    }

    /**
     * 获取当前机器的屏幕信息对象<br/>
     * 另外：通过android.os.Build类可以获取当前系统的相关信息
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getScreenInfo(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm;
    }
    public static int getScreenWidth(Context ctx) {
        return getScreenInfo(ctx).widthPixels;
    }

    /**
     * 获取手机号<br/>
     * 注意：需要添加权限&lt;uses-permission
     * android:name="android.permission.READ_PHONE_STATE"/&gt;。另外很多手机不能获取到当前手机号
     *
     * @param context
     * @return
     */
    public static String getMobileNumber(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }
    /**
     * 检测当前的网络连接是否可用<br/>
     * 注意：需要添加权限&lt;uses-permission
     * android:name="android.permission.ACCESS_NETWORK_STATE"/&gt;
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        boolean flag = false;
        try {
            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (null != connManager) {
                NetworkInfo info = connManager.getActiveNetworkInfo();
                if (null != info && info.isAvailable()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            Log.e("NetworkInfo", "Exception", e);
        }
        return flag;
    }

    // 将字符串转为时间戳
    public static String getTime(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d;

        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }

    // 将时间戳 转为字符串
    public static String getTimeStr(String user_time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sd = sdf.format(new Date(Long.parseLong(user_time) * 1000));
        return sd;
    }

    // 将字符串转为时间戳
    public static long getTimeLong(String user_time) {
        long re_time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d;

        try {
            d = sdf.parse(user_time);
            re_time = d.getTime();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }

    /**
     * 检测当前网络连接的类型<br/>
     * 注意：需要添加权限 <uses-permission  android:name="android.permission.ACCESS_NETWORK_STATE"/>;
     *
     * @param context
     * @return 返回0代表GPRS网络;返回1,代表WIFI网络;返回-1代表网络不可用
     */
    public static int getNetworkType(Context context) {
        int code = -1;
        try {
            ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (null != connManager) {
                NetworkInfo.State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
                if (NetworkInfo.State.CONNECTED == state) {
                    code = ConnectivityManager.TYPE_WIFI;
                } else {
                    state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
                    if (NetworkInfo.State.CONNECTED == state) {
                        code = ConnectivityManager.TYPE_MOBILE;
                    }
                }
            }
        } catch (Exception e) {
            Log.e("NetworkInfo", "Exception", e);
        }
        return code;
    }

    /**
     * 返回当前程序版本代码,如:1
     *
     * @param context
     * @return 当前程序版本代码
     */
    public static int getAppVersionCode(Context context) {
        int versionCode = -1;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = pi.versionCode;

        } catch (Exception e) {
            Log.d("whq", "版本号获取出现问题==："+e);
        }
        return versionCode;
    }



























}
