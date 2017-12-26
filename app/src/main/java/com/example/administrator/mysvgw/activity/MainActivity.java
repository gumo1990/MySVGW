package com.example.administrator.mysvgw.activity;

import android.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by whq on 2017/12/25.
 * 注解：1.gradle中引用
 *      compile 'com.jakewharton:butterknife:8.5.1'
 *      annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'
 *      2.onCreate中绑定
 *
 *      3.ondestroy中解绑
 */

public class MainActivity extends BaseActivity {

    Unbinder bind;
    @BindView(R.id.fl_main)
    FrameLayout frameLayout;

    private FragmentManager fragmentManager;
    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
         bind = ButterKnife.bind(this);
     //   fragmentManager =
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void proClick(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
