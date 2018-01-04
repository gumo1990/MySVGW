package com.example.administrator.mysvgw.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.SystemBarTintManager;
import com.example.administrator.mysvgw.activity.LoginActivity;

/**
 * Created by whq on 2017/12/25.
 */

public class CommonUtils {

    private static final String PREF_NAME = "mysvgw";
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
    public static String getChannel() {
        String ret = "";
        try {
            ret = MyApplication.getInstance().getPackageManager()
                    .getApplicationInfo(MyApplication.getInstance().getPackageName(),
                            PackageManager.GET_META_DATA).metaData.getString("UMENG_CHANNEL");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("whq", "渠道名称--" + ret);
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
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean devalue) {
        if (sp == null) {
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, devalue);
    }

    public static void putString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String devalue) {
        if (sp == null) {
            sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, devalue);
    }

    public static void toast(Context context, String msg) {
        String oldMsg = null;
        Toast toast = null;
        long firstTime = 0;
        long secondTiem = 0;
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            toast.show();
            firstTime = System.currentTimeMillis();
        } else {
            secondTiem = System.currentTimeMillis();
            if (msg.equals(oldMsg)) {
                if (secondTiem - firstTime > Toast.LENGTH_LONG) {
                    toast.show();
                }
            } else {
                oldMsg = msg;
                toast.setText(msg);
                toast.show();
            }
        }
        firstTime = secondTiem;
    }

    //当前登录状态,true--已登录
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

    /**
     * 未登陆，跳转登陆
     */
    public static boolean checkLogin(Activity activity) {
        boolean result = false;
        String loginKey = MyApplication.getInstance().getLoginKey();
        if (!isEmpty(loginKey)) {
            return true;
        } else {
            activity.startActivity(new Intent(activity, LoginActivity.class));
        }
        return result;
    }

    /**
     * 修改系统状态栏颜色，需要在xml的根布局添加
     * android:fitsSystemWindows="true",否则会遮挡顶部
     * @param activity
     * @param color
     */
    public static void myStatusBar(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintResource(color);
        }
    }


    @TargetApi(19)
    private static void setTranslucentStatus(Activity activity, boolean type) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (type) {
            params.flags |= bits;

        } else {
            params.flags &= ~bits;
        }
        window.setAttributes(params);
    }
    /**
     * 带边框的圆形头像
     * @param bitmap
     * @param context
     * @return
     */
    public  static Drawable createRoundImageWithBorder(Bitmap bitmap, Context context){
        //原图宽度
        int bitmapWidth = bitmap.getWidth();
        //原图高度
        int bitmapHeight = bitmap.getHeight();
        //边框宽度 pixel
        int borderWidthHalf = 20;

        //转换为正方形后的宽高
        int bitmapSquareWidth = Math.min(bitmapWidth,bitmapHeight);

        //最终图像的宽高
        int newBitmapSquareWidth = bitmapSquareWidth+borderWidthHalf;

        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth,newBitmapSquareWidth,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundedBitmap);
        int x = borderWidthHalf + bitmapSquareWidth - bitmapWidth;
        int y = borderWidthHalf + bitmapSquareWidth - bitmapHeight;

        //裁剪后图像,注意X,Y要除以2 来进行一个中心裁剪
        canvas.drawBitmap(bitmap, x/2, y/2, null);
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderWidthHalf);
        borderPaint.setColor(Color.WHITE);

        //添加边框
        canvas.drawCircle(canvas.getWidth()/2, canvas.getWidth()/2, newBitmapSquareWidth/2, borderPaint);

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(),roundedBitmap);
        roundedBitmapDrawable.setGravity(Gravity.CENTER);
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }
    public static int getScreenWidth(Context ctx) {
        WindowManager windowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
