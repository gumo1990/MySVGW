package com.example.administrator.mysvgw;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by whq on 2017/12/26.
 * 不改变系统状态栏bar颜色
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    public ViewGroup convertView;
    private Unbinder unbinder;
    public View mStatusBarView;
    public static Handler mHandler = new Handler();

    protected abstract int getContentView();
    public abstract void initViews();

    public abstract void initListener();

    public abstract void initData();

    public abstract void processClick(View view);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(convertView == null){
            convertView = (ViewGroup) inflater.inflate(getContentView(), container, false);
        }
        unbinder = ButterKnife.bind(this, convertView);
        ViewGroup parent = (ViewGroup) convertView.getParent();
        if (parent != null) {
            parent.removeView(convertView);
        }
        initViews();
        initListener();
        initData();
        return convertView;
    }

    @Override
    public void onClick(View view) {
        processClick(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
