package com.example.administrator.mysvgw.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.utils.CommonUtils;

public class SplashActivity extends BaseActivity {

    ImageView iv_splash;
    //使用SharedPreferences来记录程序的使用次数
    private boolean isFirst;

    @Override
    protected int getContetView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {
        iv_splash = getView(R.id.iv_splash);
        isFirst = CommonUtils.getBoolean(mContext, "isFirst", false);
    }

    @Override
    protected void initData() {
        iv_splash.setImageResource(R.drawable.ic_splash011);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpNext();
            }
        }, 2000);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void proClick(View view) {

    }

    private void jumpNext() {
        if (!isFirst) {
            startActivity(new Intent(mContext, GuildActivity.class));
            //存入数据
            CommonUtils.putBoolean(mContext, "isFirst", true);
            finish();
        } else {
            startActivity(new Intent(mContext, MainActivity.class));
            finish();
        }
    }
}
