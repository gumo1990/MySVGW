package com.example.administrator.mysvgw.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;


import com.example.administrator.mysvgw.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimePickDialogUtils implements OnDateChangedListener,
        OnTimeChangedListener {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private AlertDialog ad;
    private String dateTime;
    private String initDateTime;
    private Activity activity;
    private long selectedTimeInMillis; //选择日期的时间戳

    /**
     * 日期时间弹出选择框构造函数
     *
     * @param activity     ：调用的父activity
     * @param initDateTime 初始日期时间值，作为弹出窗口的标题和日期时间初始值
     */
    public DateTimePickDialogUtils(Activity activity, String initDateTime) {
        this.activity = activity;
        this.initDateTime = initDateTime;

    }

    public void init(DatePicker datePicker) {
        Calendar calendar = Calendar.getInstance();
        if (!(null == initDateTime || "".equals(initDateTime))) {
            calendar = this.getCalendarByInintData(initDateTime);
        } else {
            initDateTime = calendar.get(Calendar.YEAR) + "年"
                    + calendar.get(Calendar.MONTH) + "月"
                    + calendar.get(Calendar.DAY_OF_MONTH) + "日 "
                    + calendar.get(Calendar.HOUR_OF_DAY) + ":"
                    + calendar.get(Calendar.MINUTE);
        }

        datePicker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), this);
/*timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));  */
    }

    /**
     * 弹出日期时间选择框方法
     *
     * @return
     */
    public AlertDialog show(final DataPickCallback callback) {
        LinearLayout dateTimeLayout = (LinearLayout) activity
                .getLayoutInflater().inflate(R.layout.dialog_view_datetime, null);
        datePicker = (DatePicker) dateTimeLayout.findViewById(R.id.datepicker);

        init(datePicker);
/*timePicker.setIs24HourView(true);
timePicker.setOnTimeChangedListener(this);*/

        ad = new AlertDialog.Builder(activity)
                .setTitle(initDateTime)
                .setView(dateTimeLayout)
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        callback.onNegative();
                    }
                }).show();

        ad.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    if(selectedTimeInMillis > System.currentTimeMillis()-86400000){
                        CommonUtils.toast(activity,"请选择正确的出生日期");
                        return;
                    }
                    callback.onPositive(dateTime);
                    ad.dismiss();
                }
            }
        });

        onDateChanged(null, 0, 0, 0);
        return ad;
    }

    /**
     *
     .setPositiveButton(activity.getString(R.string.dialog_date_set), new DialogInterface.OnClickListener() {
     public void onClick(DialogInterface dialog, int whichButton) {
     if (callback != null) {
     if(selectedTimeInMillis > System.currentTimeMillis()-86400000){
     ToastUtil.toast("请选择正确的出生日期");
     return;
     }
     callback.onPositive(dateTime);
     }
     }
     })
     */

    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        onDateChanged(null, 0, 0, 0);
    }

    public void onDateChanged(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
// 获得日历实例  
        Calendar calendar = Calendar.getInstance();

        calendar.set(datePicker.getYear(), datePicker.getMonth(),
                datePicker.getDayOfMonth());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");

        dateTime = sdf.format(calendar.getTime());
        selectedTimeInMillis = calendar.getTimeInMillis();

        ad.setTitle(dateTime);
        Window dialogWindow = ad.getWindow();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    /**
     * 实现将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒,并赋值给calendar
     *
     * @param initDateTime 初始日期时间值 字符串型
     * @return Calendar
     */
    private Calendar getCalendarByInintData(String initDateTime) {
        Calendar calendar = Calendar.getInstance();

// 将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒  
        String date = spliteString(initDateTime, " ", "index", "front"); // 日期
//        String time = spliteString(initDateTime, " ", "index", "back"); // 时间

        String yearStr = spliteString(date, "-", "index", "front"); // 年份
        String monthAndDay = spliteString(date, "-", "index", "back"); // 月日

        String monthStr = spliteString(monthAndDay, "-", "index", "front"); // 月
        String dayStr = spliteString(monthAndDay, "-", "index", "back"); // 日


        int currentYear = Integer.valueOf(yearStr.trim()).intValue();
        int currentMonth = Integer.valueOf(monthStr.trim()).intValue() - 1;
        int currentDay = Integer.valueOf(dayStr.trim()).intValue();


        calendar.set(currentYear, currentMonth, currentDay);
        return calendar;
    }

    /**
     * 截取子串
     *
     * @param srcStr      源串
     * @param pattern     匹配模式
     * @param indexOrLast
     * @param frontOrBack
     * @return
     */
    public static String spliteString(String srcStr, String pattern,
                                      String indexOrLast, String frontOrBack) {
        String result = "";
        int loc = -1;
        if (indexOrLast.equalsIgnoreCase("index")) {
            loc = srcStr.indexOf(pattern); // 取得字符串第一次出现的位置
        } else {
            loc = srcStr.lastIndexOf(pattern); // 最后一个匹配串的位置
        }
        if (frontOrBack.equalsIgnoreCase("front")) {
            if (loc != -1)
                result = srcStr.substring(0, loc); // 截取子串
        } else {
            if (loc != -1)
                result = srcStr.substring(loc + 1, srcStr.length()); // 截取子串
        }
        return result;
    }

    public interface DataPickCallback {
        void onPositive(String date);

        void onNegative();
    }
}  