package com.example.administrator.mysvgw;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by whq on 2017/12/26.
 */

public abstract class BaseTopBarFragment extends Fragment implements View.OnClickListener{
    public ViewGroup convertView;
    private Unbinder unbinder;
    public View mStatusBarView;

    protected abstract int getContentView();
    public abstract void initViews();

    public abstract void initListener();

    public abstract void initData();

    public abstract void processClick(View view);

    private SparseArray<View> mViews;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViews = new SparseArray<>();
        if(convertView == null){
            convertView = (ViewGroup) inflater.inflate(getContentView(), container, false);
        }
        unbinder = ButterKnife.bind(this, convertView);
        ViewGroup parent = (ViewGroup) convertView.getParent();
        if (parent != null) {
            parent.removeView(convertView);
        }
        addStatusBar();
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

    /**
     * 添加一个View在bar顶部，适合Activity，
     * 主要适合一个Activity中包含多个Fragment
     * 在Fragment中设置mStatusBarView颜色
     * 需要在父Activity中设置状态栏透明
     */
    private void addStatusBar(){
        if(mStatusBarView == null){
            mStatusBarView = new View(getContext());
            int screenVidth = getResources().getDisplayMetrics().widthPixels;
            int statusBarHeight = getStatusBarHeight(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenVidth,statusBarHeight);
            mStatusBarView.setLayoutParams(params);
            mStatusBarView.requestLayout();
            if(convertView != null) {
                convertView.addView(mStatusBarView, 0);
            }

        }
    }
    protected <E extends View> E findView(int viewId) {
        if (convertView != null) {
            E view = (E) mViews.get(viewId);

            if (view == null) {
                view = (E) convertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return view;
        }
        return null;
    }
    public static int getStatusBarHeight(Activity activity){
        int statusBarHeight = 0;
        if(activity != null){
            int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        }
        return statusBarHeight;
    }
}
