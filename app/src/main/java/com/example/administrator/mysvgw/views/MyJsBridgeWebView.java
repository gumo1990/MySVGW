package com.example.administrator.mysvgw.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;

import com.example.administrator.mysvgw.R;
import com.github.lzyzsd.jsbridge.BridgeWebView;

/**
 * Created by topwolf on 2017/5/24.
 */

/**
 * Created by topwolf on 2017/5/24.
 */

public class MyJsBridgeWebView extends BridgeWebView {

    private ProgressBar mProgressBar;

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public MyJsBridgeWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mProgressBar = new ProgressBar(context, null,
                android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.FILL_PARENT,
                4, 0, 0));

        Drawable drawable = context.getResources().getDrawable(R.drawable.progress_bar_states);
        mProgressBar.setProgressDrawable(drawable);
        addView(mProgressBar);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        AbsoluteLayout.LayoutParams lp = (AbsoluteLayout.LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                boolean scroll = true;
                if (isTop()) {     //是否滑到顶部
                    scroll = false;
                } else if (isBottom()) {    //是否滑到底部
                    scroll = false;
                }
                getParent().getParent().requestDisallowInterceptTouchEvent(scroll);
                break;
            case MotionEvent.ACTION_UP:
                getParent().getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.onTouchEvent(event);
    }

    private boolean isBottom() {
        float htmlHeight = getContentHeight() * getScale();
        float currentheight = getHeight() + getScrollY();
        return htmlHeight == currentheight;
    }

    private boolean isTop() {
        return getScrollY() == 0;
    }
}
