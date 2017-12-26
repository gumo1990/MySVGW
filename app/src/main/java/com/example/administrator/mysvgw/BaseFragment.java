package com.example.administrator.mysvgw;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



/**
 * Created by whq on 2017/12/26.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    public View convertView;

    protected abstract int getContentView();
    public abstract void initViews();

    public abstract void initListener();

    public abstract void initData();

    public abstract void processClick(View view);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(convertView == null){
            convertView = inflater.inflate(getContentView(), container, false);
        }
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
}
