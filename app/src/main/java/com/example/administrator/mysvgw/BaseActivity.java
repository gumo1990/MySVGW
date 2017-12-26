package com.example.administrator.mysvgw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by whq on 2017/12/25.
 * 添加注解
 *  compile 'com.jakewharton:butterknife:8.5.1'
 * annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'--添加注解
 * 在onCreate中先绑定
 * unbinder = ButterKnife.bind(this);
 * 销毁时候要解绑
 * unbinder.unbind();
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    Unbinder unbinder;
    protected Context mContext;
    protected  abstract int getContetView();
    protected abstract void initViews();
    protected abstract void initData();
    public abstract void initListener();
    public abstract void proClick(View view);
    private SparseArray<View> mViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
        mViews = new SparseArray<>();
        setContentView(getContetView());
        initViews();
        initData();
        initListener();


    }

    public BaseActivity() {
        this.mContext = this;
    }

    @Override
    public void onClick(View view) {
        proClick(view);
    }

    /**
     * 简化findViewById
     */
    @SuppressWarnings("unchecked")
    protected <E extends View> E getView(int viewId){
        E view = (E) mViews.get(viewId);

        if (view == null) {
            view = (E) findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!isFinishing()){
            //如果activity还在执行,取消绑定，防止泄露
            unbinder.unbind();
        }
    }
}
