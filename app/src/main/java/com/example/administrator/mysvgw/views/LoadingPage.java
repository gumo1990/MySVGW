package com.example.administrator.mysvgw.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mysvgw.R;

/**
 * Created by whq on 2018/1/4.
 */

public class LoadingPage extends FrameLayout {
    public static final int LOADING = 0;
    public static final int LOADING_NONET = 1;
    public static final int LOADING_NODATA = 2;
    public static final int LOADING_HINT = 3;

    View loadingView;//加载中
    TextView tv_loading;
    View loadingnoData;//数据为空
    TextView tv_nodata;
    View loadingnoNet;//没有网络
    TextView tv_nonet;
    LinearLayout ll_nonet;
    LoadingListener loadinglistener;
    public interface LoadingListener{
        void onLoading();
    }
    public LoadingPage(Context context) {
        super(context);
        initView();
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        loadingView = createLoading();
        if (loadingView != null) {
            this.addView(loadingView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        loadingnoData = createNoDate();
        if (loadingnoData != null) {
            this.addView(loadingnoData, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        loadingnoNet = createNoNet();
        if (loadingnoNet != null) {
            this.addView(loadingnoNet, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    private View createNoNet() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loading_nonet, null);
        tv_nonet = view.findViewById(R.id.tv_nonet);
        ll_nonet = view.findViewById(R.id.ll_nonet);
        ll_nonet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                loadinglistener.onLoading();;
            }
        });
        return view;
    }

    private View createNoDate() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loading_nodata, null);
        tv_nodata = view.findViewById(R.id.tv_nodata);
        return view;
    }

    private View createLoading() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loading_dialog, null);
        tv_loading = view.findViewById(R.id.tv_loading);
        return view;
    }

    public void switchLoadingState(int type) {
        switch (type) {
            case LOADING:
                if (loadingView != null) {
                    loadingView.setVisibility(VISIBLE);
                }
                if (loadingnoNet != null) {
                    loadingnoNet.setVisibility(GONE);
                }
                if (loadingnoData != null) {
                    loadingnoData.setVisibility(GONE);
                }
                break;
            case LOADING_NODATA:
                if (loadingnoData != null) {
                    loadingnoData.setVisibility(VISIBLE);
                }
                if (loadingnoNet != null) {
                    loadingnoNet.setVisibility(GONE);
                }
                if (loadingView != null) {
                    loadingView.setVisibility(GONE);
                }
                break;
            case LOADING_NONET:
                if (loadingnoNet != null) {
                    loadingnoNet.setVisibility(VISIBLE);
                }
                if (loadingView != null) {
                    loadingView.setVisibility(GONE);
                }
                if (loadingnoData != null) {
                    loadingnoData.setVisibility(GONE);
                }
                break;
            case LOADING_HINT:
                if (loadingnoData != null) {
                    loadingnoData.setVisibility(GONE);
                }
                if (loadingView != null) {
                    loadingView.setVisibility(GONE);
                }
                if (loadingnoNet != null) {
                    loadingnoNet.setVisibility(GONE);
                }
                break;
            default:
                break;
        }
    }

    public void setLoadinglistener(LoadingListener listener){
        this.loadinglistener = listener;
    }

}
