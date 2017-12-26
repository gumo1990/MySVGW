package com.example.administrator.mysvgw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by whq on 2017/12/26.
 * Guidle样式
 */

public class GuideAdapter extends PagerAdapter {
    private Context mContext;
    ArrayList<ImageView> list;
    public GuideAdapter(Context mContext, ArrayList<ImageView> mImageIds) {
        this.mContext = mContext;
        this.list = mImageIds;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * view式图样式
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = list.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
