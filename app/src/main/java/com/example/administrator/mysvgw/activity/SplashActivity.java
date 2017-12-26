package com.example.administrator.mysvgw.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;

public class SplashActivity extends BaseActivity {

    ImageView iv_splash;
    //使用SharedPreferences来记录程序的使用次数
    SharedPreferences sharedPreferences;
    private boolean isFirst;
    @Override
    protected int getContetView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {
        iv_splash = getView(R.id.iv_splash);
        sharedPreferences = getSharedPreferences("isFirst", MODE_PRIVATE);
        isFirst = sharedPreferences.getBoolean("isFirst",false);
        Log.d("whq","==false=="+isFirst);
    }

    @Override
    protected void initData() {
        iv_splash.setImageResource(R.drawable.ic_splash011);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpNext();
            }
        },2000);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void proClick(View view) {

    }

    private void jumpNext(){
        if(!isFirst){
            startActivity(new Intent(mContext, GuildActivity.class));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //存入数据
            editor.putBoolean("isFirst",true);
            editor.commit();
            finish();
        }else{
            startActivity(new Intent(mContext, MainActivity.class));
            finish();
        }
    }
}
